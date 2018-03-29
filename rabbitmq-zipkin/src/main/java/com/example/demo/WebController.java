package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class WebController {
	
	@Autowired
	Publisher publisher;
	
	@RequestMapping("/send")
	public String sendMsg(){
		String msg="sending";
		publisher.produceMsg(msg);
		return "Done";
	}
}
