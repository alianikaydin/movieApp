package com.example.android.movieapp.features.movie.api;

import android.support.annotation.NonNull;

import com.example.android.movieapp.core.scheduler.JobScheduler;
import com.example.android.movieapp.features.movie.pojo.Response;
import com.example.android.movieapp.features.movie.pojo.Result;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;

public class MoviesOrchestratorImpl implements MoviesOrchestrator {
    private final @NonNull
    FavouriteMoviesLocalInteractor favouriteMoviesLocalInteractor;
    private @NonNull
    MoviesNetworkInteractor moviesNetworkInteractor;
    private final @NonNull
    JobScheduler jobScheduler;

    @Inject
    public MoviesOrchestratorImpl(@NonNull MoviesNetworkInteractor moviesNetworkInteractor,
                                  @NonNull FavouriteMoviesLocalInteractor favouriteMoviesLocalInteractor,
                                  @NonNull JobScheduler jobScheduler) {
        this.moviesNetworkInteractor = moviesNetworkInteractor;
        this.favouriteMoviesLocalInteractor = favouriteMoviesLocalInteractor;
        this.jobScheduler = jobScheduler;
    }

    @NonNull
    @Override
    public Observable<Response> getNowPlayingMovies(int page) {
        return moviesNetworkInteractor.getNowPlayingMovies(page)
                .subscribeOn(jobScheduler.background())
                .observeOn(jobScheduler.main());
    }

    @NonNull
    @Override
    public Observable<Response> getTopRatedMovies(int page) {
        return moviesNetworkInteractor.getTopRatedMovies(page)
                .subscribeOn(jobScheduler.background())
                .observeOn(jobScheduler.main());
    }

    @NonNull
    @Override
    public Observable<Response> getUpcomingMovies(int page) {
        return moviesNetworkInteractor.getUpcomingMovies(page)
                .subscribeOn(jobScheduler.background())
                .observeOn(jobScheduler.main());
    }

    @NonNull
    @Override
    public Flowable<List<Result>> getFavouriteMovies() {
        return favouriteMoviesLocalInteractor.getAllFavourites()
                .subscribeOn(jobScheduler.background())
                .observeOn(jobScheduler.main());
    }

    @NonNull
    @Override
    public Single<Result> getMovie(int id) {
        return favouriteMoviesLocalInteractor.getMovie(id)
                .subscribeOn(jobScheduler.background())
                .observeOn(jobScheduler.main());
    }

    @Override
    public void insertMovie(Result result) {
        Single.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() {
                favouriteMoviesLocalInteractor.insertMovie(result);
                return true;
            }
        }).subscribeOn(jobScheduler.background()).subscribe();

    }

    @Override
    public void deleteMovie(Result result) {

        Single.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() {
                favouriteMoviesLocalInteractor.deleteMovie(result);
                return true;
            }
        }).subscribeOn(jobScheduler.background()).subscribe();

    }


}
