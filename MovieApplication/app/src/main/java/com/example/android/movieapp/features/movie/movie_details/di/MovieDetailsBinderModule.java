package com.example.android.movieapp.features.movie.movie_details.di;

import com.example.android.movieapp.features.movie.movie_details.MovieDetailsContract;
import com.example.android.movieapp.features.movie.movie_details.MovieDetailsFragment;
import com.example.android.movieapp.features.movie.movie_details.MovieDetailsPresenter;

import dagger.Binds;
import dagger.Module;

@Module
public interface MovieDetailsBinderModule {
    @Binds
    MovieDetailsContract.View bindMovieDetailsView(MovieDetailsFragment impl);

    @Binds
    MovieDetailsContract.Presenter bindMovieDetailsPresenter(MovieDetailsPresenter impl);

}
