package com.taozi.starveshow.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.PrintStream;

@Component("module")
public class SenderCommander {
    @Autowired
    private PrintStream commander;

    public void doExecute(String todo){
        commander.println(todo);
    }

    public void startServer(){
        commander.println("su steam");
        commander.println("~/startDST.sh");
    }

    public void test2(){
        System.out.println("2222222");
    }

    public void test3(){
        System.out.println("33333333");
    }
}
