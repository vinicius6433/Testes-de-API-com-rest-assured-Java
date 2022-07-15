package com.testeAPI;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.Console;

import org.junit.Test;

public class DesafioFavorita extends MassaDeDados{
	String vote_id;
	
	@BeforeClass
	public static void urlbase() {
		RestAssured.baseURI = "https://api.thecatapi.com/v1/";
	}
	
	private void favorita() {
		
		Response response = given().contentType("application/json")
				.header("x-api-key",chaveAPI)
				.body(corpoFavorita)
				.post(urlFavorita);
		
				String id = response.jsonPath().getString("id");
				vote_id = id;
				
				validacao(response,200);
	}
	private void desfavorita() {
		Response response = 
				given()
				.contentType("application/json")
				.header("x-api-key",chaveAPI)
				.pathParam("favorite_id", vote_id)
				.when().delete(urlFavorita + "{favorite_id}");
		
				String id = response.jsonPath().getString("id");
				vote_id = id;
				validacao(response,200);

				
	}
	@Test
	public void favoritaDesfavorita() {
		favorita();
		desfavorita();
		// validando se foi excluido com sucesso
		System.out.println(vote_id);
	}
	
	public void validacao(Response response, int status) {
		response.then().body("message", containsString("SUCCESS")).statusCode(status);
		System.out.println("RETORNO DA API =>" + response.body().asString());
		System.out.println("-----------------------------------------------------------------");
	}
}
