package com.ArkDev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.ArkDev.Constants.JsonConstants;
import com.ArkDev.Model.MovieList;
import com.ArkDev.R;
import com.bumptech.glide.Glide;

public class MovieDetailsActivity extends AppCompatActivity {

    private ImageView moviePoster;
    private TextView movieName, movieDesc, movieRating, movieDate, moviePopularity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        initUI();
        receiveBundle();
    }

    private void initUI(){
        movieName = findViewById(R.id.movie_name_detail);
        movieDesc = findViewById(R.id.movie_desc_detail);
        movieRating = findViewById(R.id.movie_rating_details);
        movieDate = findViewById(R.id.movie_date_details);
        moviePopularity = findViewById(R.id.movie_popularity_details);
    }

    private void receiveBundle(){
        Bundle intent = getIntent().getExtras();
        if(intent != null){
            MovieList movieList = intent.getParcelable("MOVIE");
            if(!movieList.getImagePath().isEmpty()){
                Glide.with(this).load(JsonConstants.IMAGE_BASE_URL + movieList.getImagePath())
                        .into(moviePoster);
            }

            if(!movieList.getMovieName().isEmpty()){
                movieName.setText(movieList.getMovieName());
            }

            if(!movieList.getDescription().isEmpty()){
                movieDesc.setText(movieList.getDescription());
            }

            if(!String.valueOf(movieList.getUserRating()).isEmpty()){
                movieRating.setText(String.valueOf(movieList.getUserRating()));
            }

            if(!movieList.getReleaseDate().isEmpty()){
                movieDate.setText(movieList.getReleaseDate());
            }

            if(!String.valueOf(movieList.getPopularity()).isEmpty()){
                moviePopularity.setText(String.valueOf(movieList.getPopularity()));
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
