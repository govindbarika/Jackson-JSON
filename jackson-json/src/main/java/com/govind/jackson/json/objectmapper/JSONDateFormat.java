package com.govind.jackson.json.objectmapper;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.govind.jackson.json.model.Transaction;

/*By default Jackson will serialize a java.util.Date object to its long value, which is the number of milliseconds 
since January 1st 1970. However, Jackson also supports formatting dates as strings. In this section we will take 
a closer look at the Jackson date formats.*/

public class JSONDateFormat {

	public static void jsonDefaultDateValue() throws JsonProcessingException {
		Transaction transaction = new Transaction("transfer", new Date());

		ObjectMapper objectMapper = new ObjectMapper();
		String output = objectMapper.writeValueAsString(transaction);

		System.out.println("Date with default format value" + output);
	}
	
	public static void jsonSpecifiedForatDateValue() throws JsonProcessingException {
		Transaction transaction = new Transaction("transfer", new Date());

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setDateFormat(new SimpleDateFormat("YYYY-MM-dd"));
		String output = objectMapper.writeValueAsString(transaction);

		System.out.println("Date with default format value" + output);
	}
}
