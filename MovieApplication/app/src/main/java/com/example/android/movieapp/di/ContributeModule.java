package com.example.android.movieapp.di;

import com.example.android.movieapp.features.movie.di.MovieContributesModule;

import dagger.Module;

@Module(includes = MovieContributesModule.class)
interface ContributeModule {
}
