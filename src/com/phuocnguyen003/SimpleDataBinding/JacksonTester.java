package com.phuocnguyen003.SimpleDataBinding;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class JacksonTester {

	public JacksonTester() {
	}

	public static void main(String[] args) {

		StudentMethod studentMethod = new StudentMethod();
		Map<String, Object> studentDataMap = new HashMap<String, Object>();
		Student student = new Student();
		int[] mark = { 1, 2, 3 };

		/*
		 * initialize values for student
		 */
		student.setId(1);
		student.setAge(21);
		student.setName("DavidNguyen");

		/*
		 * Handle with Map<String, ,Object>
		 */

		studentDataMap.put("student", student); /* Object */
		studentDataMap.put("name", "PhuocNguyen"); /* String */
		studentDataMap.put("verified", Boolean.TRUE); /* boolean */
		studentDataMap.put("marks", mark); /* Array */

		/*
		 * Using studentMethod to access 2 functions
		 */

		/*
		 * 1. writeJson
		 */

		try {
			studentMethod.writeJson("studentJson.json", studentDataMap);/* write content to file */
			System.out.println(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*
		 * 2. readJson
		 */
		try {
			studentDataMap = studentMethod.readJson("studentJson.json");
			System.out.println(studentDataMap.get("student"));
			System.out.println(studentDataMap.get("name"));
			System.out.println(studentDataMap.get("marks"));
			System.out.println(true);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
