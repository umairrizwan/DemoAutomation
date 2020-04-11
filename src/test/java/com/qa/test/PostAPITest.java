package com.qa.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.data.Users;


import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;

public class PostAPITest extends TestBase {
	
	public PostAPITest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	TestBase testBase;
	String ServiceURL;
	String APIURL;
	String URL;
	RestClient restClient;
	CloseableHttpResponse closeResponse;
	
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		testBase = new TestBase();
		APIURL = testBase.prop.getProperty("URL");
		ServiceURL = testBase.prop.getProperty("serviceURL");
		URL = APIURL+ServiceURL;
	}
	
   
	@Test
	public void PostAPITest() throws  JsonGenerationException, JsonMappingException, IOException
	{
		restClient = new RestClient(); //Create client 
		
		
		 HashMap<String, String> HeaderMAP = new HashMap<String, String>();  //Prepare headers
		 HeaderMAP.put("Content-Type", "application/json");
		 
	
		Users users = new Users("morpheus","leader"); //Expected Users object
		ObjectMapper objMapper = new ObjectMapper();
		
		//Convert JAVA object to JSON file
		objMapper.writeValue(new File("C:\\Users\\umair.rizwan\\eclipse-workspace\\restapi\\src\\main\\java\\com\\qa\\data\\data.json"), users);
		
		//Convert JAVA to JSON String
		String  JSONString = objMapper.writeValueAsString(users);
		System.out.println(JSONString);
		
		//This is the POST call [Like we click POST from button]
		closeResponse = restClient.post(URL, JSONString, HeaderMAP);
		
		
		
		
		//1. Verify Status response from API
		int statusCode = closeResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code is--->"+ statusCode);
		Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_201, "Status code is not 200");
		
		//2. Response in JSON format
		String JSONresponseString = EntityUtils.toString(closeResponse.getEntity(), "UTF-8");
		JSONObject JSONResponse = new JSONObject(JSONresponseString);
		System.out.println("The JSON Response is -->"+JSONResponse);
		
		//3. Convert JSON to JAVA Object
		Users userRespObject =  objMapper.readValue(JSONresponseString, Users.class); //Actual Users object
		System.out.println(userRespObject);
		
		//System.out.println(users.getName().equals(userRespObject.getName()));
		//System.out.println(users.getJob().equals(userRespObject.getJob()));
		
	    Assert.assertTrue(users.getName().equals(userRespObject.getName()));
	    Assert.assertTrue(users.getJob().equals(userRespObject.getJob()));
		
	}

}
