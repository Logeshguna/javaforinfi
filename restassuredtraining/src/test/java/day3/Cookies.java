package day3;
import static io.restassured.RestAssured.given;

import java.util.Map;

import  org.testng.annotations.Test;

import io.restassured.response.Response;

public class Cookies {
	
	
	
	@Test(priority=1)
	void testcookies() {
		given()
		
		.when()
			.get("https://www.google.com/")
		
		.then()
			.cookie("AEC","Ae3NU9PDzy1VHSppzjJ-eHaYhmTa6R6QT79VIo174MkRIc5_THOJFGI1_A")
			.log().all();
		
		
	}

	
	
	//get single cookie info 
	@Test(priority=2)
	void getcookiesinfo() {
		
		Response res=given()
				
		
		.when()
			.get("https://www.google.com/");
			String cookie=res.getCookie("AEC");
			System.out.println("the cookie is===>"+cookie);
			
		
		
			
	}
	
	//get all cookies info
	@Test(priority=3)
	void allcookiesinfo() {
		
		Response res=given()   //used to store whole body response 
				
		
		.when()
			.get("https://www.google.com/");
			
		Map<String,String>allcookie=res.getCookies();//get all cookies from the response and store in the format of string
		System.out.println(allcookie.keySet());//uest to get the keys of cookies
		for(String c:allcookie.keySet()) {
			String	cookievalue=res.getCookie(c);//get values of all keys using for 
			System.out.println(c+"                   "+cookievalue);
		}
		
			
		
		
			
	}
	

}
