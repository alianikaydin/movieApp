package com.example.android.movieapp.features.movie.tabs.favourites.di;

import com.example.android.movieapp.features.movie.tabs.favourites.MovieFavouritesFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface MovieFavouritesContributeModule {
    @ContributesAndroidInjector(modules = MovieFavouritesModule.class)
    MovieFavouritesFragment bindMovieFavouritesFragment();
}