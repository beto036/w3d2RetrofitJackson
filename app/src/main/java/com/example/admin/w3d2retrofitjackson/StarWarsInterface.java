package com.example.admin.w3d2retrofitjackson;

import com.example.admin.w3d2retrofitjackson.model.StarWars;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by admin on 11/1/2016.
 */

public interface StarWarsInterface {
    @GET("?format=json")
    Call<StarWars> retrievCharacters(@Query("q") String q);
}
