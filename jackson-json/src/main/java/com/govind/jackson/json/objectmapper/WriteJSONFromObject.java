package com.govind.jackson.json.objectmapper;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.govind.jackson.json.model.Car;

/*The Jackson ObjectMapper can also be used to generate JSON from an object. You do so using the one of the methods:

writeValue()
writeValueAsString()
writeValueAsBytes()*/

public class WriteJSONFromObject {
	public static void objectToJSON() throws JsonGenerationException, JsonMappingException, FileNotFoundException, IOException {
		writeValue();
		
		writeValueAsString();
	}

	private static void writeValueAsString() throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		Car car = new Car();
		car.setBrand("BMW");
		car.setDoors(4);

		String json = objectMapper.writeValueAsString(car);
		System.out.println(json);
	}

	private static void writeValue()
			throws IOException, JsonGenerationException, JsonMappingException, FileNotFoundException {
		ObjectMapper objectMapper = new ObjectMapper();

		Car car = new Car();
		car.setBrand("BMW");
		car.setDoors(4);

		objectMapper.writeValue(new FileOutputStream("src/main/java/carOutput.json"), car);
	}
	
	

}
