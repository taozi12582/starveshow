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
@RequestMapping("/starve")
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

    @PostMapping("/echo")
    @ResponseBody
    public String test(Model model, @RequestParam(value = "name", required = false, defaultValue = "猫了个咪") String name) {
//        model.addAttribute("response", name);
//        model.addAttribute("post111", "我是post方法");
        System.out.println(model.getAttribute("name"));
        System.out.println(name);
        return null;
    }
}
