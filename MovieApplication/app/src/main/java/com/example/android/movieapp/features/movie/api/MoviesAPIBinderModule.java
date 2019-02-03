package com.example.android.movieapp.features.movie.api;

import dagger.Binds;
import dagger.Module;

@Module
public interface MoviesAPIBinderModule {
    @Binds
    MoviesOrchestrator bindMoviesOrchestor (MoviesOrchestratorImpl impl);
}
