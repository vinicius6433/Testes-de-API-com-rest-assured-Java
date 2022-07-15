package com.testeAPI;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;



public class TesteAPI extends MassaDeDados{
	
	@BeforeClass
	public static void urlBase() {
		RestAssured.baseURI = "https://api.thecatapi.com/v1/";
	}
	
//	@Test
	public void cadastro() {
		
		
		//dado que o meu corpo seja json 
		//quando eu passar através da minha url em um post, então meu resultado será status 200
		Response response = given()
				.contentType("application/json")
				.body(corpoCadastro)
				.when()
				.post(urlCadastro);
		validacao(response,200);
	}
	
	@Test
	public void votacao() {
		Response response = given()
				.contentType("application/json")
				.body(corpoVotacao)
				.when()
				.post("votes/");
		
		response.then().body("message", containsString("SUCCESS")).statusCode(200);
		
		
		String id = response.jsonPath().getString("id");
		validacao(response,200);
		
		
	}
	@Test 
	public void deletaVoto() {
		
		Response response = given()
				.contentType("application/json")
				.body("{\"image_id\": \"vi3IOnq3n\", \"value\": \"true\", \"sub_id\": \"demo-f74ccd\"}")
				.when()
				.post(urlVotacao);

		
		String id = response.jsonPath().getString("id");
		vote_id = id;
		response = 
				given() 
				.contentType("application/json")
				.header("x-api-key" ,chaveAPI)
				.pathParam("delete_id", vote_id)
				.when().delete(urlVotacao + "{delete_id}");
		
		validacao(response,200);
	}
	
	public void validacao(Response response, int status) {
		response.then().body("message", containsString("SUCCESS")).statusCode(status);
		System.out.println("RETORNO DA API =>" + response.body().asString());
		System.out.println("-----------------------------------------------------------------");
	}
}
