package com.phuocnguyen001.FirstAppliccation;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTester {

	public JacksonTester() {
	}

	/**
	 * @param args
	 */

	public static void main(String[] args) {

		ObjectMapper objectMapper = new ObjectMapper();
		String stringJson = "{\"name\":\"PhuocNguyen\", \"age\" : 21}";
		try {
			/* Student Class */
			/* Map JSON to Student */
			Student student = objectMapper.readValue(stringJson, Student.class); /* Object to JSON Conversion */
			System.out.println(student); /* print student object by format toString() */
			stringJson = objectMapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(student); /* Object to JSON Conversion */
			System.out.println(stringJson);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
