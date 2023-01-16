package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

@Test
public class TestA 
{
	public void test_1()
	{
		Response response= get("https://reqres.in/api/users?page=2");

		System.out.println("Status code is "+response.getStatusCode());
		System.out.println("Time is "+response.getTime());
		System.out.println("Body is "+response.getBody().asString());
		System.out.println("Status line "+response.getStatusLine());
		System.out.println("Header "+response.getHeader("content-type"));
		
		
		//New added line..

		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}

	//This is new comment.
	
	@Test
	public void test_2()
	{
		baseURI="https://reqres.in/api";

		given().
		  get("/users?page=2").
		then().
		   statusCode(200).
		   body("data[1].id", equalTo(8)).
		   log().all();
	}

}
