package com.example.retrofit_api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Endpoint {

    @GET("Vy2abloQD")
    Call<List<Pokemon>> getPokemon();


    @GET("E14trR2lD")
    Call<Pokemonpojo> getPokemonobj();








}
