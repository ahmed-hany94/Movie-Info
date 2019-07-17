package com.ArkDev.Interface;

import com.ArkDev.Constants.JsonConstants;
import com.ArkDev.Model.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET(JsonConstants.POPULAR_MOVIES)
    Call<MovieModel> getMovies(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page
    );
}
