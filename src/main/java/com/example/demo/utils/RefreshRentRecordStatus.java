package com.example.demo.utils;


import com.example.demo.entity.Postedbook;
import com.example.demo.entity.RentRecord;
import com.example.demo.entity.Users;
import com.example.demo.repository.PostedbookRepository;
import com.example.demo.repository.RentRecordRepository;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Component
@EnableScheduling//可以在启动类上注解也可以在当前文件
public class RefreshRentRecordStatus {
    @Autowired
    private PostedbookRepository pbr;
    @Autowired
    private RentRecordRepository rrr;
    @Autowired
    private UsersRepository ur;
    @Scheduled(cron = "0 0 0 * * ?")
    public void runfirst(){
        List<RentRecord> l=rrr.findAll();
        for(RentRecord rr:l){
            if(rr.getCata().equals("1")&&rr.getStatus().equals("comfirmed")){
                if(new Date().after(rr.getExpire_time())){                             //逾期
                    if(new Date().before(TimeUtils.getTimeAfterDays(rr.getExpire_time(),7))){         //逾期7天内
                        pay_falsify(pbr.getOne(rr.getRent_id()),rr);
                    }else{
                        rent_time_out(pbr.getOne(rr.getRent_id()),rr);
                    }
                }
            }
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void pay_falsify( Postedbook pb,RentRecord rr) {
        Users u =ur.getOne(pb.getRent_user_id());
        Users renter=ur.getOne(rr.getRenter_id());
        if(renter.getBalance()>pb.getPrice()){
            renter.setBalance(renter.getBalance()-pb.getPrice());
            u.setBalance(u.getBalance()+pb.getPrice());
            ur.save(u);
            ur.save(renter);
        }else{
            rent_time_out(pb,rr);
        }
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public void rent_time_out( Postedbook pb,RentRecord rr) {
        Users u =ur.getOne(pb.getRent_user_id());
        Double balance = u.getBalance();
        balance=balance+pb.getDeposit();
        u.setBalance(balance);
        rr.setStatus("time_out");
        rrr.save(rr);
    }
}


