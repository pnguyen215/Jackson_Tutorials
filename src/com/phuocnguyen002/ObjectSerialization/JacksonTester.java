package com.phuocnguyen002.ObjectSerialization;

import java.io.IOException;

public class JacksonTester {

	public JacksonTester() {
	}

	public static void main(String[] args) {

		StudentMethod studentMethod = new StudentMethod();

		try {
			Student student = new Student(); /* create new student object */
			/*
			 * initialize values for student object
			 */
			student.setId(1);
			student.setName("DavidNguyen");
			student.setAge(21);
			studentMethod.writeJson(student, "student.json"); /* call function by through studentMethod */

			/*
			 * Read file JSON
			 */
			Student studentObject = studentMethod.readJson("student.json");
			System.out.println(studentObject.toString());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
