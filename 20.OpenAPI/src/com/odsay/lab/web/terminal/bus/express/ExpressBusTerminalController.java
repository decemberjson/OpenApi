package com.odsay.lab.web.terminal.bus.express;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import odsay.service.domain.ExpressBusTerminal_sh;

@Controller
@RequestMapping("/ExpressBus/*")
public class ExpressBusTerminalController {

	public ExpressBusTerminalController() {
		System.out.println(this.getClass());
	}
	
	@RequestMapping( value="getTerminalInfo", method=RequestMethod.POST)
	public String getTerminalInfo( 
			@ModelAttribute("ExpressBusTerminal_sh") ExpressBusTerminal_sh expressBusTerminal 
			) throws Exception {
		
		System.out.println("/ExpressBus/getTerminalInfo : POST");
		
		
		
		// HttpClient : Http Protocol 의 client 추상화
		HttpClient httpClient = new DefaultHttpClient();
		
		String yuriApiKey = "0ObaGjz7q8kLrzbsVutNT0qpRKpduNy7cnS9HDogmsk";
//		String danielApiKey = "NGWqA2%2BBr3ddBK6GFTsvMdNW3uJ%2BtGTyJZxuXA4AD5g";
		String url = "https://api.odsay.com/api/expressBusTerminals";
		
		// Essential Parameter Value
		String apiKey = "?apiKey=" + yuriApiKey;											//내가 받은 apiKey
		String langVal = "&lang=" + expressBusTerminal.getLanguage();							//언어선택
		String terminalNameVal = "&terminalName=" + expressBusTerminal.getTerminalName();	//터미널명
		
		HttpGet httpGet = new HttpGet(url + apiKey + langVal + terminalNameVal);
        httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");
		
		// HttpResponse : Http Protocol 응답 Message 추상화
		HttpResponse httpResponse = httpClient.execute(httpGet);

		// ==> Response 확인
		System.out.println(httpResponse);
		System.out.println();
		
		// ==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();

		// ==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		System.out.println("[ Server 에서 받은 Data 확인 ] ");
		String serverData = br.readLine();
		System.out.println(serverData);

		// ==> 내용읽기(JSON Value 확인)
		JSONObject jsonobj = (JSONObject) JSONValue.parse(serverData);
		System.out.println("===================================================");
		System.out.println("[jsonobj 확인] : " + jsonobj);
		
		return "forward:/Odsay/getExpressBusTerminal_sh.jsp";
	}
	
} // end of Class
