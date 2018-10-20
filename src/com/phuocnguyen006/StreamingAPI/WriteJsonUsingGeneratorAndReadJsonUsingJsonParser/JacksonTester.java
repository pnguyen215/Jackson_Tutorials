package com.phuocnguyen006.StreamingAPI.WriteJsonUsingGeneratorAndReadJsonUsingJsonParser;

import java.io.IOException;
import java.util.Map;

public class JacksonTester {

	public JacksonTester() {
	}

	public static void main(String[] args) {
		StreamingMethod streamingMethod = new StreamingMethod();
		Map<String, Object> map;
		try {
			/*
			 * write data to JSON file
			 */
			streamingMethod.writeJson("streamingAPI.json");
			System.out.println(true);
			/*
			 * read JSON file
			 */
			/*
			 * 1. Normal
			 */
			map = streamingMethod.readJsonLikeNormal("streamingAPI.json");
			System.out.println(map.toString());
			System.out.println(true);
			/*
			 * 2. Using JsonParser
			 */
			streamingMethod.readJsonUsingJsonParser("streamingAPI.json");
			System.out.println(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
