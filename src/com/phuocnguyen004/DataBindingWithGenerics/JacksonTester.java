package com.phuocnguyen004.DataBindingWithGenerics;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JacksonTester {

	public JacksonTester() {
	}

	public static void main(String[] args) {

		/*
		 * initialize method to handle
		 */
		UserMethod method = new UserMethod();
		/*
		 * create list by using map,which to save all objects
		 */
		Map<String, UserData> map = new HashMap<String, UserData>();
		/*
		 * initialize two objects: Student, UserData; array marks
		 */
		Student student = new Student();
		UserData userData = new UserData();
		int[] marks = { 1, 3, 4 };

		/*
		 * Set values for each objects
		 */

		/*
		 * 1. Student Object
		 */
		student.setId(1);
		student.setAge(21);
		student.setName("DavidNguyen");
		/*
		 * 2. UserData Object
		 */

		userData.setStudent(student); /* Object */
		userData.setName("PhuocNguyen"); /* String */
		userData.setVerified(Boolean.TRUE); /* Boolean */
		userData.setMarks(marks); /* Array */

		/*
		 * add all of objects to map
		 */
		map.put("studentData", userData);
		/*
		 * Method
		 */

		/*
		 * 1. writeJson
		 */
		try {
			method.writeJson("userJson.json", map);
			System.out.println(true);
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * 2. readJson
		 */
		try {
			map = method.readJson("userJson.json"); /* get data from JSON file */
			System.out.println(map.get("studentData").getStudent());
			System.out.println(map.get("studentData").getName());
			System.out.println(map.get("studentData").getVerified());
			System.out.println(
					Arrays.toString(map.get("studentData").getMarks())); /* Array marks, so using Arrays.toString() */
			System.out.println(true);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
