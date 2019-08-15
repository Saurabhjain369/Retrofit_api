package com.example.retrofit_api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofitclass {

    private static Retrofit retrofit;

    private static final String Base_url ="https://next.json-generator.com/api/json/get/";


   public static Retrofit getRetrofitInstance(){

       if(retrofit == null)

       {

           retrofit = new retrofit2.Retrofit.Builder().baseUrl(Base_url).addConverterFactory(GsonConverterFactory.create()).build();


       }

       return retrofit;

    }




}
