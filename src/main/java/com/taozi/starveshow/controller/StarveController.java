package com.taozi.starveshow.controller;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

@Controller
//@RequestMapping("/starve")
public class StarveController {

    @Autowired
    private Session session;
    @Autowired
    private Channel channel;
    @Autowired
    private PrintStream commander;

    //    @RequestMapping("/starve/op")
//    public void test() throws JSchException, IOException {
//        OutputStream inputstream_for_the_channel = channel.getOutputStream();
//        PrintStream commander = new PrintStream(inputstream_for_the_channel, true);
//        channel.setOutputStream(System.out, true);
//        channel.connect();
//        commander.println("echo hello");
//    }
    @RequestMapping("/op")
    public String t1() {
        return "echo.html";
    }

    @PostMapping("/echo1")
    public String test(Model model, HashMap<String, Object> map, @RequestParam(value = "name", required = false, defaultValue = "猫了个咪") String name) {
        model.addAttribute("response", name);
        model.addAttribute("post111", "我是post方法");
        return "echo1";
    }

    @GetMapping("/hello1")
    public String hello(Map<String, Object> map) {
        //通过 map 向前台页面传递数据
        map.put("name", "编程帮（www.biancheng.net）");
        return "hello";
    }

    @GetMapping("index")//页面的url地址
    public String getindex(Model model)//对应函数
    {
        model.addAttribute("name","bigsai");
        return "/index";//与templates中index.html对应
    }
}
