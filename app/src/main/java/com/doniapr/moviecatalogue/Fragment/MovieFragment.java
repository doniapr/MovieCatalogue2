package com.doniapr.moviecatalogue.Fragment;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.doniapr.moviecatalogue.Adapter.MovieAdapter;
import com.doniapr.moviecatalogue.Movie;
import com.doniapr.moviecatalogue.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {

    private RecyclerView rvMovie;
    private ArrayList<Movie> list = new ArrayList<>();
    private String[] movieTitle;
    private String[] movieSinopsis, movieDirector, movieRuntime, movieGenre;
    private int[] movieYear, movieRating;
    private TypedArray poster;
    private ArrayList<Movie> movies;

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        prepare();
        addItem();
        rvMovie = view.findViewById(R.id.rv_movie_list);
        rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
        MovieAdapter movieAdapter = new MovieAdapter(getContext());
        movieAdapter.setListMovie(movies);
        rvMovie.setAdapter(movieAdapter);
    }

    private void addItem() {
        movies = new ArrayList<>();

        for (int i = 0; i < movieTitle.length; i++) {
            Movie movie = new Movie();
            movie.setTitle(movieTitle[i]);
            movie.setYear(movieYear[i]);
            movie.setRuntime(movieRuntime[i]);
            movie.setDirector(movieDirector[i]);
            movie.setGenre(movieGenre[i]);
            movie.setSinopsis(movieSinopsis[i]);
            movie.setRating(movieRating[i]);
            movie.setPoster(poster.getResourceId(i, -1));

            movies.add(movie);
        }

    }

    private void prepare() {
        movieTitle = getResources().getStringArray(R.array.movie_title);
        movieYear = getResources().getIntArray(R.array.movie_year);
        movieRuntime = getResources().getStringArray(R.array.movie_runtime);
        movieDirector = getResources().getStringArray(R.array.movie_director);
        movieGenre = getResources().getStringArray(R.array.movie_genre);
        movieSinopsis = getResources().getStringArray(R.array.movie_sinopsis);
        movieRating = getResources().getIntArray(R.array.movie_rating);
        poster = getResources().obtainTypedArray(R.array.movie_poster);

    }
}
