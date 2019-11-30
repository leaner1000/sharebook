package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Booktypeinfo;
import com.example.demo.repository.BooktypeinfoRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.utils.Isbn;
import com.alibaba.fastjson.JSON;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Controller
public class BooktypeinfoController {
    @Autowired
    BooktypeinfoRepository br;

    @ApiOperation(value="根据isbn号通过api获取书籍信息")
    @RequestMapping(value = "/booktype",method = {RequestMethod.GET})     //根据isbn号通过api获取书籍信息
    @ResponseBody
    public Booktypeinfo booktypeinfoUpdate(@RequestParam("isbn") String isbn) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        Optional<Booktypeinfo> op = br.findById(isbn);
        if(!op.isPresent()){
            String tmp=Isbn.getData(isbn);
            JSONObject obj = JSON.parseObject(tmp);
            Integer status = obj.getInteger("status");
            if(status != 0){
                return null;
            }else{
                JSONObject res = obj.getJSONObject("result");
                Booktypeinfo booktypeinfo = new Booktypeinfo();
                booktypeinfo.setAuthor(res.getString("author"));
                booktypeinfo.setBinding(res.getString("binding"));
                booktypeinfo.setIsbn(res.getString("isbn"));
                booktypeinfo.setPic(res.getString("pic"));
                booktypeinfo.setPrice(res.getString("price"));
                booktypeinfo.setPubdate(res.getString("pubdate"));
                booktypeinfo.setPublisher(res.getString("publisher"));
                booktypeinfo.setPubplace(res.getString("pubplace"));
                booktypeinfo.setSubtitle(res.getString("subtitle"));
                booktypeinfo.setSummary(res.getString("summary"));
                booktypeinfo.setTitle(res.getString("title"));
                br.save(booktypeinfo);
                return booktypeinfo;
            }
        }
        return op.get();
    }
}
