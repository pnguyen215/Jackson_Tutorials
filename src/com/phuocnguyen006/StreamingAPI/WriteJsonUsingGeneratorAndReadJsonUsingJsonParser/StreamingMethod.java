package com.phuocnguyen006.StreamingAPI.WriteJsonUsingGeneratorAndReadJsonUsingJsonParser;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StreamingMethod {

	public StreamingMethod() {
	}

	public void writeJson(String name) throws IOException {
		JsonFactory jsonFactory = new JsonFactory();
		File file = new File(name);
		if (!file.exists()) { /* if file is not exist */
			file.createNewFile();
			/*
			 * create the JsonGenerator using JsonFactory.createJsonGenerator() method
			 */
			JsonGenerator jsonGenerator = jsonFactory.createGenerator(file, JsonEncoding.UTF8);
			jsonGenerator.writeStartObject(); /* start write object */
			/*
			 * name : PhuocNguyen
			 */
			jsonGenerator.writeStringField("name", "PhuocNguyen");
			/*
			 * age: 21
			 */
			jsonGenerator.writeNumberField("age", 21);
			/*
			 * verified : false
			 */
			jsonGenerator.writeBooleanField("verified", false);
			/*
			 * marks: [ 100, 95, 85], using Array to save all elements of marks
			 */
			jsonGenerator.writeFieldName("marks"); /* write name of attribute */
			/*
			 * initialize array
			 */
			jsonGenerator.writeStartArray();

			/*
			 * write values
			 */
			jsonGenerator.writeNumber(100);
			jsonGenerator.writeNumber(95);
			jsonGenerator.writeNumber(85);
			/*
			 * the end array
			 */
			jsonGenerator.writeEndArray();
			/*
			 * the end object
			 */
			jsonGenerator.writeEndObject();
			/*
			 * close connection
			 */
			jsonGenerator.close();
		} else {
			System.out.println("File is exist, deleting file...");
			file.delete();
		}
	}

	/*
	 * Read JSON file like normal
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> readJsonLikeNormal(String name)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper(); /* using thread ObjectMapper to map all element has on file */
		Map<String, Object> map; /* using map to save values */
		File file = new File(name);
		if (file.exists()) { /* file is exist */
			/*
			 * get all values from JSON file, after that, set up values for each elements of
			 * map<>
			 */
			map = objectMapper.readValue(file, Map.class);
			return map;
		} else {
			System.out.println("Can not read file, file is not exist!");
			return null;
		}

	}

	/*
	 * Read JSON file using JsonParser
	 */
	public boolean readJsonUsingJsonParser(String name) throws JsonParseException, IOException {
		JsonFactory jsonFactory = new JsonFactory();
		JsonParser jsonParser;
		String fieldName;
		File file = new File(name);
		if (file.exists()) {
			/*
			 * create JSON string from file
			 */
			jsonParser = jsonFactory.createParser(file);
			/*
			 * loop while, check all values is not null until the end
			 */
			while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
				/*
				 * get field name the first in file
				 */
				fieldName = jsonParser.getCurrentName();
				/*
				 * processing compare each other
				 */
				if ("name".equals(fieldName)) {
					jsonParser.nextToken(); /* move to next token */
					System.out.println(jsonParser.getText()); /* getText cause it has data type is String */
				}
				if ("age".equals(fieldName)) {
					jsonParser.nextToken(); /* move to next token */
					System.out
							.println(jsonParser.getNumberValue()); /* getNumberValue cause it has data type is double */
				}
				if ("verified".equals(fieldName)) {
					/*
					 * move to next token
					 */
					jsonParser.nextToken();
					System.out.println(jsonParser.getBooleanValue());
				}
				if ("marks".equals(fieldName)) {
					/*
					 * move to [
					 */
					jsonParser.nextToken();
					/*
					 * loop till token equal to "]". Get all values in array until the end of it
					 */
					while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
						System.out.println(jsonParser.getNumberValue());
					}
				}
			}
			return true;
		} else {
			System.out.println("Can not read file, file is not exist!");
			return false;
		}

	}
}
