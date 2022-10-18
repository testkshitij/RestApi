package test;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

@Test
public class PutPatchAndDelete 
{
	public void testPut()
	{
		JSONObject request=new JSONObject(); 

		request.put("name", "Raghav");
		request.put("job", "teacher");

		System.out.println(request.toJSONString());

		baseURI="https://reqres.in/api";

	  given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
	    .body(request.toJSONString())
	  .when()
		.put("/users/2")
	  .then()
		.statusCode(200)
		.log().all();
	}
	
	public void testPatch()
	{
		JSONObject request=new JSONObject(); 

		request.put("name", "Raghav");
		request.put("job", "teacher");

		System.out.println(request.toJSONString());

		baseURI="https://reqres.in";

	  given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
	    .body(request.toJSONString())
	  .when()
		.patch("/api/users/2")
	  .then()
		.statusCode(200)
		.log().all();
	}


	public void testDelete()
	{
		baseURI="https://reqres.in";

	  when()
		.delete("/api/users/2")
	  .then()
		.statusCode(204)
		.log().all();
	}
}
