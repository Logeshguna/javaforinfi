package day2;
import  org.testng.annotations.Test;

import jdk.internal.net.http.common.Log;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

//import java.util.HashMap;
public class PojoPost {
	
	@Test
	void testpostusingjsonlibrary() {
		Pojo_request data=new Pojo_request();
		data.setName("ashwin");
		data.setLocation("salem");
		data.setPhone("8939145189");
		String courses[]= {"c#","c"};
		data.setCourses(courses);
		
		given()	
			.contentType("application/json")
			.body(data)
		.when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.body("name",equalTo("ashwin"))
			.body("location",equalTo("salem"))
			.body("courses[0]",equalTo("c#"))
			.body("courses[1]",equalTo("c"))
			.log().all();

}
}
