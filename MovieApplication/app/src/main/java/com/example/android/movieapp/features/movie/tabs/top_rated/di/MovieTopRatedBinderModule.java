package com.example.android.movieapp.features.movie.tabs.top_rated.di;

import com.example.android.movieapp.features.movie.tabs.top_rated.MovieTopRatedContract;
import com.example.android.movieapp.features.movie.tabs.top_rated.MovieTopRatedFragment;
import com.example.android.movieapp.features.movie.tabs.top_rated.MovieTopRatedPresenter;

import dagger.Binds;
import dagger.Module;

@Module
public interface MovieTopRatedBinderModule {
    @Binds
    MovieTopRatedContract.View bindMovieTopRatedView(MovieTopRatedFragment impl);


    @Binds
    MovieTopRatedContract.Presenter bindMoiveTopRatedPresenter(MovieTopRatedPresenter impl);
}
