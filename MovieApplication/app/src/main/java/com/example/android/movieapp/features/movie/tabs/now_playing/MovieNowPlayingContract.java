package com.example.android.movieapp.features.movie.tabs.now_playing;

import com.example.android.movieapp.features.movie.pojo.Result;

import java.util.List;

public interface MovieNowPlayingContract {
    interface View {

        void setMovieData(List<Result> resultList);

        void onMovieItemSelected(Result result);

        void showSplashScreen();

        void removeSplashScreen();
    }

    interface Presenter {
        void bind();

        void getMovies(int page);
    }
}
