package com.ArkDev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ArkDev.Adapters.MovieListAdapter;
import com.ArkDev.Constants.JsonConstants;
import com.ArkDev.Interface.ApiInterface;
import com.ArkDev.Model.MovieModel;
import com.ArkDev.Model.MovieList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    Map<String,String> api_key = new HashMap<String, String>();
    Map<String,String> page_number = new HashMap<String, String>();

    List<MovieList> moviesList = new ArrayList<MovieList>();

    MovieListAdapter movieListAdapter;

    Integer pageCount = 0;
    LinearLayoutManager mLayoutManager;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(JsonConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface = retrofit.create(ApiInterface.class);

        recyclerView = findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        retrieveMovies();
    }

    private void retrieveMovies(){
        pageCount += 1;
        api_key.put("api_key", "633952f05dc8bfe4b0c7b41f1430f13e");
        page_number.put("page",String.valueOf(pageCount));

        Call<MovieModel> getPopularMovies = apiInterface.getMovies(api_key, page_number);
        getPopularMovies.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                if(response.isSuccessful()){
                    if(response.body().getResults().size() != 0 &&
                            response.body().getResults() != null){
                        for(int i = 0; i < response.body().getResults().size(); i++){
                            moviesList.add(new MovieList(
                                    response.body().getResults().get(i).getPosterPath(),
                                    response.body().getResults().get(i).getOriginalTitle(),
                                    response.body().getResults().get(i).getOverview(),
                                    response.body().getResults().get(i).getVoteAverage(),
                                    response.body().getResults().get(i).getReleaseDate(),
                                    response.body().getResults().get(i).getPopularity()
                            ));

                            movieListAdapter = new MovieListAdapter(moviesList);
                            recyclerView.setAdapter(movieListAdapter);
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "result is empty", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "response wasn't successful", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed to retrieve data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
