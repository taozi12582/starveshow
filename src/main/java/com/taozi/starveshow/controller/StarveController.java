package com.taozi.starveshow.controller;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.io.PrintStream;

@Controller
@RequestMapping("/starve")
public class StarveController {

    @Autowired
    private Session session;
    @Autowired
    private Channel channel;
    @Autowired
    private PrintStream commander;

    @RequestMapping("/op")
    public String t1() {
        return "echo.html";
    }

    @PostMapping("/startServer")
    @ResponseBody
    public String startServer(){
        commander.println("~/startDST.sh");
        return null;
    }

    @PostMapping("/shutdownServer")
    @ResponseBody
    public String shutdownServer(){
        commander.println("c_shutdown()");
        commander.println("c_shutdown()");
        return null;
    }
}
