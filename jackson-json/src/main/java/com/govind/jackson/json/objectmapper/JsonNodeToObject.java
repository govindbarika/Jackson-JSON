package com.govind.jackson.json.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.govind.jackson.json.model.Car;

public class JsonNodeToObject {

	public static void jsonNodeToObject() throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";

		JsonNode carJsonNode = objectMapper.readTree(carJson);

		Car car = objectMapper.treeToValue(carJsonNode, Car.class);
		System.out.println(car);
	}

}
