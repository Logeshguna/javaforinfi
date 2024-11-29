package day2;
import org.json.JSONObject;
import org.json.JSONTokener;
import  org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
	
public class Externaljsonfile {
	@Test
	void externaljson() throws FileNotFoundException {
		File f=new File(".//body.json");
		FileReader fr=new FileReader(f);
		JSONTokener t=new JSONTokener(fr);
		JSONObject data=new JSONObject(t);
		given()	
		.contentType("application/json")
		.body(data.toString())
	.when()
		.post("http://localhost:3000/students")
	.then()
		.statusCode(201)
		.body("name",equalTo("willamjhon"))
		.body("location",equalTo("India"))
		.body("courses[0]",equalTo("java"))
		.body("courses[1]",equalTo("selenium"))
		.log().all();
	}

}
