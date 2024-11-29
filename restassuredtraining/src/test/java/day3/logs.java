package day3;
import  org.testng.annotations.Test;

import jdk.internal.net.http.common.Log;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;


public class logs {
	
	
	
	@Test(priority=1)
	void testlog() {
		
		given()
		
		.when()
		.get("https://reqres.in/api/users?page=2&id=5")
		
		.then()
			.log().all()
			.log().body()//print body
			.log().headers()//print headers
			.log().cookies();
		
	}

}
