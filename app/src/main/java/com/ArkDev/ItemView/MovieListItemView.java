package com.ArkDev.ItemView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ArkDev.Adapters.MovieListAdapter;
import com.ArkDev.Constants.JsonConstants;
import com.ArkDev.Model.MovieList;
import com.ArkDev.R;
import com.bumptech.glide.Glide;

public class MovieListItemView extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ImageView moviePoster;
    private TextView movieName, movieDesc, userRating, releaseDate, moviePopularity;
    View itemView;
    MovieListAdapter.OnNoteListener onNoteListener;

    public MovieListItemView(@NonNull View itemView, MovieListAdapter.OnNoteListener onNoteListener) {
        super(itemView);
        this.itemView = itemView;
        this.onNoteListener = onNoteListener;
        moviePoster = itemView.findViewById(R.id.movie_poster);
        movieName = itemView.findViewById(R.id.movie_name);
        movieDesc = itemView.findViewById(R.id.movie_desc);
        userRating = itemView.findViewById(R.id.movie_rating);
        releaseDate = itemView.findViewById(R.id.movie_date);
        moviePopularity = itemView.findViewById(R.id.movie_popularity);

        itemView.setOnClickListener(this);
    }

    public void bindView(MovieList movieList){
        movieName.setText(movieList.getMovieName());
        movieDesc.setText(movieList.getDescription());
        userRating.setText(String.valueOf(movieList.getUserRating()));
        releaseDate.setText(movieList.getReleaseDate());
        moviePopularity.setText(String.valueOf(movieList.getPopularity()));

        Glide.with(itemView).load(JsonConstants.IMAGE_BASE_URL + movieList.getImagePath()).into(moviePoster);
    }

    @Override
    public void onClick(View view) {
        onNoteListener.onNoteClick(getAdapterPosition());
    }
}
