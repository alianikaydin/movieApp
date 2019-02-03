package com.example.android.movieapp.features.movie.tabs.favourites.di;

import android.view.View;

import com.example.android.movieapp.features.movie.api.MoviesAPIBinderModule;
import com.example.android.movieapp.features.movie.tabs.favourites.MovieFavouritesFragment;

import org.simpleframework.xml.Root;

import dagger.Module;
import dagger.Provides;

@Module(includes = {
        MovieFavouritesBinderModule.class,
        MoviesAPIBinderModule.class
})
public class MovieFavouritesModule {
    @Provides
    @Root
    static View provideRootView(MovieFavouritesFragment fragment) {
        return fragment.getView();
    }

}
