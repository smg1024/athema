package com.athema;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.athema.dto.Msg;

@Component
public class Scheduler {
	@Autowired
	private SimpMessageSendingOperations messagingTemplate;

    @Scheduled(cron = "*/5 * * * * *")
    public void cronJobDailyUpdate() {
    	Msg msg = new Msg();
    	
    	Random r = new Random();
    	int i = r.nextInt(100)+1;
    	int j = r.nextInt(1000)+1;
    	
    	msg.setContent1(i+"");
    	msg.setContent2(j+"");
//    	System.out.println("----------- Scheduler ------------"+i);
    	
    	messagingTemplate.convertAndSend("/broadcast", msg);
    }

    @Scheduled(cron = "1 0 0 1,8,15,22 * *")
    public void cronJobWeeklyUpdate(){

    }
}
