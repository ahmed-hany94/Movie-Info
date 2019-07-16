package com.ArkDev.Interface;

import com.ArkDev.Constants.JsonConstants;
import com.ArkDev.Model.MovieModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ApiInterface {

    @GET(JsonConstants.POPULAR_MOVIES)
    Call<MovieModel> getMovies(
            @QueryMap Map<String,String> apiKe
            //@QueryMap Map<String,String> pageId
    );
}
