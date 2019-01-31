package com.assignment.opus;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class postUsers
{
	util ut = new util();

	@SuppressWarnings("unchecked")
	@Test
	public void userPost()
	{ 
	 RestAssured.baseURI =constants.endPoint;;
	 RequestSpecification request = RestAssured.given();
	 
	 JSONObject requestParams = new JSONObject();
	 requestParams.put("id",ut.prop.getProperty("ID2"));
	 requestParams.put("name", ut.prop.getProperty("Name2")); 
	 requestParams.put( "username", ut.prop.getProperty("Username"));
	 requestParams.put("email",ut.prop.getProperty("Email2"));
	 requestParams.put("phone", ut.prop.getProperty("Phone2"));
	 request.body(requestParams.toJSONString());
	 Response response = request.post("/users");
	 int statusCode = response.getStatusCode();
	 int expectedCode = 201;
	 Assert.assertEquals(statusCode,expectedCode);
	}
	
}
