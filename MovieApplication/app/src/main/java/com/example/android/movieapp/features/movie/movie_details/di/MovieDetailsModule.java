package com.example.android.movieapp.features.movie.movie_details.di;

import android.view.View;

import com.example.android.movieapp.features.movie.api.MoviesAPIBinderModule;
import com.example.android.movieapp.features.movie.movie_details.MovieDetailsFragment;

import org.simpleframework.xml.Root;

import dagger.Module;
import dagger.Provides;

@Module(includes = {
        MovieDetailsBinderModule.class,
        MoviesAPIBinderModule.class})
public class MovieDetailsModule {
    @Provides
    @Root
    static View provideRootView(MovieDetailsFragment fragment) {
        return fragment.getView();
    }
}
