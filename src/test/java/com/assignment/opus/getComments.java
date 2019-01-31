package com.assignment.opus;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getComments {

	@Test
	public void getcommentsDetails() {
		RestAssured.baseURI =constants.endPoint;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/comments");
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode,200);

	}

}
