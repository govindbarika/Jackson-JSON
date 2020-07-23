package com.govind.jackson.json.objectmapper;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/*we can generate JsonNode using readValue(-,-) and readTree(-)*/

public class JacksonTreeModelJsonNode {
	public static void jacksonTreeModel() throws JsonMappingException, JsonProcessingException {
		String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";

		ObjectMapper objectMapper = new ObjectMapper();

		// JsonNode jsonNode = objectMapper.readValue(carJson, JsonNode.class);
		JsonNode jsonNode = objectMapper.readTree(carJson);

		System.out.println(jsonNode);
		System.out.println(jsonNode.get("brand"));
		System.out.println(jsonNode.get("doors"));
	}

	public static void jacksonJsonNodeExample() {
		String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 5," + "  \"owners\" : [\"John\", \"Jack\", \"Jill\"],"
				+ "  \"nestedObject\" : { \"field\" : \"value\" } }";

		ObjectMapper objectMapper = new ObjectMapper();

		try {

			JsonNode jsonNode = objectMapper.readValue(carJson, JsonNode.class);

			JsonNode brandNode = jsonNode.get("brand");
			String brand = brandNode.asText();
			System.out.println("brand = " + brand);

			JsonNode doorsNode = jsonNode.get("doors");
			int doors = doorsNode.asInt();
			System.out.println("doors = " + doors);

			JsonNode array = jsonNode.get("owners");
			JsonNode jsonNode1 = array.get(0);
			String john = jsonNode1.asText();
			System.out.println("john  = " + john);

			JsonNode child = jsonNode.get("nestedObject");
			JsonNode childField = child.get("field");
			String field = childField.asText();
			System.out.println("field = " + field);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
