package day5;
import static org.testng.Assert.assertEquals;

import java.io.File;
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

public class SingleFileUpload {
	
	@Test
	void singlefupload(){
		
		File mufile=new File("C:\\Users\\logesh.g\\Downloads\\images.jpg");
		given()
			.multiPart("file", mufile)
		.when()
			.post("https://petstore.swagger.io/v2/pet/1/uploadImage?petId=1")
		.then()
			.statusCode(200)
			.body("message",equalTo("additionalMetadata: null\nFile uploaded to ./images.jpg, 11968 bytes"));
		
	}
	
	
//	void filedownload() {
//	s	
//		given()
//		.when()
//			.get()
//		.then()
//	}

}
