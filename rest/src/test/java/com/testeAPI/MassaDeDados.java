package com.testeAPI;

public class MassaDeDados {
	String vote_id;
	
	String email = "tofiyi3372@tebyy.com",
			chaveAPI = "4b9b635b-ee7d-4894-953e-fc899a9a48a0";
	
	//cadastro
	String urlCadastro = "https://api.thecatapi.com/v1/user/passwordlesssignup"
			,corpoCadastro = "{\"email\":\""+email+"\", \"appDescription\":\"vinicius6433\"}";
	
	//votação
	String corpoVotacao = "{\"image_id\": \"_d8uJvi-Z\", \"value\": \"true\"}"
			,urlVotacao = "votes/";
	
	//favorita
	String corpoFavorita = "{\"image_id\": \"JpzC_n7yU\"}"
			,urlFavorita = "favourites/";
	
	
}
