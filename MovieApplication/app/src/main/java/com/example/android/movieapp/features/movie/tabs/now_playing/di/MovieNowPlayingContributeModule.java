package com.example.android.movieapp.features.movie.tabs.now_playing.di;

import com.example.android.movieapp.features.movie.tabs.now_playing.MovieNowPlayingFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface MovieNowPlayingContributeModule {
    @ContributesAndroidInjector(modules = MovieNowPlayingModule.class)
    MovieNowPlayingFragment bindMovieNowPlayingFragment();
}
