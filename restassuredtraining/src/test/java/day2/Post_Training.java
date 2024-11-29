package day2;
import  org.testng.annotations.Test;

import jdk.internal.net.http.common.Log;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class Post_Training {
	@Test
	void hashmaptraining() {
		HashMap data=new HashMap();
		data.put("name", "loki");
		data.put("location", "greenland");
		data.put("phone", "9045676754");
		String courseArr[]= {"c","c++"};
		data.put("courses", courseArr);
		
		given()	
			.contentType("application/json")
			.body(data)
		.when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.body("name",equalTo("loki"))
			.body("location",equalTo("greenland"))
			.body("courses[0]",equalTo("c"))
			.body("courses[1]",equalTo("c++"))
			.log().all();
	}

}
