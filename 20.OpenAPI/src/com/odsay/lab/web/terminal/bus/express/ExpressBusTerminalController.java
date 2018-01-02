package com.odsay.lab.web.terminal.bus.express;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

///*
@Controller
@RequestMapping("/ExpressBus/*")
public class ExpressBusTerminalController {

	public ExpressBusTerminalController() {
		System.out.println(this.getClass());
	}
	
	@RequestMapping( value="getTerminalInfo", method=RequestMethod.POST)
	public String getProduct( @RequestParam("language") String language ,  
			@RequestParam("terminalName") String terminalName ) throws Exception {
		
		System.out.println("/ExpressBus/getTerminalInfo : POST");
		System.out.println("[1]" + language);
		System.out.println("[2]" + terminalName);
		
		
		return null;
	}
} // end of Class
//*/
