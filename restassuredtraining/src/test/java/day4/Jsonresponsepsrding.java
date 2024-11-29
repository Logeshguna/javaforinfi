package day4;
import org.testng.Assert;
import  org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jdk.internal.net.http.common.Log;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
//import static org.junit.Assert.assertEquals;

import org.json.JSONArray;
import org.json.JSONObject;

public class Jsonresponsepsrding {

	@Test
	void jsonresponse() {
		given()
			.contentType(ContentType.JSON)
		.when()
			.get("http://localhost:3000/student")
		.then()
			.statusCode(200)
			.header("Content-Type", "application/json")
			.body("[0].studentdetail[0].name",equalTo("jhon"));//jsonpath
	}
	
	//Testng assersions
	
	@Test
	void responsevarable() {
		Response res=given()
			.contentType(ContentType.JSON)
		.when()
			.get("http://localhost:3000/student");
			Assert.assertEquals(res.getStatusCode(), 200);
			Assert.assertEquals(res.header("Content-Type"), "application/json");
			String studentname=res.jsonPath().get("[0].studentdetail[0].name").toString();//json path convertd to string since json path returns json object
			System.out.println(studentname);
			String name="jhon";
			Assert.assertEquals("jhon", studentname);
//			Assert.assertEquals("willamjhon", studentname);)
	}
	
	@Test
	void getmutiplejsonvalue() {
		Response res=given()
			.contentType(ContentType.JSON)
		.when()
			.get("https://reqres.in/api/unknown");
		JSONObject m=new JSONObject(res.asString());
		boolean status=false;
		for(int i=0; i<m.getJSONArray("data").length();i++) {
		String studentname=m.getJSONArray("data").getJSONObject(i).get("name").toString();
		System.out.println(studentname);
		 if (studentname.equals("tigerlily")) {
         	status=true;
         	break;
         }
			
		}
		
	}
	
	@Test
	public void getMultipleJsonValue() {
	    Response res = given()
	            .contentType(ContentType.JSON)
	            .when()
	            .get("https://reqres.in/api/unknown");

	    JSONObject jsonResponse = new JSONObject(res.asString());
	    JSONArray studentDetailArray = jsonResponse.getJSONArray("data");
	    boolean status=false;
	    for (int i = 0; i < studentDetailArray.length(); i++) {
	    	JSONObject studentDetail = studentDetailArray.getJSONObject(i);
	    	JSONArray details = studentDetail.getJSONArray("studentdetail");

	        for (int j = 0; j < details.length(); j++) {
	            JSONObject detail = details.getJSONObject(j);
	            String studentName = detail.getString("name");
	            System.out.println(studentName);
	           
	        }
	    }
	}
	
}
