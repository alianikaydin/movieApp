package com.example.android.movieapp.features.movie.tabs.now_playing;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.android.movieapp.BuildConfig;
import com.example.android.movieapp.R;
import com.example.android.movieapp.features.movie.pojo.Result;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NowPlayingListAdapter extends RecyclerView.Adapter<NowPlayingListAdapter.MovieViewHolder> {

    private final MovieNowPlayingContract.View view;
    private Context context;

    private List<Result> movieList;
    private LayoutInflater layoutInflater;

    public NowPlayingListAdapter(Context context, MovieNowPlayingContract.View view) {
        this.context = context;
        this.view = view;
        movieList = new ArrayList<>();
        layoutInflater = LayoutInflater.from(context);
    }

    public void addAll(List<Result> results) {
        movieList.addAll(results);
        notifyDataSetChanged();
    }

    public List<Result> getList() {
        return movieList;
    }


    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieViewHolder(layoutInflater.inflate(R.layout.movie_list_item, parent,
                false));
    }


    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.bindViews(movieList.get(position));
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.movie_list_item_image_view)
        ImageView ivMoviePoster;

        @BindView(R.id.movie_list_item_text_view)
        TextView textView;


        MovieViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindViews(Result result) {
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.drawable.ic_launcher_foreground);
            requestOptions.error(R.drawable.ic_launcher_foreground);
            requestOptions.fitCenter();
            Glide.with(context)
                    .asDrawable()
                    .apply(requestOptions)
                    .load(BuildConfig.IMAGE_URL_BASE + result.getPosterPath())
                    .into(ivMoviePoster);
                    textView.setText(result.getTitle());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    view.onMovieItemSelected(result);
                }
            });
        }
    }
}
