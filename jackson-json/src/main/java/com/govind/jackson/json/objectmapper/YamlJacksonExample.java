package com.govind.jackson.json.objectmapper;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.govind.jackson.json.model.Employee;

public class YamlJacksonExample {

	public static void main(String[] args) {
		ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

		Employee employee = new Employee("John Doe", "john@doe.com");

		String yamlString = null;
		try {
			yamlString = objectMapper.writeValueAsString(employee);
			System.out.println("Emp YML" + yamlString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		try {
			Employee employee2 = objectMapper.readValue(yamlString, Employee.class);

			System.out.println(employee2);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
