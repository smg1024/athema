package com.athema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.athema.dto.MsgDTO;

@Controller
public class MsgController {
	
	@Autowired
	SimpMessagingTemplate template;
	
	@MessageMapping("/receiveall") // 모두에게 전송
	public void receiveall(MsgDTO msg, SimpMessageHeaderAccessor headerAccessor) {
		System.out.println(msg);
		template.convertAndSend("/send",msg);
	}
	@MessageMapping("/receiveme") // 나에게만 전송 ex)Chatbot
	public void receiveme(MsgDTO msg, SimpMessageHeaderAccessor headerAccessor) {
		String id = msg.getSendid();
		msg.setContent2("TR Message");
		template.convertAndSend("/send/"+id,msg);
	}
	@MessageMapping("/receiveto") // 특정 Id에게 전송
	public void receiveto(MsgDTO msg, SimpMessageHeaderAccessor headerAccessor) {
		String id = msg.getSendid();
		String target = msg.getReceiveid();
		template.convertAndSend("/send/to/"+target,msg);
	}
}
