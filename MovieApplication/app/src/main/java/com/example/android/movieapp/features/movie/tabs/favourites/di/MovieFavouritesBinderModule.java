package com.example.android.movieapp.features.movie.tabs.favourites.di;

import com.example.android.movieapp.features.movie.tabs.favourites.MovieFavouritesContract;
import com.example.android.movieapp.features.movie.tabs.favourites.MovieFavouritesFragment;
import com.example.android.movieapp.features.movie.tabs.favourites.MovieFavouritesPresenter;

import dagger.Binds;
import dagger.Module;

@Module
public interface MovieFavouritesBinderModule {
    @Binds
    MovieFavouritesContract.View bindMovieFavouritesView(MovieFavouritesFragment impl);


    @Binds
    MovieFavouritesContract.Presenter bindMoiveFavouritesPresenter(MovieFavouritesPresenter impl);
}
