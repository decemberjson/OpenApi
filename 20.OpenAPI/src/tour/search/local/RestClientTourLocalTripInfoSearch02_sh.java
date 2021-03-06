package tour.search.local;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import tour.service.domain.TourTripInfoTest_sh;

/*
MiniProject 08.Model2MVCShop(Rest Client) 와 동일하게 수정
실행시 도메인 객체로 바인딩 확인
*/


public class RestClientTourLocalTripInfoSearch02_sh {

	 public static void main(String[] args) throws Exception {
		 
		// JsonSimple 
//		 RestClientTourLocalTripInfoSearch02_sh.getTourTest_JsonSimple(); 
		 
		// Codehaus
		RestClientTourLocalTripInfoSearch02_sh.getTourTest_Codehaus();
	 }
	 
		// JsonSimple 
		public static void getTourTest_JsonSimple() throws Exception {

			// HttpClient : Http Protocol 의 client 추상화
			HttpClient httpClient = new DefaultHttpClient();

			String url = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon"; /*URL*/
	        String myKey = "ay3zIymuP5LX%2BGZhKC44TDdl68jrGAk5sMJ2Ry5GkBV0TvUP14kU13EG1mkNneM4GQOTPDsVuj2%2BCKLpcwcvfg%3D%3D";
	        
	        // Essential                                                                        
	        String serviceKey = "?ServiceKey=" + myKey;          	/*서비스인증*/                                  
	        String mobileOS = "&MobileOS=ETC";                   	/*IOS(아이폰),AND(안드로이드),WIN(원도우폰),ETC*/      
	        String mobileApp = "&MobileApp=AppTest";             	/*서비스명=어플명*/                               
	        String contentId = "&contentId=126508";              	/*콘텐츠 ID*/                                 
	        
	        // Option
	        String numOfRows = "&numOfRows=10";                  	/*한 페이지 결과 수*/ 
	        String pageNo = "&pageNo=1";                         	/*현재 페이지 번호*/  
	        String contentTypeId = "&contentTypeId=14";          	/*관광타입(관광지, 숙박 등) ID*/          
	        String defaultYN = "&defaultYN=Y";                    	/*기본정보 조회여부*/                   
	        String firstImageYN = "&firstImageYN=Y";             	/*원본, 썸네일 대표이미지 조회여부*/          
	        String areacodeYN = "&areacodeYN=Y";                 	/*지역코드, 시군구코드 조회여부*/            
	        String catcodeYN = "&catcodeYN=Y";                   	/*서비스분류코드(대,중,소 코드) 조회여부*/      
	        String addrinfoYN = "&addrinfoYN=Y";                 	/*주소, 상세주소 조회여부*/               
	        String mapinfoYN = "&mapinfoYN=Y";                   	/*좌표 X,Y 조회여부*/                 
	        String overviewYN = "&overviewYN=Y";                 	/*콘텐츠 개요 조회여부*/                 
	        
	        HttpGet httpGet = new HttpGet(url + serviceKey + mobileOS + mobileApp + contentId + numOfRows
	        		+ pageNo + contentTypeId + defaultYN + firstImageYN + areacodeYN 
	        		+ catcodeYN + addrinfoYN + mapinfoYN + overviewYN);
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
	public static void getTourTest_Codehaus() throws Exception {

		HttpClient httpClient = new DefaultHttpClient();

		// StringBuilder urlBuilder = new
		// StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon");
		// /*URL*/
		String url = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon"; /* URL */
		String myKey = "ay3zIymuP5LX%2BGZhKC44TDdl68jrGAk5sMJ2Ry5GkBV0TvUP14kU13EG1mkNneM4GQOTPDsVuj2%2BCKLpcwcvfg%3D%3D";

		// Essential
		String serviceKey = "?ServiceKey=" + myKey;					/* 서비스인증 */
		String mobileOS = "&MobileOS=ETC"; 							/* IOS(아이폰),AND(안드로이드),WIN(원도우폰),ETC */
		String mobileApp = "&MobileApp=AppTest"; 					/* 서비스명=어플명 */
		String contentId = "&contentId=126508"; 					/* 콘텐츠 ID */

		// Option`
		String numOfRows = "&numOfRows=10"; 						/* 한 페이지 결과 수 */
		String pageNo = "&pageNo=1"; 								/* 현재 페이지 번호 */
		String contentTypeId = "&contentTypeId="; 					/* 관광타입(관광지, 숙박 등) ID */
		String defaultYN = "&defaultYN="; 							/* 기본정보 조회여부 */
		String firstImageYN = "&firstImageYN=Y"; 					/* 원본, 썸네일 대표이미지 조회여부 */
		String areacodeYN = "&areacodeYN=Y"; 						/* 지역코드, 시군구코드 조회여부 */
		String catcodeYN = "&catcodeYN=Y"; 							/* 서비스분류코드(대,중,소 코드) 조회여부 */
		String addrinfoYN = "&addrinfoYN=Y";						/* 주소, 상세주소 조회여부 */
		String mapinfoYN = "&mapinfoYN=Y"; 							/* 좌표 X,Y 조회여부 */
		String overviewYN = "&overviewYN=Y"; 						/* 콘텐츠 개요 조회여부 */

		HttpGet httpGet = new HttpGet(
				url + serviceKey + mobileOS + mobileApp + contentId + numOfRows + pageNo + contentTypeId + defaultYN
						+ firstImageYN + areacodeYN + catcodeYN + addrinfoYN + mapinfoYN + overviewYN);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");

		HttpResponse httpResponse = httpClient.execute(httpGet);
		System.out.println(httpResponse);
		System.out.println();

		HttpEntity httpEntity = httpResponse.getEntity();

		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		
		JSONObject jsonobj = (JSONObject) JSONValue.parse(br);
		System.out.println("[1 : jsonobj] ==>" + jsonobj);
		System.out.println("===================================================");
		JSONObject response = (JSONObject) jsonobj.get("response");
		System.out.println("[2 : response] ==>" + response);
		System.out.println("===================================================");
		JSONObject header = (JSONObject) response.get("header");
		System.out.println("[3 : header] ==>" + header);
		System.out.println("===================================================");
		JSONObject body = (JSONObject) response.get("body");
		System.out.println("[4 : body] ==>" + body);
		System.out.println("===================================================");
		JSONObject items = (JSONObject) body.get("items");
		System.out.println("[5 : items] ==>" + items);
		System.out.println("===================================================");
		JSONObject item = (JSONObject) items.get("item");
		System.out.println("[6 : item] ==>" + item);

		ObjectMapper objectMapper = new ObjectMapper();
		TourTripInfoTest_sh tourTripInfoTest = new TourTripInfoTest_sh();
		tourTripInfoTest = objectMapper.readValue(item.toJSONString(), TourTripInfoTest_sh.class);

		System.out.println("===================================================");
		System.out.println(tourTripInfoTest);
		System.out.println("===================================================");
		System.out.println(tourTripInfoTest.getAddr2());
		
	}

} // end of class
