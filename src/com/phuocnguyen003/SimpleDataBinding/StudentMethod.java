package com.phuocnguyen003.SimpleDataBinding;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StudentMethod {

	public StudentMethod() {
	}

	public void writeJson(String fileName, Map<String, Object> student)
			throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		File file = new File(fileName);
		if (!file.exists()) { /* if file is not exist */
			file.createNewFile(); /* create new file */
			objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, student); /* map object to JSON content */
		} else {
			System.out.println("Error!");
			file.delete();
		}
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> readJson(String fileName) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> mapList;
		File file = new File(fileName);
		mapList = objectMapper.readValue(file, Map.class);
		return mapList;

	}
}
