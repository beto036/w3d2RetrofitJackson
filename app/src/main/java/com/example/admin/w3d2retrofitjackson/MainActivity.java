package com.example.admin.w3d2retrofitjackson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.admin.w3d2retrofitjackson.model.RelatedTopic;
import com.example.admin.w3d2retrofitjackson.model.StarWars;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "https://api.duckduckgo.com/";
    private static final String TAG = "MainActivityTAG_";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doMagic(View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        StarWarsInterface batmanService = retrofit.create(StarWarsInterface.class);
        Call<StarWars> call = batmanService.retrievCharacters("star wars characters");

        call.enqueue(new Callback<StarWars>() {
            @Override
            public void onResponse(Call<StarWars> call, Response<StarWars> response) {
                StarWars batman = response.body();
                for (RelatedTopic relatedTopic : batman.getRelatedTopics()) {
                    Log.d(TAG, "onResponse: " + relatedTopic);
                }
            }

            @Override
            public void onFailure(Call<StarWars> call, Throwable t) {

            }
        });
    }
}
