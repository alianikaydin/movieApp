package com.example.android.movieapp.features.movie.tabs.favourites;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;

import com.example.android.movieapp.features.movie.api.MoviesOrchestrator;
import com.example.android.movieapp.features.movie.pojo.Result;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

public class MovieFavouritesPresenter implements MovieFavouritesContract.Presenter {

    private final @NonNull
    MovieFavouritesContract.View view;

    private final @NonNull
    MoviesOrchestrator moviesOrchestrator;

    @Inject
    MovieFavouritesPresenter(@NonNull MovieFavouritesContract.View view,
                             @NonNull MoviesOrchestrator moviesOrchestrator){
        this.view = view;
        this.moviesOrchestrator = moviesOrchestrator;
    }

    @Override
    public void bind() {}

    @SuppressLint("CheckResult")
    @Override
    public void getMovies(){
        moviesOrchestrator.getFavouriteMovies().subscribe(new Consumer<List<Result>>() {
            @Override
            public void accept(List<Result> results) throws Exception {
                List<Result> resultList = new ArrayList<>(results);
                view.setMovieData(resultList);
            }
        });

    }

}
