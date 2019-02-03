package com.example.android.movieapp.features.movie.tabs.top_rated;

import com.example.android.movieapp.features.movie.pojo.Result;

import java.util.List;

public interface MovieTopRatedContract {
    interface View {
        void onMovieItemSelected(Result result);

        void setMovieData(List<Result> resultList);
    }
    interface Presenter{
        void bind();

        void getMovies(int page);
    }
}
