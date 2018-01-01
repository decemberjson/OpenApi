package odsay.search.terminal.bus.express;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import odsay.service.domain.ExpressBusTerminalResult_sh;
import odsay.service.domain.ExpressBusTerminalDestinations_sh;

/*
MiniProject 08.Model2MVCShop(Rest Client) 와 동일하게 수정
실행시 도메인 객체로 바인딩 확인
*/


public class RestClientExpressBusTerminal_sh {

	 public static void main(String[] args) throws Exception {
		 
		// JsonSimple 
//		 RestClientExpressBusTerminal_sh.getExpressBusTerminal_JsonSimple(); 
		 
		// Codehaus
		 RestClientExpressBusTerminal_sh.getExpressBusTerminal_Codehaus();
	 }
	 
	// JsonSimple
	public static void getExpressBusTerminal_JsonSimple() throws Exception {

		// HttpClient : Http Protocol 의 client 추상화
		HttpClient httpClient = new DefaultHttpClient();

		// Essential
		int languageType = 0;
		int CID = 1000;
		String terminalName = "동서울";

		String danielApiKey = "NGWqA2+Br3ddBK6GFTsvMdNW3uJ+tGTyJZxuXA4AD5g";
		String yuriApiKey = "0ObaGjz7q8kLrzbsVutNT0qpRKpduNy7cnS9HDogmsk";
		
		String encodeServerApiKey = URLEncoder.encode(danielApiKey);
		System.out.println("[서버키 인코딩 확인] ==>" + encodeServerApiKey);

		String url = "https://api.odsay.com/api/expressBusTerminals?apiKey=" + yuriApiKey + "&lang="
				+ languageType + "&terminalName=" + terminalName; /* URL */

		System.out.println("[url 확인] :: " + url);

		HttpGet httpGet = new HttpGet(url);
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

	}
	 
	 
	 
	// Codehaus
	public static void getExpressBusTerminal_Codehaus() throws Exception {

		HttpClient httpClient = new DefaultHttpClient();

		// Essential
		int languageType = 0;
		int CID = 1000;
		String terminalName = "동서울";

		String danielApiKey = "NGWqA2+Br3ddBK6GFTsvMdNW3uJ+tGTyJZxuXA4AD5g";
		String yuriApiKey = "0ObaGjz7q8kLrzbsVutNT0qpRKpduNy7cnS9HDogmsk";

		String encodeServerApiKey = URLEncoder.encode(danielApiKey);
		System.out.println("[서버키 인코딩 확인] ==>" + encodeServerApiKey);

		String url = "https://api.odsay.com/api/expressBusTerminals?apiKey=" 
		+ encodeServerApiKey + "&lang=" + languageType
				+ "&terminalName=" + terminalName; /* URL */

		System.out.println("[url 확인] :: " + url);

		HttpGet httpGet = new HttpGet(url);
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

		JSONObject jsonobj = (JSONObject) JSONValue.parse(br);
		System.out.println("[1 : jsonobj] ==>" + jsonobj);
		System.out.println("===================================================");
		JSONArray resultArr = (JSONArray) jsonobj.get("result");
		System.out.println("[2 : resultArr] ==>" + resultArr); 
		System.out.println("===================================================");
		JSONObject resultVal = (JSONObject) resultArr.get(0);
		System.out.println("[3 : resultVal] ==>" + resultVal); 
		System.out.println("===================================================");
		
		ObjectMapper resultMapper = new ObjectMapper();
		ExpressBusTerminalResult_sh expressBusTerminalResult = new ExpressBusTerminalResult_sh();
		expressBusTerminalResult = resultMapper.readValue(resultVal.toJSONString(), ExpressBusTerminalResult_sh.class);

		// Client가 검색한 검색값
		JSONArray destinationTerminalsArr = (JSONArray) resultVal.get("destinationTerminals");
		System.out.println("[4 : destinationTerminalsArr] ==>" + destinationTerminalsArr); 
		System.out.println("[4 : destinationTerminalsArr.size()] ==>" + destinationTerminalsArr.size()); 
		System.out.println("===================================================");
//		JSONObject destinationTerminalsVal = (JSONObject) destinationTerminalsArr.get(0);
//		System.out.println("[5 : destinationTerminalsVal] ==>" + destinationTerminalsVal); 
		System.out.println("===================================================");
		
		JSONObject destinationTerminalsVal = new JSONObject();
		for (int i = 0; i < destinationTerminalsArr.size(); i++) {
			destinationTerminalsVal = (JSONObject) destinationTerminalsArr.get(i);
			System.out.println(destinationTerminalsVal);
			/*
			ObjectMapper destinationsMapper = new ObjectMapper();
			ExpressBusTerminalDestinations_sh expressBusTerminalDestinations = new ExpressBusTerminalDestinations_sh();
			expressBusTerminalDestinations = destinationsMapper.readValue(destinationTerminalsVal.toJSONString(), ExpressBusTerminalDestinations_sh.class);
			System.out.println("[Destinations Domain toString]"+expressBusTerminalDestinations);
			//*/
		}
		

		/*
		System.out.println("==============================================[result]=====");
		System.out.println(expressBusTerminalResult);
		System.out.println("==============================================[ExpressBusTerminal Domain Value Check]=====");
		System.out.println("[도착터미널 True/False]:"+expressBusTerminalResult.isHaveDestinationTerminals());
		System.out.println("[터미널명]:"+expressBusTerminalResult.getStationName());
		System.out.println("[터미널ID]:"+expressBusTerminalResult.getStationID());
		System.out.println("[x좌표]:"+expressBusTerminalResult.getX());
		System.out.println("[y좌표]:"+expressBusTerminalResult.getY());
		
		System.out.println();
		System.out.println("[도착가능 터미널 리스트]");
		for (Object destinationTerminal : destinationTerminals) {
			System.out.println(destinationTerminal);
		}
		//*/
		
		

	}

} // end of class
