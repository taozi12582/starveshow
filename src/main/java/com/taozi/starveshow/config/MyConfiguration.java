package com.taozi.starveshow.config;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.taozi.starveshow.util.CentosUtil;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

@Configuration
@ConfigurationProperties(prefix = "centos")
@Data
public class MyConfiguration {
    private String ip;
    private String name;
    private String keyPath;
    private int port;

    @Bean
    public Session getSession() {
        return CentosUtil.getSessionAndConnect(keyPath, ip, name, port);
    }

    @Bean
    public Channel getChannel() throws JSchException {
        return CentosUtil.getChannel(getSession());
    }

    @Bean
    public ByteArrayOutputStream getOutputStream(){
        return new ByteArrayOutputStream();
    }

    @Bean
    public PrintStream getPrintStream() throws JSchException, IOException {
        Channel channel = getChannel();
        ByteArrayOutputStream os = getOutputStream();
        OutputStream inputstream_for_the_channel = channel.getOutputStream();
        PrintStream commander = new PrintStream(inputstream_for_the_channel, true);
        channel.setOutputStream(os, true);
        channel.connect();
        commander.println("su steam");
        return commander;
    }
}
