package day6;
import  org.testng.annotations.Test;

import com.github.fge.jsonschema.main.JsonSchema;

import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;
import jdk.internal.net.http.common.Log;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;


public class Schema_validation {
	
	@Test
	void jsonsecmavalidation() {
		
		given()
		.when()
			.get("https://petstore.swagger.io/v2/pet/findByStatus?status=available")
		.then()
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schempractice.json"));
	}
	
	@Test
	void xmlschemavalidation() {
		given()
			.contentType(ContentType.XML)
			.accept("application/xml")
		.when()
			.get("https://petstore.swagger.io/v2/pet/findByStatus?status=available")
		.then()
			.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("xml.xsd"));
		
	}

}
