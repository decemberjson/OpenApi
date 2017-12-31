package com.odsay.lab.web.terminal.bus.express;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ExpressBus/*")
public class ExpressBusTerminalRestController {

	public ExpressBusTerminalRestController() {
		System.out.println(this.getClass());
	}
	
	@RequestMapping( value="json/getTerminalInfo/{language}/{terminalName}", method=RequestMethod.GET)
	public String getTerminalInfo( @RequestParam("language") int language, 
			@RequestParam("terminalName") String terminalName) throws Exception {
		
		System.out.println("/ExpressBus/getTerminalInfo : POST");
		
		String yuriServiceKey = "0ObaGjz7q8kLrzbsVutNT0qpRKpduNy7cnS9HDogmsk";
//		String danielServiceKey = "NGWqA2%2BBr3ddBK6GFTsvMdNW3uJ%2BtGTyJZxuXA4AD5g";
		String url = "https://api.odsay.com/api/expressBusTerminals";
		
		
		
		
		return null;
	}
	
} // end of Class
