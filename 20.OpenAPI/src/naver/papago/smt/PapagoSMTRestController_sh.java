package naver.papago.smt;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import naver.papago.domain.PapagoTranslateResult_sh;

public class PapagoSMTRestController_sh {

		 public static void main(String[] args) throws Exception {
			 
			 PapagoTranslateResult_sh ptr = new PapagoTranslateResult_sh();
			 PapagoSMTRestController_sh.getPapagoSMT_Codehaus(ptr.getTranslateSource());
		 }
		 
		// Codehaus
		public static void getPapagoSMT_Codehaus(String translateSource) throws Exception {

			String clientId = "368Klf3of4me0Y_gKmWW";	//애플리케이션 클라이언트 아이디값";
	        String clientSecret = "iVsRtMfdbD";			//애플리케이션 클라이언트 시크릿값";
	        try {
	        	
	        	String source = "en";
	        	String target = "ko";
	            String text = URLEncoder.encode(translateSource, "UTF-8");
	            String apiURL = "https://openapi.naver.com/v1/language/translate";
	            URL url = new URL(apiURL);
	            HttpURLConnection con = (HttpURLConnection)url.openConnection();
	            con.setRequestMethod("POST");
	            con.setRequestProperty("X-Naver-Client-Id", clientId);
	            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
	            // post request
	            String postParams = "source=" + source + "&target=" + target + "&text=" + text;
	            con.setDoOutput(true);
	            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	            wr.writeBytes(postParams);
	            wr.flush();
	            wr.close();
	            int responseCode = con.getResponseCode();
	            BufferedReader br;
	            if(responseCode==200) { // 정상 호출
	                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	                
	                ////////////////////////////////////////////////////////////////////////////////////////////
	                // [jsonSimple + codehaus]
	                System.out.println("====================================");
	                JSONObject jsonObj = (JSONObject) JSONValue.parse(br);
	                System.out.println("[jsonObj value] :: " + jsonObj);

	                JSONObject message = (JSONObject) jsonObj.get("message");
	                System.out.println("[message value] :: " + message);
	                
	                JSONObject result = (JSONObject) message.get("result");
	                System.out.println("[result value] :: " + result);
	                System.out.println("====================================");
	                
	                // [Binding] 
	                ObjectMapper translatedTextValue = new ObjectMapper();
	                PapagoTranslateResult_sh ptlr = new PapagoTranslateResult_sh();
	                ptlr = translatedTextValue.readValue(result.toJSONString(), PapagoTranslateResult_sh.class);
	                System.out.println(ptlr);
	                /////////////////////////////////////////////////////////////////////////////////////////////
	                
	            } else {  // 에러 발생
	                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	            }
	            String inputLine;
	            StringBuffer response = new StringBuffer();
	            while ((inputLine = br.readLine()) != null) {
	                response.append(inputLine);
	            }
	            br.close();
	            System.out.println(response.toString());
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	
} // end of class
