package com.testeAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.hamcrest.collection.HasItemInArray;

import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;

public class TestesDeAPIAmericanasETheCatApi extends MassaDeDados{
	@BeforeClass
	public static void urlbase() {
		RestAssured.baseURI = "https://api.thecatapi.com/v1/";
	}

//	@Test
	public void americanas() {
		given()
		.when()
		.get("https://cep-v2-americanas-npf.b2w.io/cep/72979000").then().log().all();
	}
	
//	@Test
	public void cadastroApi() {
		given()
		.contentType("application/json")
		.body(corpoCadastro)
		.when()
		.post(urlCadastro)
		.then()
		.statusCode(200)
		.log().all();
	}
	
//	@Test
	public void cadastroApiCampoObrigatorio() {
		given()
		.contentType("application/json")
			.body("{\"appDescription\":\"vinicius6433\"}")
		.when()
			.post(urlCadastro)
		.then()
			.statusCode(400)
			.log().all()
			.body("message", containsString("\"email\" is required"));
	}
//	@Test
	public void efetuarVotacao() {
		Response response = 
			given()
				.contentType("application/json")
				.header("x-api-key",chaveAPI)
				.body(corpoVotacao)
			.when()
				.post(urlVotacao);
		
		
		
		response.then()
			.statusCode(200)
			.log().all();
			
		String id = response.jsonPath().getString("id");
		vote_id = id;
		validacao(response, 200);
		
	}
//	@Test
	public void pegarVotacao() {
		Response response = given()
			.contentType("application/json")
			.header("x-api-key",chaveAPI)
		.when()
			.get("votes");
		
		response.then().body("image_id", hasItems("_d8uJvi-Z","_d8uJvi-Z"));
		String id = response.jsonPath().getString("id[1]");
		vote_id = id;
		System.out.println("ID RETORNADO => "+id);
		
		
	}
	@Test
	public void deletarVotacao() {
		efetuarVotacao();
		pegarVotacao();
		given()
			.contentType("application/json")
			.header("x-api-key",chaveAPI)
			.pathParam("pegar_votacao", vote_id)
		.when()
			.delete(urlVotacao + "{pegar_votacao}")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	private void validacao(Response response, int status) {
		response.then().body("message", containsString("SUCCESS")).statusCode(status);
		System.out.println("RETORNO DA API =>" + response.body().asString());
		System.out.println("-----------------------------------------------------------------");
	}
}
