package com.athema;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class CryptTests {
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	@DisplayName("패스워드 암호화 테스트")
	void passwordEncode() {
		// 주어진 암호
		String original = "12345678";
		
		String encodedPassword = passwordEncoder.encode(original);
		
		assertAll(
				() -> assertNotEquals(original, encodedPassword),
				() -> assertTrue(passwordEncoder.matches(original, encodedPassword))
				
		);
		
		System.out.println(encodedPassword);
		boolean m = passwordEncoder.matches(original, encodedPassword);
		System.out.println(m);
	}
	
}
