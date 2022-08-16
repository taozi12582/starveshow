package com.taozi.starveshow.controller;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
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

    @PostMapping("/downloadMods")
    public void downloadMods(HttpServletResponse response) throws Exception {
        String codedFileName = "EN";
        response.setHeader("Content-Disposition", "attachment;filename=" +             codedFileName + ".xml");
        // 响应类型,编码
        response.setContentType("application/octet-stream;charset=UTF-8");
        // 形成输出流
        OutputStream osOut = response.getOutputStream();
//        File xmlFileC = new
//                File("/databaseclient/src/main/resources/Files/EN2.xml");
        ChannelSftp channel = (ChannelSftp) session.openChannel("sftp");
        channel.connect();
        String remoteFile = "/home/steam/Steam/steamapps/common/Don't Starve Together Dedicated Server/mods.zip";
        InputStream input = channel.get(remoteFile);
//        InputStream input = null;
        try {
//            input = new FileInputStream(xmlFileC);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                osOut.write(buf, 0, bytesRead);
            }
        } finally {
            input.close();
            osOut.close();
        }
    }

}
