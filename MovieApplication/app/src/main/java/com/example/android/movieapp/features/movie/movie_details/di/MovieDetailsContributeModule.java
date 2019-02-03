package com.example.android.movieapp.features.movie.movie_details.di;

import com.example.android.movieapp.features.movie.movie_details.MovieDetailsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface MovieDetailsContributeModule {
    @ContributesAndroidInjector(modules = MovieDetailsModule.class)
    MovieDetailsFragment bindMovieDetailsFragment();
}
