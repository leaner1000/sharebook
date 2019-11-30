package com.example.demo.controller;

import com.example.demo.entity.Postedbook;
import com.example.demo.repository.PostedbookRepository;
import com.example.demo.utils.HttpGetUtil;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Status;
import com.example.demo.entity.Users;
import com.example.demo.repository.UsersRepository;
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


import java.io.UnsupportedEncodingException;
import java.util.*;

@Controller
public class UsersController {
    @Autowired
    private UsersRepository ur;
    @Autowired
    private PostedbookRepository pbr;

    @ApiOperation(value="查询用户信息")
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @ResponseBody
    public Users getUsers(@RequestParam("open_id") String open_id){
        Optional<Users> op = ur.findById(open_id);
        return op.isPresent()?op.get():null;
    }

    @ApiOperation(value="注册")
    @RequestMapping(value = "/regist",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Status regist(@RequestParam("open_id") String open_id,@Nullable  @RequestParam("phone") String phone) throws UnsupportedEncodingException {
        Status s=new Status();
        if(phone==null){
            s.setStatus(400);
            s.setMessage("请输入电话号码");
        }
        if(ur.findById(open_id).isPresent()){
            s.setStatus(400);
            s.setMessage("用户已存在无需注册");
        }else{
            Users u=new Users();
            u.setUserId(open_id);
            u.setUserTelNum(phone);
            ur.save(u);
            s.setStatus(200);
        }
        return s;
    }


}
