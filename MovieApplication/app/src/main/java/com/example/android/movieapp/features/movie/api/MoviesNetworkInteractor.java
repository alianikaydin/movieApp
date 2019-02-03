package com.example.android.movieapp.features.movie.api;

import com.example.android.movieapp.features.movie.pojo.Response;

import io.reactivex.Observable;

public interface MoviesNetworkInteractor {
    Observable<Response> getNowPlayingMovies(int page);

    Observable<Response> getTopRatedMovies(int page);

    Observable<Response> getUpcomingMovies(int page);
}
