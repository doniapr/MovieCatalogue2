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

import com.doniapr.moviecatalogue.Adapter.TvShowAdapter;
import com.doniapr.moviecatalogue.R;
import com.doniapr.moviecatalogue.TvShow;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowFragment extends Fragment {
    private RecyclerView rvTvShow;
    private String[] tvShowTitle;
    private String[] tvShowSinopsis, tvShowDirector, tvShowRuntime, tvShowGenre;
    private int[] tvShowYear, tvShowRating;
    private TypedArray poster;
    private ArrayList<TvShow> tvShows;

    public TvShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        prepare();
        addItem();
        rvTvShow = view.findViewById(R.id.rv_tv_show_list);
        rvTvShow.setLayoutManager(new LinearLayoutManager(getContext()));
        final TvShowAdapter tvShowAdapter = new TvShowAdapter(getContext());
        tvShowAdapter.setListTvShow(tvShows);
        rvTvShow.setAdapter(tvShowAdapter);

    }

    private void addItem() {
        tvShows = new ArrayList<>();

        for (int i = 0; i < tvShowTitle.length; i++) {
            TvShow tv = new TvShow();
            tv.setTitle(tvShowTitle[i]);
            tv.setYear(tvShowYear[i]);
            tv.setRuntime(tvShowRuntime[i]);
            tv.setDirector(tvShowDirector[i]);
            tv.setGenre(tvShowGenre[i]);
            tv.setSinopsis(tvShowSinopsis[i]);
            tv.setRating(tvShowRating[i]);
            tv.setPoster(poster.getResourceId(i, -1));

            tvShows.add(tv);
        }
    }

    private void prepare() {
        tvShowTitle = getResources().getStringArray(R.array.tv_title);
        tvShowYear = getResources().getIntArray(R.array.tv_year);
        tvShowRuntime = getResources().getStringArray(R.array.tv_runtime);
        tvShowDirector = getResources().getStringArray(R.array.tv_director);
        tvShowGenre = getResources().getStringArray(R.array.tv_genre);
        tvShowSinopsis = getResources().getStringArray(R.array.tv_sinopsis);
        tvShowRating = getResources().getIntArray(R.array.tv_rating);
        poster = getResources().obtainTypedArray(R.array.tv_poster);

    }
}
