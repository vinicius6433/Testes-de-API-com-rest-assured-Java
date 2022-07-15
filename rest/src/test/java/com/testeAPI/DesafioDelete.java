package com.testeAPI;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DesafioDelete {
	@Test
	public void cadastro() {
		String url = "https://api.thecatapi.com/v1/user/passwordlesssignup";
		String body = "{\"email\":\"nojeleh438@tebyy.com\", \"appDescription\":\"vinicius6433\"}";
		// dado que o meu corpo seja json
		// quando eu passar através da minha url em um post, então meu resultado será
		// status 200
		Response response = given().contentType("application/json").body(body).when().post(url);
		response.then().body("message", containsString("SUCCESS")).statusCode(200);

		System.out.println("RETORNO =>" + response.body().asString());
	}

//	@Test
	public void favorita() {

		String url = "https://api.thecatapi.com/v1/favourites/";
		String body = "{\"image_id\": \"9ob\", \"sub_id\": \"demo-f74ccd\"}";
		Response response = given().contentType("application/json")
				.header("x-api-key", "b40c55d5-a80d-416f-88cb-bbe9da961815")
				.body(body)
				.when()
				.post(url);
		response.then().log().all();

		response.then().body("message", containsString("SUCCESS")).statusCode(200);

		System.out.println("RETORNO =>" + response.body().asString());
		
	}
//	@Test
	public void delete() {
		String id = "100040972"; 
		String url = "https://api.thecatapi.com/v1/favourites/"+id+"";
		String body = "{\"image_id\": \"9ob\", \"sub_id\": \"demo-f74ccd\"}";
		Response response = given().contentType("application/json")
				.header("x-api-key", "b40c55d5-a80d-416f-88cb-bbe9da961815")
				.when()
				.delete(url);
		response.then().log().all();
		
		response.then().body("message", containsString("SUCCESS")).statusCode(200);

		System.out.println("RETORNO =>" + response.body().asString());
	}
}
