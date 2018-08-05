package com.demo.Websocket;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebSocketController {
	
	private SimpMessagingTemplate template;

	@Autowired
	public WebSocketController(SimpMessagingTemplate template) {
		super();
		this.template = template;
	}
	
	@MessageMapping("/send/message2")
	public void onReceiveMessage1(Case tempCase) {				
		this.template.convertAndSend("/chat", tempCase);
	}
	
	
	
	@RequestMapping("/send/message1")
	public void invokeMethod() throws InterruptedException {
		System.out.println("Inside Invoke Method");
		Case temp = new Case();
		temp.setCusip("123456");
		boolean cont = true;
		int counter = 1;
		String marketAction = "Y";
		temp.setMarketAction(marketAction);
		while(cont) {
			temp.setDate(Calendar.getInstance().getTime());
			if(counter < 6) {
				counter++;
			} else {
				marketAction="N";
				temp.setMarketAction(marketAction);
				cont = false;
			}
			onReceiveMessage1(temp);
			Thread.sleep(5000);
		}
		System.out.println("Completed Invoke Method");
	}
	
	

}
