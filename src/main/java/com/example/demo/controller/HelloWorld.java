package com.example.demo.controller;

import com.example.demo.common.RedisUtil;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by zeng on 2017/6/22.
 */
@Controller
public class HelloWorld {

    @Autowired
    private UserMapper userMapper;

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String Sender;

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String index(){
        return "Hello World~";
    }

    @RequestMapping(value="/model",method = RequestMethod.GET)
    public String model(Model model){
        userMapper.getUserList();
        model.addAttribute("name","曾晨曦");
        return "model";
    }

    @RequestMapping(value="/mybatis",method = RequestMethod.GET)
    public String mybatis(Model model){
        redisUtil.set("userList", userMapper.getUserList());
        model.addAttribute("userList",redisUtil.get("userList"));
        redisUtil.set("test", "测试redis是否可用");
        model.addAttribute("test",redisUtil.get("test"));

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(Sender);
        message.setTo(Sender);
        message.setSubject("主题：测试邮件功能");
        message.setText("测试邮件功能");
        mailSender.send(message);

        return "mybatis";
    }
}
