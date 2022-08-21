package com.taozi.starveshow.controller;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

@Controller
@RequestMapping("/starve")
public class StarveController {

    @Autowired
    private Session session;
    @Autowired
    private Channel channel;
    @Autowired
    private PrintStream commander;
    @Autowired
    private ByteArrayOutputStream os;

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

    @PostMapping("/getConsole")
    @ResponseBody
    public String getConsole(){
        String s = os.toString();
        os.reset();
        return s;
    }

    @GetMapping("/login")
    public String login(){
        return "login.html";
    }

    @PostMapping ("/loginHandle")
    public String loginHandle(HttpServletRequest request){
        HttpSession sessoin=request.getSession();
        sessoin.setAttribute("flag","allow");
        return "echo.html";
    }

    @PostMapping("/updateServer")
    @ResponseBody
    public String updateServer(){
        commander.println("/home/steam/steamcmd/steamcmd.sh +login 2678163926 Tzx14726174876  +app_update 343050 validate +quit");
        return null;
    }

}
