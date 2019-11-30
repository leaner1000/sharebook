package com.example.demo.controller;

import java.io.File;

import com.example.demo.entity.Postedbook;
import com.example.demo.entity.RentRecord;
import com.example.demo.entity.Status;
import com.example.demo.repository.PostedbookRepository;
import com.example.demo.repository.RentRecordRepository;
import com.example.demo.utils.TimeUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@PropertySource("classpath:mypath.properties")
public class PostedbookController {
    @Autowired
    private PostedbookRepository pbr;
    @Autowired
    private RentRecordRepository rrr;
    @Value("${zhangxile.top.path}")
    public String path;

    @ApiOperation(value="下架")
    @RequestMapping(value = "/deleteposted", method = RequestMethod.GET)
    @ResponseBody
    public Status deleteposted(@RequestParam("rent_id") int rent_id, @RequestParam("open_id") String open_id) {
        Status s = new Status();
        Postedbook pb = pbr.findById(rent_id).get();
        if (pb.getStatus().equals("rented")&&pb.getCata().equals("0")) {
            s.setStatus(400);
            s.setMessage("已卖出");
            s.setData(pb);
            return s;
        } else if (pb.getStatus().equals("rented")&&pb.getCata().equals("1")) {
            s.setMessage("已租出");
            s.setStatus(400);
            return s;
        } else if (!open_id.equals(pb.getRent_user_id())) {
            s.setStatus(400);
            s.setMessage("无权操作");
            return s;
        }
        pb.setStatus("deleted");
        pbr.save(pb);
        s.setMessage("下架成功");
        s.setStatus(200);
        return s;
    }

    @ApiOperation(value="上传书籍")
    @RequestMapping(value = "/bookupdate",method={RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Status bookUpdate(MultipartFile picture,Postedbook pb,BindingResult br){       //书籍上传
        Status s = new Status();
        try {
            String time=System.currentTimeMillis()+".jpg";
            String path = this.path+time;
            picture.transferTo(new File(path));
            pb.setPicture("/img/"+time);
            pb.setStatus("posted");
            if(pb.getCata().equals("0")){
                pb.setRent_time(9999);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            pb.setDeadline(TimeUtils.getTimeAfterDays(new Date(),pb.getRent_time()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        pbr.save(pb);
        s.setStatus(200);
        return s;
    }

    @ApiOperation(value="查找对应购买记录",notes="未购买状态下返回null")
    @RequestMapping(value="/getrentrecord",method = RequestMethod.GET)
    @ResponseBody
    public List<RentRecord> getrentrecord(@RequestParam("rent_id") Integer rent_id){
        List<RentRecord> rr=rrr.findByRent_id(rent_id);
        return rr;
    }

    @ApiOperation(value="查找对应用户购买记录",notes="未购买状态下返回null")
    @RequestMapping(value="/userpostedstatus",method = RequestMethod.GET)
    @ResponseBody
    public List<RentRecord> getrentrecord(@RequestParam("open_id") String open_id){
        List<Postedbook> lp=pbr.findAllByRent_user_id(open_id);
        List<RentRecord> lr=new ArrayList<>();
        for (Postedbook pb:lp){
            lr.addAll(rrr.findByRent_id(pb.getRent_id()));
        }
        return lr;
    }

    @ApiOperation(value="查询发布信息")
    @RequestMapping(value="/postedbook",method = RequestMethod.GET)
    @ResponseBody
    public Postedbook getpentrecord(@RequestParam("rent_id") Integer rent_id){
        Optional<Postedbook> op = pbr.findById(rent_id);
        return op.isPresent()?op.get():null;
    }

    @ApiOperation(value="查询发布信息",notes="可传入数组")
    @RequestMapping(value="/postedbooklist",method = RequestMethod.GET)
    @ResponseBody
    public List<Postedbook> getpentrecord(@RequestParam("rent_id") Integer[] rent_id){
        List<Postedbook> lp=new ArrayList<Postedbook>();
        for(Integer i:rent_id){
            Optional<Postedbook> op = pbr.findById(i);
            if(op.isPresent()){
                lp.add(op.get());
            }
        }
        return lp;
    }

    @ApiOperation(value="查寻书籍")
    @RequestMapping(value="/searchrentbook",method = RequestMethod.GET)
    @ResponseBody
    public List<Postedbook> searchrentbook(String isbn,String book_name){
        if(isbn==null){
            isbn="";
        }
        if (book_name==null){
            book_name="";
        }
        return pbr.findAllByIsbnOrBookName(isbn,book_name);
    }

    @ApiOperation(value="查寻发布记录")
    @RequestMapping(value="/postedhistory",method = RequestMethod.GET)
    @ResponseBody
    public List<Postedbook> postedhistory(@RequestParam("open_id") String open_id){
        List<Postedbook> lp=pbr.findAllByRent_user_id(open_id);
        return lp;
    }
}
