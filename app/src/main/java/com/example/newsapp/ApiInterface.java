package com.example.newsapp;

import com.example.newsapp.Models.mainNews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    String Base_URL = "https://newsapi.org/v2/";

    @GET("top-headlines")
    Call<mainNews> getNews(@Query("country") String country
                            , @Query("pageSize") int page
                            , @Query("apiKey") String apiKey);

    @GET("top-headlines")
    Call<mainNews> getCategoryNews(@Query("country") String country
                                   ,@Query("category") String category
            ,@Query("pageSize") int page
            ,@Query("apiKey") String apiKey);
}
