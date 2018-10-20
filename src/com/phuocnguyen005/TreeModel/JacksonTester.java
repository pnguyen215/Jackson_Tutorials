package com.phuocnguyen005.TreeModel;

import java.io.IOException;
import java.util.Iterator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTester {

	public JacksonTester() {
	}

	public static void main(String[] args) {

		/*
		 * Create new ObjectMapper
		 */
		ObjectMapper objectMapper = new ObjectMapper();
		/*
		 * Create JSON string
		 */
		String jsonString = "{\"name\":\"PhuocNguyen\", \"age\":21,\"verified\":false,\"marks\": [100,90,85]}";

		/*
		 * Create Tree from JSON String
		 */

		JsonNode rootNode = null;
		try {
			rootNode = objectMapper.readTree(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * Traversing Tree Model
		 */

		/*
		 * 1. name attribute
		 */
		JsonNode nameNode = rootNode.path("name");
		System.out.println("Name: " + nameNode.textValue() + ", SIZE: " + (nameNode.textValue()).length());

		/*
		 * 2. age attribute
		 */
		JsonNode ageNode = rootNode.path("age");
		System.out.println("Age: " + ageNode.intValue());

		/*
		 * 3. verified attribute
		 */

		JsonNode verifiedNode = rootNode.path("verified");
		System.out.println("Verified: "
				+ (verifiedNode.booleanValue() ? "yes" : "no")); /*
																	 * we using if condition to get value of verified
																	 * yes or replace for true or false
																	 */

		/*
		 * 4. marks attribute
		 */
		JsonNode marksNode = rootNode.path("marks");
		Iterator<JsonNode> iterator = marksNode.elements(); /* get listed from Iterator has data type JsonNode */
		System.out.print("Marks : [ ");
		while (iterator.hasNext()) {
			System.out.print(iterator.next().intValue()
					+ " "); /* get next elements by intValue() cause it is JsonNode data type */
		}
		System.out.println(" ]");
	}

}
