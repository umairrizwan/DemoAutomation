package com.qa.base;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiTest {
	
	/*
public static void main(String[] args) {
	
	RestAssured.baseURI = "https://reqres.in/api";
	RequestSpecification spec = RestAssured.given();
	Response response =spec.get("/users");
	
	System.out.println(response.getStatusCode());
	System.out.println(response.getBody().asString());
	
	//path /users/umair
	//query parameter ?users=umai
	
	HashMap<Integer, String> hm = new HashMap<Integer, String>();
	hm.put(1, "Umair");
	hm.put(2, "Rizwan");
	
	for(Entry m : hm.entrySet())
	{
		System.out.println(m.getKey()+" "+m.getValue());
	}
	
}
	*/

}
