package com.doniapr.moviecatalogue.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.doniapr.moviecatalogue.Movie;
import com.doniapr.moviecatalogue.R;
import com.doniapr.moviecatalogue.TvShow;

public class DetailActivity extends AppCompatActivity {
    TextView txtTitle, txtGenre, txtRuntime, txtDirector, txtSinopsis;
    ImageView ivPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtTitle = findViewById(R.id.txt_title_detail);
        txtGenre = findViewById(R.id.txt_genre_detail_content);
        txtRuntime = findViewById(R.id.txt_runtime_detail_content);
        txtDirector = findViewById(R.id.txt_director_detail_content);
        ivPoster = findViewById(R.id.iv_poster_detail);
        txtSinopsis = findViewById(R.id.txt_content_sinopsis);

        if (getIntent().getParcelableExtra(MainActivity.EXTRA_TVSHOW) != null){
            TvShow tvShowData = getIntent().getParcelableExtra(MainActivity.EXTRA_TVSHOW);
            txtTitle.setText(tvShowData.getTitle());
            txtGenre.setText(tvShowData.getGenre());
            txtRuntime.setText(tvShowData.getRuntime());
            txtDirector.setText(tvShowData.getDirector());
            ivPoster.setImageResource(tvShowData.getPoster());
            txtSinopsis.setText(tvShowData.getSinopsis());
            super.setTitle(tvShowData.getTitle());
        } else if (getIntent().getParcelableExtra(MainActivity.EXTRA_MOVIE) != null){
            Movie movieData = getIntent().getParcelableExtra(MainActivity.EXTRA_MOVIE);
            txtTitle.setText(movieData.getTitle());
            txtGenre.setText(movieData.getGenre());
            txtRuntime.setText(movieData.getRuntime());
            txtDirector.setText(movieData.getDirector());
            ivPoster.setImageResource(movieData.getPoster());
            txtSinopsis.setText(movieData.getSinopsis());
            super.setTitle(movieData.getTitle());
        }


    }
}
