package com.ArkDev.ItemView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ArkDev.Model.MovieList;
import com.ArkDev.R;

public class MovieListItemView extends RecyclerView.ViewHolder{

    private ImageView moviePoster;
    private TextView movieName;

    public MovieListItemView(@NonNull View itemView) {
        super(itemView);
        moviePoster = itemView.findViewById(R.id.movie_poster);
        movieName = itemView.findViewById(R.id.movie_name);
    }

//    public bindView(MovieList movieList){
//        movieName.setText(movieList.getMovieName());
//    }


    public ImageView getMoviePoster() {
        return moviePoster;
    }

    public TextView getMovieName() {
        return movieName;
    }
}
