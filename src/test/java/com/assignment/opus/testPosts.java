package com.assignment.opus;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class testPosts {
	
	util ut = new util();

	@SuppressWarnings("unchecked")
	@Test
	public void postTest() {
		RestAssured.baseURI =constants.endPoint;
		RequestSpecification request = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("userId",ut.prop.getProperty("userID"));
		requestParams.put("id", ut.prop.getProperty("ID3"));
		requestParams.put("title",ut.prop.getProperty("PostID3"));
		requestParams.put("body",ut.prop.getProperty("Body3"));
		request.body(requestParams.toJSONString());
		Response response = request.post("/posts");
		int statusCode = response.getStatusCode();
		int expectedCode = 201;
		Assert.assertEquals(statusCode,expectedCode);
	}

}
