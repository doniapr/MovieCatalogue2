package com.doniapr.moviecatalogue.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.doniapr.moviecatalogue.Activity.DetailActivity;
import com.doniapr.moviecatalogue.Activity.MainActivity;
import com.doniapr.moviecatalogue.Movie;
import com.doniapr.moviecatalogue.R;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private Context context;
    private ArrayList<Movie> listMovie;

    public MovieAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Movie> getListMovie() {
        return listMovie;
    }

    public void setListMovie(ArrayList<Movie> listMovie) {
        this.listMovie = listMovie;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie, viewGroup, false);
        return new MovieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int i) {
        final Movie movie = getListMovie().get(i);

        Glide.with(context)
                .load(movie.getPoster())
                .into(movieViewHolder.ivPosterMovie);
        movieViewHolder.txtTitleMovie.setText(movie.getTitle());
        movieViewHolder.txtRuntimeContentMovie.setText(movie.getRuntime());
        movieViewHolder.txtGenreContentMovie.setText(movie.getGenre());

        movieViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Movie movieData = new Movie();
                movieData.setTitle(movie.getTitle());
                movieData.setYear(movie.getYear());
                movieData.setRuntime(movie.getRuntime());
                movieData.setDirector(movie.getDirector());
                movieData.setGenre(movie.getGenre());
                movieData.setSinopsis(movie.getSinopsis());
                movieData.setRating(movie.getRating());
                movieData.setPoster(movie.getPoster());

                Intent detail = new Intent(context, DetailActivity.class);
                detail.putExtra(MainActivity.EXTRA_MOVIE, movieData);
                context.startActivity(detail);
            }
        });

    }

    @Override
    public int getItemCount() {
        return getListMovie().size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPosterMovie;
        TextView txtTitleMovie, txtRuntimeMovie, txtRuntimeContentMovie, txtGenreMovie, txtGenreContentMovie;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPosterMovie = itemView.findViewById(R.id.iv_poster_movie);
            txtTitleMovie  = itemView.findViewById(R.id.txt_title_movie);
            txtRuntimeMovie = itemView.findViewById(R.id.txt_runtime);
            txtRuntimeContentMovie = itemView.findViewById(R.id.txt_content_runtime);
            txtGenreMovie = itemView.findViewById(R.id.txt_genre);
            txtGenreContentMovie = itemView.findViewById(R.id.txt_content_genre);

        }
    }
}
