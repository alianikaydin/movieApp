package com.example.android.movieapp.features.movie.api;

import android.support.annotation.NonNull;

import com.example.android.movieapp.features.movie.pojo.Response;
import com.example.android.movieapp.features.movie.pojo.Result;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface MoviesOrchestrator {
    @NonNull
    Observable<Response> getNowPlayingMovies(int page);
    @NonNull
    Observable<Response>  getTopRatedMovies(int page);
    @NonNull
    Observable<Response> getUpcomingMovies(int page);

    @NonNull
    Flowable<List<Result>> getFavouriteMovies();

    @NonNull
    Single<Result> getMovie(int id);

    void insertMovie(Result result);

    void deleteMovie(Result result);
}
