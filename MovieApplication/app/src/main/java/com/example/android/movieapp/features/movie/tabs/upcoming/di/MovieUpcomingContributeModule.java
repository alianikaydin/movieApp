package com.example.android.movieapp.features.movie.tabs.upcoming.di;

import com.example.android.movieapp.features.movie.tabs.upcoming.MovieUpcomingFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface MovieUpcomingContributeModule {
    @ContributesAndroidInjector(modules = MovieUpcomingModule.class)
    MovieUpcomingFragment bindMovieUpcomingFragment();
}
