package day2;
import  org.testng.annotations.Test;

import jdk.internal.net.http.common.Log;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class Postusing_JsonObject {
	  @Test
	void testpostusingjsonlibrary() {
		JSONObject data=new JSONObject();
		data.put("name", "manju");
		data.put("location", "chennai");
		data.put("phone", "9045676754");
		String courseArr[]= {"microbiology","biotech"};
		data.put("courses", courseArr);
		
		given()	
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.body("name",equalTo("manju"))
			.body("location",equalTo("chennai"))
			.body("courses[0]",equalTo("microbiology"))
			.body("courses[1]",equalTo("biotech"))
			.log().all();
	}
	

	
}
