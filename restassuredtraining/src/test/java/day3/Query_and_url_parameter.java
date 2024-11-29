package day3;

import  org.testng.annotations.Test;

import jdk.internal.net.http.common.Log;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class Query_and_url_parameter {
	
	//https://reqres.in/api/users?page=2&id=5
	@Test
	void testqueryandparam() {
		given()
			.pathParam("mypath", "users")
			.queryParam("page", 2)
			.queryParam("id",5)
		.when()
	//queryparameter is not required it takes automatically
			.get("https://reqres.in/api/{mypath}")
			
		.then()
		.statusCode(200)
		.log().all();
	}

}
