package com.ArkDev.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ArkDev.ItemView.MovieListItemView;
import com.ArkDev.Model.MovieList;
import com.ArkDev.R;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListItemView> {

    List<MovieList> movieListModels;

    public MovieListAdapter(List<MovieList> movieListDataModels) {
        this.movieListModels = movieListDataModels;
    }

    @NonNull
    @Override
    public MovieListItemView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.movie_list_item, viewGroup, false);
        return new MovieListItemView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieListItemView movieListItemView, int i) {
        //movieListItemView.bindView(movieListDataModels.get(i));
        //movieListItemView.
        //movieListItemView..setText(movieList.getMovieName());

        movieListItemView.getMovieName().setText(movieListModels.get(i).getMovieName());

    }

    @Override
    public int getItemCount() {
        return movieListModels.size();
    }
}
