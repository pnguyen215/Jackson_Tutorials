package com.phuocnguyen002.ObjectSerialization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StudentMethod {

	public StudentMethod() {
	}

	/* writeJson function */
	public void writeJson(Student student, String fileName)
			throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper(); /* Create ObjectMapper object. */
		File file = new File(fileName);
		if (!file.exists()) { /* if file is not exist */
			file.createNewFile(); /* create new file with fileName is argument */
			/* map Student object to JSON content */
			objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, student); /* proceeding write to file */
		} else {
			file.delete(); /* file is exist, so it will be deleted */
		}

	}

	/* readJson function return student object */
	public Student readJson(String fileName) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		File file = new File(fileName);
		if (!file.exists()) {
			System.out.println("File is not exist! Can not read it!");
			return null;
		} else {
			/* map JSON content to Student object */
			Student student = objectMapper.readValue(file, Student.class); /* continue read file */
			return student;
		}

	}
}
