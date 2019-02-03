package com.example.android.movieapp.features.movie.api;

import android.support.annotation.NonNull;

import com.example.android.movieapp.features.movie.pojo.Result;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

public interface FavouriteMoviesLocalInteractor {

    @NonNull
    Flowable<List<Result>> getAllFavourites();

    @NonNull
    Single<Result> getMovie(int id);

    void insertMovie(Result result);

    void deleteMovie(Result result);
}
