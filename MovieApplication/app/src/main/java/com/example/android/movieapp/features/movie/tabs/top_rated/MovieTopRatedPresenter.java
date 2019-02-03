package com.example.android.movieapp.features.movie.tabs.top_rated;

import android.support.annotation.NonNull;

import com.example.android.movieapp.features.movie.api.MoviesOrchestrator;
import com.example.android.movieapp.features.movie.pojo.Response;
import com.example.android.movieapp.features.movie.pojo.Result;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

public class MovieTopRatedPresenter implements MovieTopRatedContract.Presenter {

    private final @NonNull
    MovieTopRatedContract.View view;

    private final @NonNull
    MoviesOrchestrator moviesOrchestrator;

    @Inject
    MovieTopRatedPresenter(@NonNull MovieTopRatedContract.View view,
                           @NonNull MoviesOrchestrator moviesOrchestrator) {
        this.view = view;
        this.moviesOrchestrator = moviesOrchestrator;
    }

    @Override
    public void bind() {
    }

    @Override
    public void getMovies(int page) {
        moviesOrchestrator.getTopRatedMovies(page).subscribe(new Observer<Response>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Response response) {
                if (response.getResults().size() > 0) {
                    List<Result> resultList = new ArrayList<>(response.getResults());
                    view.setMovieData(resultList);
                }
            }

            @Override
            public void onError(Throwable e) {
                Timber.e("error is: ", e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

}
