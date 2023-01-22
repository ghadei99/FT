package com.exaze;

import org.json.simple.parser.ParseException;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import util.UtilsClass;

public class WithRestAssured {
//	public static void main(String[] args) throws ParseException {
////		RestAssured.baseURI = "https://gorest.co.in/public/v2";
//		RequestSpecification request = RestAssured.given();
//		Response response = request.get("https://gorest.co.in/public/v2/users");
//		System.out.println(response.getStatusCode());
//		System.out.println(response.getBody().asPrettyString());
//
//		org.json.simple.JSONArray arr = UtilsClass.returnJsonArrayFromResponse(response);
//
//		for (Object object : arr) {
//			org.json.simple.JSONObject obj = (org.json.simple.JSONObject) object;
//			String name = (String) obj.get("name");
//			System.out.println(name);
//		}
//	}
	
	
	public static int sendingGetRequest() {
		RequestSpecification request = RestAssured.given();
		Response response = request.get("https://gorest.co.in/public/v2/users");
		return response.statusCode();
	}
}
