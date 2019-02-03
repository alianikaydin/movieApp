package com.example.android.movieapp.features.movie.movie_details;

import android.support.annotation.NonNull;

import com.example.android.movieapp.features.movie.api.MoviesOrchestrator;
import com.example.android.movieapp.features.movie.pojo.Result;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class MovieDetailsPresenter implements MovieDetailsContract.Presenter{

    private final @NonNull
    MovieDetailsContract.View view;
    private final @NonNull
    MoviesOrchestrator moviesOrchestrator;

    @Inject
    MovieDetailsPresenter(@NonNull MovieDetailsContract.View view, @NonNull MoviesOrchestrator moviesOrchestrator){
        this.view = view;
        this.moviesOrchestrator = moviesOrchestrator;
    }

    @Override
    public void bind() {

    }

    @Override
    public void addMovieToFavs(Result selectedMovie) {
        moviesOrchestrator.insertMovie(selectedMovie);
        view.setButtonNameAddFav(true);
    }

    @Override
    public void removeMovieFromFavs(Result selectedMovie) {
        moviesOrchestrator.deleteMovie(selectedMovie);
        view.setButtonNameAddFav(false);
    }

    @Override
    public void isMovieLiked(int selectedMovieId) {
        moviesOrchestrator.getMovie(selectedMovieId).subscribe(new SingleObserver<Result>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(Result result) {
                view.setButtonNameAddFav(true);
            }

            @Override
            public void onError(Throwable e) {
                view.setButtonNameAddFav(false);
            }
        });
    }
}
