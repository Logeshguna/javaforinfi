package day3;
import static io.restassured.RestAssured.given;

import java.util.Map;

import  org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.response.Response;

public class Headers {
	
	@Test(priority=1)
	void getheaders() {
		given()
		
		.when()
			.get("https://www.google.com/")
		
		.then()
			.header("Content-Encoding", "gzip")
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.log().all();
		
	}
	
	
	@Test(priority=2)
	void getsingleheader() {
		
		Response res=given()
		
		.when()
			.get("https://www.google.com/");
		String hradervalue=res.getHeader("Content-Encoding");
		System.out.println("Heade value is====>"+hradervalue);
		
	}

	@Test
	void getallheaders() {

		Response res=given()
		
		.when()
			.get("https://www.google.com/");
		   
		io.restassured.http.Headers headevalue=res.getHeaders();
		for(Header hd:headevalue) {
			System.out.println(hd.getName()+"    "+hd.getValue());
			
		}
	}



}
