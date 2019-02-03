package com.example.android.movieapp.database.interactors;

import com.example.android.movieapp.features.movie.api.FavouriteMoviesLocalInteractor;

import dagger.Binds;
import dagger.Module;

@Module
public interface DatabaseInteractorBindingModule {

    @Binds
    FavouriteMoviesLocalInteractor bindFavouriteMoviesLocalInteractor(FavouriteMoviesLocalInteractorImpl impl);

}
