package com.skydragon.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommonApplication {

	public static void main(String[] args) {
		/*
		String str1 = "12345678";
		String str2 = "123456789";
		String str3 = "1234567890";
		String str4 = "12345678";

		int mod1 = str1.hashCode() & Integer.MAX_VALUE % 3;
		int mod2 = str2.hashCode() & Integer.MAX_VALUE % 3;
		int mod3 = str3.hashCode() & Integer.MAX_VALUE % 3;
		int mod4 = str4.hashCode() & Integer.MAX_VALUE % 3;
		 */

		SpringApplication.run(CommonApplication.class, args);
	}
}
