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
import com.doniapr.moviecatalogue.R;
import com.doniapr.moviecatalogue.TvShow;

import java.util.ArrayList;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder> {
    private Context context;
    private ArrayList<TvShow> listTvShow;

    public TvShowAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<TvShow> getListTvShow() {
        return listTvShow;
    }

    public void setListTvShow(ArrayList<TvShow> listTvShow) {
        this.listTvShow = listTvShow;
    }

    @NonNull
    @Override
    public TvShowViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tv_show, viewGroup, false);

        return new TvShowViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowViewHolder tvShowViewHolder, int i) {
        final TvShow tvShow = getListTvShow().get(i);
        Glide.with(context)
                .load(tvShow.getPoster())
                .into(tvShowViewHolder.ivPosterTvShow);
        tvShowViewHolder.txtTitleTvShow.setText(tvShow.getTitle());
        tvShowViewHolder.txtGenreContentTvShow.setText(tvShow.getGenre());
        tvShowViewHolder.txtRuntimeContentTvShow.setText(tvShow.getRuntime());

        tvShowViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TvShow tvShowData = new TvShow();
                tvShowData.setTitle(tvShow.getTitle());
                tvShowData.setYear(tvShow.getYear());
                tvShowData.setRuntime(tvShow.getRuntime());
                tvShowData.setDirector(tvShow.getDirector());
                tvShowData.setGenre(tvShow.getGenre());
                tvShowData.setSinopsis(tvShow.getSinopsis());
                tvShowData.setRating(tvShow.getRating());
                tvShowData.setPoster(tvShow.getPoster());

                Intent detail = new Intent(context, DetailActivity.class);
                detail.putExtra(MainActivity.EXTRA_TVSHOW, tvShowData);
                context.startActivity(detail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListTvShow().size();
    }

    public class TvShowViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPosterTvShow;
        TextView txtTitleTvShow, txtRuntimeTvShow, txtRuntimeContentTvShow, txtGenreTvShow, txtGenreContentTvShow;

        public TvShowViewHolder(@NonNull View itemView) {
            super(itemView);

            ivPosterTvShow = itemView.findViewById(R.id.iv_poster_tv_show);
            txtTitleTvShow  = itemView.findViewById(R.id.txt_title_tv_show);
            txtRuntimeTvShow = itemView.findViewById(R.id.txt_runtime_tv);
            txtRuntimeContentTvShow = itemView.findViewById(R.id.txt_content_runtime_tv);
            txtGenreTvShow = itemView.findViewById(R.id.txt_genre_tv);
            txtGenreContentTvShow = itemView.findViewById(R.id.txt_content_genre_tv);
        }
    }
}

