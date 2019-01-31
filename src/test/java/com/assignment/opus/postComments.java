package com.assignment.opus;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class postComments {
	
	util ut = new util();

	@SuppressWarnings("unchecked")
	@Test
	public void commentPost() {
		RestAssured.baseURI = constants.endPoint;
		RequestSpecification request = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("id",ut.prop.getProperty("ID1"));
		requestParams.put("postId",ut.prop.getProperty("PostID1"));
		requestParams.put("name",ut.prop.getProperty("Name1"));
		requestParams.put("email",ut.prop.getProperty("Email1"));
		requestParams.put("body",ut.prop.getProperty("Body1"));
		request.body(requestParams.toJSONString());
		Response response = request.post("/comments");
		int statusCode = response.getStatusCode();
		int expectedCode = 201;
		Assert.assertEquals(statusCode,expectedCode);
		
	}

}
