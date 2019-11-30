package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.PostedbookRepository;
import com.example.demo.repository.RentRecordRepository;
import com.example.demo.repository.UsersRepository;
import com.example.demo.utils.TimeUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class RentRecordController {
    @Autowired
    private RentRecordRepository rrr;
    @Autowired
    private UsersRepository ur;
    @Autowired
    private PostedbookRepository pbr;

    @ApiOperation(value="查询历史购买记录")
    @RequestMapping(value = "/rent_history", method = RequestMethod.GET)
    @ResponseBody
    public List<RentRecord> renthistory(@RequestParam("open_id") String open_id) {
        List<RentRecord> l = rrr.findAllByRenterId(open_id);
        return l;
    }

    @ApiOperation(value="查询详细信息")
    @RequestMapping(value = "/detailRecord", method = RequestMethod.GET)
    @ResponseBody
    public RentRecordDetail detailRecord(@RequestParam("rent_recorder_id") Integer rent_recorder_id) {
        RentRecord rr=rrr.getOne(rent_recorder_id);
        RentRecordDetail rre=new RentRecordDetail();
        Postedbook pb=pbr.getOne(rr.getRent_id());
        rre.setBuyer_phone(ur.getOne(rr.getRenter_id()).getUserTelNum());
        rre.setSaler_phone(ur.getOne(pb.getRent_user_id()).getUserTelNum());
        rre.setPostedbook(pb);
        rre.setRentrecord(rr);
        return rre;
    }

    @ApiOperation(value="用户买书借书")
    @RequestMapping(value = "/rent", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Status addrentrecord(@RequestParam("rent_id") int rent_id, @RequestParam("open_id") String open_id, @Nullable @RequestParam("rent_time") int rent_time) {
        Status s = new Status();
        Optional<Users> op = ur.findById(open_id);
        if (!op.isPresent()) {
            s.setStatus(400);
            s.setMessage("用户不存在");
            return s;
        }
        Optional<Postedbook> op1 = pbr.findById(rent_id);
        if (!op1.isPresent()) {
            s.setStatus(400);
            s.setMessage("信息不存在");
            return s;
        }
        Postedbook pb = op1.get();
        Users u = op.get();
        if(pb.getCata().equals("1")){
            if (pb.getCata().equals("1")&&TimeUtils.getTimeAfterDays(new Date(), rent_time).after(pb.getDeadline())) {
                s.setStatus(400);
                s.setMessage("超出可借日期");
                return s;
            }
            if (pb.getDeposit() + rent_time * pb.getPrice() > u.getBalance()) {
                s.setStatus(400);
                s.setMessage("余额不足");
                return s;
            }
        }else if(pb.getCata().equals("0")){
            if (pb.getPrice() > u.getBalance()) {
                s.setStatus(400);
                s.setMessage("余额不足");
                return s;
            }
        }else{
            s.setMessage("类别不存在");
            s.setStatus(400);
            return s;
        }

//        if (pb.getRent_user_id().equals(open_id)) {
//            s.setStatus(400);
//            s.setMessage("无法购买自己的书");
//            return s;
//        }

        try {
            addrecordAndChangeBalance(pb, u, rent_time);
        } catch (Exception e) {
            s.setStatus(400);
            s.setMessage("交易繁忙");
            return s;
        }
        s.setStatus(200);
        s.setMessage("订购成功");
        return s;
    }

    @ApiOperation(value="卖方拒绝订单")
    @RequestMapping(value = "/refuse", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Status refuse(@RequestParam("rent_id") int rent_id) {
        Status s = new Status();
        Postedbook pb = pbr.getOne(rent_id);
        RentRecord rr = rrr.findPayedRecord(rent_id);
        try{
            refuse(pb,rr);
        }catch (Exception e){
            s.setStatus(400);
            s.setMessage("交易繁忙");
            return s;
        }
        s.setStatus(200);
        return s;
    }

    @ApiOperation(value="买方确认收货")
    @RequestMapping(value = "/confirmed", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Status confirm(@RequestParam("rent_recorder_id") int rent_recorder_id){
        Status s=new Status();
        RentRecord rr=rrr.findById(rent_recorder_id).get();
        Postedbook pb=pbr.getOne(rr.getRent_id());
        try{
            confirm(pb,rr);
        }catch (Exception e){
            s.setStatus(400);
            s.setMessage("交易繁忙");
            return s;
        }
        s.setStatus(200);
        return s;
    }


    @ApiOperation(value="卖方确认书籍归还.")
    @RequestMapping(value = "/confirm_send_back", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Status confirm1(@RequestParam("rent_id") int rent_id){
        Status s=new Status();
        Postedbook pb=pbr.getOne(rent_id);
        RentRecord rr=rrr.findconfirmedRecord(rent_id);
        try{
            confirm_send_back(pb,rr);
        }catch (Exception e){
            s.setStatus(400);
            s.setMessage("交易繁忙");
            return s;
        }
        s.setStatus(200);
        return s;
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public void confirm_send_back(Postedbook pb,RentRecord rr) {
        pb.setStatus("posted");
        rr.setStatus("finished");
        Users renter=ur.getOne(rr.getRenter_id());
        renter.setBalance(renter.getBalance()+pb.getDeposit());
        pbr.save(pb);
        rrr.save(rr);
        ur.save(renter);
    }
        @Transactional(propagation = Propagation.REQUIRED)
    public void addrecordAndChangeBalance(Postedbook pb, Users u, int rent_time) {            //事务，改变用户余额并生成租用条目

        pb.setStatus("rented");

        Double balance = u.getBalance();
        Double price=(pb.getCata().equals("0") ? pb.getPrice() : rent_time * pb.getPrice()) - (pb.getCata().equals("0") ? 0 : pb.getDeposit());
        balance = balance - price;
        u.setBalance(balance);
        ur.save(u);
        pbr.save(pb);

        Date time = new Date();
        Integer i=rent_time;

        RentRecord rr = new RentRecord();
        rr.setRent_id(pb.getRent_id());
        rr.setRenter_id(u.getUserId());
        rr.setCata(pb.getCata());
        rr.setRent_time(time);
        rr.setExpire_time(TimeUtils.getTimeAfterDays(time, rent_time));
        rr.setStatus("payed");
        rr.setUnused1(pb.getBook_name());
        rr.setUnused2(pb.getPicture());
        rr.setUnused3(price.toString());
        rr.setUnused4(i.toString());
        rrr.save(rr);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void refuse(Postedbook pb, RentRecord rr) {            //事务，改变用户余额并生成租用条目
        pb.setStatus("posted");
        Users renter = ur.findById(rr.getRenter_id()).get();
        double balance=renter.getBalance();
        balance=balance + (pb.getCata().equals("0") ? pb.getPrice() : Integer.parseInt(rr.getUnused4()) * pb.getPrice()) + (pb.getCata().equals("0") ? 0 : pb.getDeposit());
        renter.setBalance(balance);
        rr.setStatus("canceled");
        ur.save(renter);
        pbr.save(pb);
        rrr.save(rr);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public void confirm(Postedbook pb, RentRecord rr) {            //事务，改变用户余额并生成租用条目
        rr.setStatus("confirmed");
        Users u = ur.getOne(pb.getRent_user_id());
        double balance=u.getBalance();
        balance=balance+(pb.getCata().equals("0") ? pb.getPrice() : Integer.parseInt(rr.getUnused4()) * pb.getPrice());
        u.setBalance(balance);
        ur.save(u);
        rrr.save(rr);
    }


}