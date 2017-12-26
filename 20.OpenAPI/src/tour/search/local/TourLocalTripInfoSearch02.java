package tour.search.local;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.codehaus.jackson.map.ObjectMapper;

public class TourLocalTripInfoSearch02 {

	 public static void main(String[] args) throws IOException {
	        StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon"); /*URL*/
	        String serviceKey = "ay3zIymuP5LX%2BGZhKC44TDdl68jrGAk5sMJ2Ry5GkBV0TvUP14kU13EG1mkNneM4GQOTPDsVuj2%2BCKLpcwcvfg%3D%3D";
	        
	        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + serviceKey); 									 /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("SERVICE_KEY", "UTF-8")); 	 /*�꽌鍮꾩뒪�씤利�*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8"));				 /*�븳 �럹�씠吏� 寃곌낵 �닔*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));				     /*�쁽�옱 �럹�씠吏� 踰덊샇*/
	        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); 				 /*IOS(�븘�씠�룿),AND(�븞�뱶濡쒖씠�뱶),WIN(�썝�룄�슦�룿),ETC*/
	        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8"));			 /*�꽌鍮꾩뒪紐�=�뼱�뵆紐�*/
	        urlBuilder.append("&" + URLEncoder.encode("contentId","UTF-8") + "=" + URLEncoder.encode("126508", "UTF-8"));			 /*肄섑뀗痢� ID*/
	        urlBuilder.append("&" + URLEncoder.encode("contentTypeId","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); 			 /*愿�愿묓��엯(愿�愿묒�, �닕諛� �벑) ID*/
	        urlBuilder.append("&" + URLEncoder.encode("defaultYN","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); 				 /*湲곕낯�젙蹂� 議고쉶�뿬遺�*/
	        urlBuilder.append("&" + URLEncoder.encode("firstImageYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); 			 /*�썝蹂�, �뜽�꽕�씪 ���몴�씠誘몄� 議고쉶�뿬遺�*/
	        urlBuilder.append("&" + URLEncoder.encode("areacodeYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8"));				 /*吏��뿭肄붾뱶, �떆援곌뎄肄붾뱶 議고쉶�뿬遺�*/
	        urlBuilder.append("&" + URLEncoder.encode("catcodeYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8"));				 /*�꽌鍮꾩뒪遺꾨쪟肄붾뱶(��,以�,�냼 肄붾뱶) 議고쉶�뿬遺�*/
	        urlBuilder.append("&" + URLEncoder.encode("addrinfoYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); 				 /*二쇱냼, �긽�꽭二쇱냼 議고쉶�뿬遺�*/
	        urlBuilder.append("&" + URLEncoder.encode("mapinfoYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); 				 /*醫뚰몴 X,Y 議고쉶�뿬遺�*/
	        urlBuilder.append("&" + URLEncoder.encode("overviewYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8"));				 /*肄섑뀗痢� 媛쒖슂 議고쉶�뿬遺�*/
	        
	        ObjectMapper objectMapper = new ObjectMapper();
	        
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Accept", "application/json");
	        conn.setRequestProperty("Content-type", "application/json;charset=UTF-8");
	        
	        System.out.println("Response code: " + conn.getResponseCode());
	        
	        BufferedReader br;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = br.readLine()) != null) {
	            sb.append(line);
	        }
	        br.close();
	        conn.disconnect();
	        System.out.println(sb.toString());
	    }
	
} // end of class
