package com.athema.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatbotController {
	
	private String secretKey = "U1lleHZ4eVV4QklzZXJqYXlLR0dGWGNVTXJaUW9NR3Q=";
	private String apiUrl = "https://2ge512vs3b.apigw.ntruss.com/custom/v1/9142/df8cc921aca1dfb632858ac3fd6ba0585e1357a136f8aec753967fa79ec93cb0";
	
	public String getReqMessage(String voiceMessage) {

		String requestBody = "";

		try {

			JSONObject obj = new JSONObject();

			long timestamp = new Date().getTime();

			System.out.println("timestamp ##"+timestamp);

			obj.put("version", "v2");
			obj.put("userId", "U47b00b58c90f8e47428af8b7bddc1231heo2");
			obj.put("timestamp", timestamp);

			JSONObject bubbles_obj = new JSONObject();

			bubbles_obj.put("type", "text");

			JSONObject data_obj = new JSONObject();
			data_obj.put("description", voiceMessage);

			bubbles_obj.put("type", "text");
			bubbles_obj.put("data", data_obj);

			JSONArray bubbles_array = new JSONArray();
			bubbles_array.add(bubbles_obj);

			obj.put("bubbles", bubbles_array);
			obj.put("event", "send");

			requestBody = obj.toString();

		} catch (Exception e){
			System.out.println("## Exception : " + e);
		}

		return requestBody;

	}
	
	public String makeSignature(String message, String secretKey) {

		 String encodeBase64String = "";

	        try {
	            byte[] secrete_key_bytes = secretKey.getBytes("UTF-8");

	            SecretKeySpec signingKey = new SecretKeySpec(secrete_key_bytes, "HmacSHA256");
	            Mac mac = Mac.getInstance("HmacSHA256");
	            mac.init(signingKey);

	            byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
	         // base64의 라이브러리에서 encodeToString를 이용해서 byte[] 형식을 String 형식으로 변환
	            encodeBase64String = Base64.getEncoder().encodeToString(rawHmac);

	            return encodeBase64String;

	        } catch (Exception e){
	            System.out.println("인코딩 실패" + e);
	        }

	        return encodeBase64String;

	}
	
	@RequestMapping("/chatbot")
	public String about(String quest) throws IOException {
		
		URL url = new URL(apiUrl);
		String chatMessage = quest;
		String message =  getReqMessage(chatMessage);
		System.out.println("getReqMessage ##"+message);
		String encodeBase64String = makeSignature(message, secretKey);
		System.out.println("encodeBase64String ##"+encodeBase64String);
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json;UTF-8");
		con.setRequestProperty("X-NCP-CHATBOT_SIGNATURE", encodeBase64String);
		
		// post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.write(message.getBytes("UTF-8"));
		wr.flush();
		wr.close();
		
		int responseCode = con.getResponseCode();
		System.out.println("responseCode ##"+responseCode);

		BufferedReader br;

		if(responseCode==200) { // Normal call (정상)
//			System.out.println("response ##"+con.getResponseMessage());
			
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
							con.getInputStream()));
			String decodedString;
			String jsonString = "";
			while ((decodedString = in.readLine()) != null) {
				jsonString = decodedString;
			}
			// jsonString = decodedString; 
			System.out.println("after decoding ##"+jsonString);
			JSONParser jsonparser = new JSONParser();
			try {
				JSONObject json = (JSONObject)jsonparser.parse(jsonString);
				JSONArray bubblesArray = (JSONArray)json.get("bubbles");	// API 참고 (type, data, event 다 들어있음)
				JSONObject bubbles = (JSONObject)bubblesArray.get(0);
				JSONObject data = (JSONObject)bubbles.get("data");
				System.out.println("'data' KEY get 이후 : "+data);
				String description = "";
				description = (String)data.get("description");
				chatMessage = description;
				System.out.println("JSON 작업 완료 : "+chatMessage);
			} catch (Exception e) {
				System.out.println("json parser error");
				e.printStackTrace();
			}

			in.close();

		} else {  // Error occurred (에러 발생)
			System.out.println("Error, Check responseCode");
			chatMessage = con.getResponseMessage();
		}
		
//		System.out.println("응답 결과: "+chatMessage);
		return chatMessage;
	}
}