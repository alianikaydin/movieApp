package com.example.android.movieapp.features.movie.tabs.now_playing;

import android.support.annotation.NonNull;

import com.example.android.movieapp.features.movie.api.MoviesOrchestrator;
import com.example.android.movieapp.features.movie.pojo.Response;
import com.example.android.movieapp.features.movie.pojo.Result;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

public class MovieNowPlayingPresenter implements MovieNowPlayingContract.Presenter {

    private final @NonNull
    MovieNowPlayingContract.View view;

    private final @NonNull
    MoviesOrchestrator moviesOrchestrator;
    private static ArrayList<Result> resultList;

    @Inject
    MovieNowPlayingPresenter(@NonNull MovieNowPlayingContract.View view,
                             @NonNull MoviesOrchestrator moviesOrchestrator) {
        this.view = view;
        this.moviesOrchestrator = moviesOrchestrator;
    }

    @Override
    public void bind() {
    }

    @Override
    public void getMovies(int page) {
        if (resultList != null) {
            view.setMovieData(resultList);
        } else {
            view.showSplashScreen();
            moviesOrchestrator.getNowPlayingMovies(page).subscribe(new Observer<Response>() {
                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onNext(Response response) {
                    view.removeSplashScreen();
                    if (response.getResults().size() > 0) {
                        resultList = new ArrayList<>(response.getResults());
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

}
