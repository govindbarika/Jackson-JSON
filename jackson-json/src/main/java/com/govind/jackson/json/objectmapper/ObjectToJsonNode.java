package com.govind.jackson.json.objectmapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.govind.jackson.json.model.Car;

public class ObjectToJsonNode {

	public static void objectToJsonNode() {
		ObjectMapper objectMapper = new ObjectMapper();

		Car car = new Car();
		car.setBrand("Cadillac");
		car.setDoors(4);

		JsonNode carJsonNode = objectMapper.valueToTree(car);
		System.out.println(carJsonNode);
	}
}
