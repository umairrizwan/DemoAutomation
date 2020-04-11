package com.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ReadProp {
	
	

	public static void main(String[] args) throws IOException {
		
		
	
		
		

		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\umair.rizwan\\eclipse-workspace\\restapi\\src\\main\\java\\com\\qa\\config\\config.properties");
		
		prop.load(ip);
		
		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("username"));
		
	String bro = prop.getProperty("browser");
		
		//if(bro.equals("chrome"))
		//{
			//System.setProperty("web.chrome.driver", "C:\\Users\\umair.rizwan\\Documents\\chromedriver_win32");
		//	driver.navigate().to("http://www.google.com");
			
		//}
		  
		
		
		
	}

}
