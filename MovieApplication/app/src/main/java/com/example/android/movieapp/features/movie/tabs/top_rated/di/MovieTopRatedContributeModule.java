package com.example.android.movieapp.features.movie.tabs.top_rated.di;

import com.example.android.movieapp.features.movie.tabs.top_rated.MovieTopRatedFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface MovieTopRatedContributeModule {
    @ContributesAndroidInjector(modules = MovieTopRatedModule.class)
    MovieTopRatedFragment bindMovieTopRatedFragment();
}
