package com.taozi.starveshow.util;

import com.jcraft.jsch.*;

import java.util.Properties;

public class CentosUtil {
    public static Session getSessionAndConnect(String keyPath, String ip, String name, int port){
        Session session = null;
        JSch jSch = new JSch();
        try {
            jSch.addIdentity(keyPath);
            session = jSch.getSession(name, ip, port);

            //关闭主机密钥检查，否则会导致连接失败
            Properties properties = new Properties();
            properties.setProperty("StrictHostKeyChecking", "no");
            session.setConfig(properties);
            //打开会话，并设置超时时间
            session.connect(30000);
        } catch (JSchException e) {
            e.printStackTrace();
        }
        return session;
    }

    public static Channel getChannel(Session session) throws JSchException {
        return (ChannelShell) session.openChannel("shell");
    }
}
