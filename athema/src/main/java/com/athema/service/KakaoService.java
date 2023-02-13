package com.athema.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class KakaoService {
	public String getAccessToken (String authorize_code) {
		String access_token = "";
		String refresh_token = "";
		String reqURL = "https://kauth.kakao.com/oauth/token";
		try {
			// url 클래스 생성
			URL url = new URL(reqURL);
			// url Connection을 HTTP로 설정
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// OutputStream으로 POST 데이터를 전달할 것
			conn.setRequestMethod("POST");
			conn.setDoOutput(true); 	//기본값이 false이므로
			
			// 출력할 OutputStream(바이트스트림) > OutputStreamWriter(문자스트림) 객체 생성 > BufferedWriter에 주입
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			// BufferedWriter가 Sysout보다 속도측면에서 훨씬 빠르고 효율적, 많은 양의 데이터 처리에 용이
			
			StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");	// 필수 파라미터 (고정값)
            sb.append("&client_id=9740cda4f593e49b4bf7b3235435574d");	// 필수 파라미터 (앱 REST API키)
            sb.append("&redirect_uri=http://49.50.166.168/oauth/kakao");	// 필수 파라미터 (redirect URI)
//            sb.append("&redirect_uri=http://127.0.0.1/oauth/kakao");	// 필수 파라미터 (redirect URI)
            sb.append("&code=" + authorize_code);
            /* StringBuilder = grant_type=authorization_code&client_id=9740cda4f593e49b4bf7b3235435574d&redirect_uri=http://127.0.0.1/member/kakao&code=" + authorize_code */
            
            // 출력할 내용 담기
            bw.write(sb.toString());
            
            // 버퍼 비우기
            bw.flush();
            
            // responseCode가 200이면 성공
            int responseCode = conn.getResponseCode();
            System.out.println("getResponseCode() : " + responseCode);
            
            // Response된 데이터 (JSON형태) 읽기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            StringBuilder sbres = new StringBuilder();
            while ((line = br.readLine()) != null) {
            	sbres.append(line);
            }
            System.out.println("Response body : " + sbres);
            String result = sbres.toString();	/*파싱하려면 StringBuffer가 아니라 String이어야 하므로*/
            
            /* Maven에 Gson 라이브러리 추가 */
            /* JSON을 파싱하는 객체 생성 */
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);
            
            // Access token과 Refresh token 따로따로 꺼내오기
            // Response 이름은 API doc에 명시되어 있음
            access_token = element.getAsJsonObject().get("access_token").getAsString();
            refresh_token = element.getAsJsonObject().get("refresh_token").getAsString();
            
            System.out.println("access_token : " + access_token);
            System.out.println("refresh_token : " + refresh_token);
            
            br.close();
            bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return access_token;
		
	}
	
	
	public HashMap<String, Object> getUserInfo(String access_token) {
		HashMap<String, Object> userInfo = new HashMap<>();
		String reqURL = "https://kapi.kakao.com/v2/user/me";
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// POST 방식으로 보냄
			conn.setRequestMethod("POST");
			// Header에 포함될 내용, 모든 정보 받기 (API doc참고)
			conn.setRequestProperty("Authorization", "Bearer " + access_token);
			
			// 결과코드 200이면 성공
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);
			// 받아온 정보 읽기
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			String result = "";
			while ((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("response body : " + result);
			
			// JSON Object 파싱하기
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);
			
			JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();
			
			/*오류나면 아래 메소드부터 점검*/
			String nickname = kakao_account.getAsJsonObject().get("profile").getAsJsonObject().get("nickname").getAsString();
			String email = kakao_account.getAsJsonObject().get("email").getAsString();
			
			userInfo.put("nickname", nickname);
			userInfo.put("email", email);
			
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userInfo;
	}
	
}
