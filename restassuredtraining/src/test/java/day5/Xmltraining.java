package day5;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.Assert;
import  org.testng.annotations.Test;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jdk.internal.net.http.common.Log;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
public class Xmltraining {
	// Approach 1 without passing variable 
	@Test
	void xmldatas() {
		
		given()
			.contentType(ContentType.XML)
			.accept("application/xml")
		.when()
			.get("https://petstore.swagger.io/v2/pet/findByStatus?status=available")
		.then()
			.log().body()
			.statusCode(200)
			.header("content-Type","application/xml")
		     .body("pets.Pet.name[1]", equalTo("fish"));
	}
	
	// Approach 2 with passing variable
	@Test
	void xmldatawithvarable() {
		
		Response res=
		given()
			.contentType(ContentType.XML)
			.accept("application/xml")
		.when()
		.get("https://petstore.swagger.io/v2/pet/findByStatus?status=available");
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/xml");
		String petname=res.xmlPath().get("pets.Pet.name[1]").toString();
		Assert.assertEquals(petname, "doggie");
	}
	
	
	//approch 3 handling with any number of names
	@Test
	void xmlwithbulkresponse() {
		
		Response res=
		given()
			.contentType(ContentType.XML)
			.accept("application/xml")
		.when()
		.get("https://petstore.swagger.io/v2/pet/findByStatus?status=available");
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/xml");
		List<String> petnames=res.xmlPath().getList("pets.Pet.name");
		System.out.println(petnames.size());
//		Assert.assertEquals(petname.size(), 295);	
//		Assert.assertEquals(petname, "doggie");
		Boolean b=true;
		for(String petname:petnames) {
			if(petname.equals("homyak")) {
				b=false;
				break;
			}
		}
		Assert.assertEquals(b, true);
	}


}
