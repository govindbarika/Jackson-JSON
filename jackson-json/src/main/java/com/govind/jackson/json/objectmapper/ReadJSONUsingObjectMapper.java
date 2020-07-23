package com.govind.jackson.json.objectmapper;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.govind.jackson.json.model.Car;

@Component
public class ReadJSONUsingObjectMapper {
	
	public static void parseJson() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		readObjectFromJSONString(objectMapper);

		readObjectFromJSONReader(objectMapper);

		readObjectFromJSONFile(objectMapper);

		readObjectFromJSONURL(objectMapper);

		readObjectFromJSONByteArray(objectMapper);

		readObjectFromJSONArray(objectMapper);

		readObjectListFromJSONString(objectMapper);

		readMapFromJSONString(objectMapper);

		ignoreUnknownFields(objectMapper);
	}

	private static void readMapFromJSONString(ObjectMapper objectMapper)
			throws JsonProcessingException, JsonMappingException {
		String jsonObject = "{\"brand\":\"ford\", \"doors\":5}";

		Map<String, Object> jsonMap = objectMapper.readValue(jsonObject, new TypeReference<Map<String, Object>>() {
		});
		jsonMap.forEach((k, v) -> System.out.println(k + "=" + v));
	}

	private static void readObjectListFromJSONString(ObjectMapper objectMapper)
			throws JsonProcessingException, JsonMappingException {
		String jsonArray = "[{\"brand\":\"ford\"}, {\"brand\":\"Fiat\"}]";

		List<Car> cars1 = objectMapper.readValue(jsonArray, new TypeReference<List<Car>>() {
		});
		cars1.stream().forEach(System.out::println);
	}

	private static void readObjectFromJSONArray(ObjectMapper objectMapper)
			throws JsonProcessingException, JsonMappingException {
		String jsonArray = "[{\"brand\":\"ford\", \"doors\" : 5}, {\"brand\":\"Fiat\", \"doors\" : 4}]";

		Car[] cars2 = objectMapper.readValue(jsonArray, Car[].class);
		Arrays.asList(cars2).stream().forEach(System.out::println);
	}

	private static void readObjectFromJSONByteArray(ObjectMapper objectMapper)
			throws JsonParseException, JsonMappingException, IOException {
		String carJson = "{ \"brand\" : \"Mercedes reader\", \"doors\" : 5 }";
		byte[] bytes = carJson.getBytes("UTF-8");

		Car car = objectMapper.readValue(bytes, Car.class);
		System.out.println(car);
	}

	private static void readObjectFromJSONURL(ObjectMapper objectMapper)
			throws JsonParseException, JsonMappingException, IOException {
		URL url = new URL("file:src/main/java/car.json");

		Car car = objectMapper.readValue(url, Car.class);
		System.out.println("car brand = " + car.getBrand());
		System.out.println("car doors = " + car.getDoors());

	}

	private static void readObjectFromJSONFile(ObjectMapper objectMapper)
			throws JsonParseException, JsonMappingException, IOException {
		File file = new File("src/main/java/car.json");

		Car car = objectMapper.readValue(file, Car.class);

		System.out.println("car brand = " + car.getBrand());
		System.out.println("car doors = " + car.getDoors());

	}

	private static void ignoreUnknownFields(ObjectMapper objectMapper)
			throws JsonParseException, JsonMappingException, IOException {
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		// objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES,
		// true);
		String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : null, \"wheels\" : 12 }";
		Reader reader = new StringReader(carJson);

		Car car = objectMapper.readValue(reader, Car.class);

		System.out.println("car brand = " + car.getBrand());
		System.out.println("car doors = " + car.getDoors());

	}

	private static void readObjectFromJSONReader(ObjectMapper objectMapper)
			throws JsonParseException, JsonMappingException, IOException {
		String carJson = "{ \"brand\" : \"Mercedes reader\", \"doors\" : 5 }";
		Reader reader = new StringReader(carJson);

		Car car = objectMapper.readValue(reader, Car.class);

		System.out.println("car brand = " + car.getBrand());
		System.out.println("car doors = " + car.getDoors());

	}

	private static void readObjectFromJSONString(ObjectMapper objectMapper)
			throws JsonMappingException, JsonProcessingException {
		String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";

		Car car = objectMapper.readValue(carJson, Car.class);

		System.out.println("car brand = " + car.getBrand());
		System.out.println("car doors = " + car.getDoors());

	}

}
