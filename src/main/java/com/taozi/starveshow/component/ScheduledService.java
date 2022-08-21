package com.taozi.starveshow.component;

import com.jcraft.jsch.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.PrintStream;

@Component
public class ScheduledService {
    private static final Logger log = LoggerFactory.getLogger(ScheduledService.class);
    @Autowired
    private PrintStream commander;

    @Scheduled(cron = "0 0 */1 * * ?")
    public void scheduled(){
        log.info("维持session连接");
        commander.println("echo hello");
    }
}