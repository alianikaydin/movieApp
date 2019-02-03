package com.example.android.movieapp.network.interactors;

import com.example.android.movieapp.features.movie.api.MoviesNetworkInteractor;

import dagger.Binds;
import dagger.Module;

@Module
public interface NetworkInteractorBindingModule {
    @Binds
    MoviesNetworkInteractor bindMoviesNetworkInteractor(MoviesNetworkInteractorImpl impl);
}
