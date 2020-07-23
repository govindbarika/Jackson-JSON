package com.govind.jackson.json;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.govind.jackson.json.objectmapper.JSONDateFormat;
import com.govind.jackson.json.objectmapper.JacksonTreeModelJsonNode;
import com.govind.jackson.json.objectmapper.JsonNodeToObject;
import com.govind.jackson.json.objectmapper.ObjectToJsonNode;
import com.govind.jackson.json.objectmapper.ReadJSONUsingObjectMapper;
import com.govind.jackson.json.objectmapper.WriteJSONFromObject;

@SpringBootApplication
public class JacksonJsonApplication implements CommandLineRunner {

	
	public static void main(String[] args) {
		SpringApplication.run(JacksonJsonApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		ReadJSONUsingObjectMapper.parseJson();
		
		WriteJSONFromObject.objectToJSON();
		
		JSONDateFormat.jsonDefaultDateValue();
		JSONDateFormat.jsonSpecifiedForatDateValue();
		
		JacksonTreeModelJsonNode.jacksonTreeModel();
		JacksonTreeModelJsonNode.jacksonJsonNodeExample();
		
		ObjectToJsonNode.objectToJsonNode();
		JsonNodeToObject.jsonNodeToObject();
	}

}
