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

    private List<MovieList> movieListModels;
    private OnNoteListener mOnNoteListener;

    public MovieListAdapter() {

    }

    @NonNull
    @Override
    public MovieListItemView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.movie_list_item, viewGroup, false);
        return new MovieListItemView(view, mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieListItemView movieListItemView, int i) {
        movieListItemView.bindView(movieListModels.get(i));

    }

    @Override
    public int getItemCount() {
        return movieListModels.size();
    }

    public interface OnNoteListener{
        void onNoteClick(int position);
    }

    public List<MovieList> getMovieListModels() {
        return movieListModels;
    }

    public void setMovieListModels(List<MovieList> movieListModels) {
        this.movieListModels = movieListModels;
    }

    public OnNoteListener getmOnNoteListener() {
        return mOnNoteListener;
    }

    public void setmOnNoteListener(OnNoteListener mOnNoteListener) {
        this.mOnNoteListener = mOnNoteListener;
    }
}
