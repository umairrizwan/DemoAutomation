package com.qa.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.util.TestUtil;

import org.apache.http.Header;
import java.util.HashMap;

public class GetAPITest extends TestBase {
	
	public GetAPITest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	TestBase testBase;
	String Serviceurl;
	String Apiurl;
	String URL;
	RestClient restClient;
	CloseableHttpResponse closehttp;
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		testBase = new TestBase();
		 Serviceurl = prop.getProperty("URL");
		 Apiurl = prop.getProperty("serviceURL");
		
		
		
		
	}
	
	
	@Test(priority = 1)
	public void getAPITestWithoutHeaders() throws ClientProtocolException, IOException
	{
		 URL = Serviceurl+Apiurl;
		 restClient = new RestClient();
		 closehttp =  restClient.getURL(URL);
		 
			//Get status code from 
			int status =  closehttp.getStatusLine().getStatusCode();
			System.out.println("Status Code is--->"+ status);
			Assert.assertEquals(status, RESPONSE_STATUS_CODE_200, "Status code is not 200");
			
			
			String respString = EntityUtils.toString(closehttp.getEntity(), "UTF-8"); //This will return the entire response string of API
			//This will return the response in string which we will convert it into JSON below
			JSONObject Responsejson = new JSONObject(respString);
			System.out.println("The response is---> "+Responsejson);
			
			//String perpagevalue =  TestUtil.getValueByJPath(Responsejson, "/per_page");
			//System.out.println("Per Page Value is---->"+perpagevalue);
			//Assert.assertEquals(perpagevalue, 6, "The value is not matched");
			
			String totalvalue =  TestUtil.getValueByJPath(Responsejson, "/total");
			System.out.println("Per Page Value is---->"+totalvalue);
			Assert.assertEquals(Integer.parseInt(totalvalue) , 12, "The value is not matched");
			
			
			//validate value from JSON Array
			String id= TestUtil.getValueByJPath(Responsejson, "/data[0]/id");
			String email= TestUtil.getValueByJPath(Responsejson, "/data[0]/email");
			String first_name= TestUtil.getValueByJPath(Responsejson, "/data[0]/first_name");
			String last_name= TestUtil.getValueByJPath(Responsejson, "/data[0]/last_name");
			String avatar= TestUtil.getValueByJPath(Responsejson, "/data[0]/avatar");
			
			
			System.out.println("ID is -->"+id);
			System.out.println("email is -->"+email);
			System.out.println("First is -->"+first_name);
			System.out.println("Last is -->"+last_name);
			System.out.println("Avatar is -->"+avatar);
			
			
			//Now we will print Headers from API below as sometimes we need to validate the headers as well
		   Header[] heads =  closehttp.getAllHeaders();
		    System.out.println(closehttp.getAllHeaders());
		    HashMap<String, String> has = new HashMap<String, String>();
		    for(Header header : heads)
		    {
		    	
		         has.put(header.getName(), header.getValue());
		    
		    }
		    
		    System.out.println("Header array is---> "+ has);
	}
	
	
	
	
	@Test(priority = 2)
	public void getAPITestWithHeaders() throws ClientProtocolException, IOException
	{
		 URL = Serviceurl+Apiurl;
		 restClient = new RestClient();
		 closehttp =  restClient.getURL(URL);
		 
		 HashMap<String, String> HeaderMAP = new HashMap<String, String>();
		 HeaderMAP.put("Content-Type", "application/x-www-form-urlencoded");
		 
		 closehttp =  restClient.getURL(URL,HeaderMAP);
		 
		//Get status code from 
			int status =  closehttp.getStatusLine().getStatusCode();
			System.out.println("Status Code is--->"+ status);
			Assert.assertEquals(status, RESPONSE_STATUS_CODE_200, "Status code is not 200");
			
			
			String respString = EntityUtils.toString(closehttp.getEntity(), "UTF-8"); //This will return the entire response string of API
			//This will return the response in string which we will convert it into JSON below
			JSONObject Responsejson = new JSONObject(respString);
			System.out.println("The response is---> "+Responsejson);
			
			//String perpagevalue =  TestUtil.getValueByJPath(Responsejson, "/per_page");
			//System.out.println("Per Page Value is---->"+perpagevalue);
			//Assert.assertEquals(perpagevalue, 6, "The value is not matched");
			
			String totalvalue =  TestUtil.getValueByJPath(Responsejson, "/total");
			System.out.println("Per Page Value is---->"+totalvalue);
			Assert.assertEquals(Integer.parseInt(totalvalue) , 12, "The value is not matched");
			
			
			//validate value from JSON Array
			String id= TestUtil.getValueByJPath(Responsejson, "/data[0]/id");
			String email= TestUtil.getValueByJPath(Responsejson, "/data[0]/email");
			String first_name= TestUtil.getValueByJPath(Responsejson, "/data[0]/first_name");
			String last_name= TestUtil.getValueByJPath(Responsejson, "/data[0]/last_name");
			String avatar= TestUtil.getValueByJPath(Responsejson, "/data[0]/avatar");
			
			
			System.out.println("ID is -->"+id);
			System.out.println("email is -->"+email);
			System.out.println("First is -->"+first_name);
			System.out.println("Last is -->"+last_name);
			System.out.println("Avatar is -->"+avatar);
			
			
			//Now we will print Headers from API below as sometimes we need to validate the headers as well
		   Header[] heads =  closehttp.getAllHeaders();
		    System.out.println(closehttp.getAllHeaders());
		    HashMap<String, String> has = new HashMap<String, String>();
		    for(Header header : heads)
		    {
		    	
		         has.put(header.getName(), header.getValue());
		    
		    }
		    
		    System.out.println("Header array is---> "+ has);
			
	}
	
	
	

}
