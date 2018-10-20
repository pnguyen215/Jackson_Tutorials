package com.phuocnguyen004.DataBindingWithGenerics;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserMethod {

	public UserMethod() {
	}

	public void writeJson(String fileName, Map<String, UserData> userData) throws IOException {
		File file = new File(fileName);
		ObjectMapper objectMapper = new ObjectMapper();
		if (!file.exists()) {
			file.createNewFile();
			objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, userData);
		} else {
			System.out.println("File is exist, deleting file...");
			file.delete();
		}
	}

	public Map<String, UserData> readJson(String fileName)
			throws JsonParseException, JsonMappingException, IOException {
		TypeReference<Map<String, UserData>> typeReference = new TypeReference<Map<String, UserData>>() {
		};
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, UserData> mapList;
		File file = new File(fileName);
		if (!file.exists()) {
			System.out.println("File is not exist!");
			return null;
		} else {
			mapList = objectMapper.readValue(file, typeReference);
			return mapList;
		}

	}
}
