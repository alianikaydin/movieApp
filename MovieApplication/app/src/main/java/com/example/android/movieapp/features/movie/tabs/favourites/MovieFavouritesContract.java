package com.example.android.movieapp.features.movie.tabs.favourites;

import com.example.android.movieapp.features.movie.pojo.Result;

import java.util.List;

public interface MovieFavouritesContract {
    interface View {

        void setMovieData(List<Result> resultList);

        void onMovieItemSelected(Result result);
    }

    interface Presenter {
        void bind();

        void getMovies();
    }
}
