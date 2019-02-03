package com.example.android.movieapp.features.movie.tabs.top_rated.di;

import android.view.View;

import com.example.android.movieapp.features.movie.api.MoviesAPIBinderModule;
import com.example.android.movieapp.features.movie.tabs.top_rated.MovieTopRatedFragment;

import org.simpleframework.xml.Root;

import dagger.Module;
import dagger.Provides;

@Module(includes = {
        MovieTopRatedBinderModule.class,
        MoviesAPIBinderModule.class
})
public class MovieTopRatedModule {
    @Provides
    @Root
    static View provideRootView(MovieTopRatedFragment fragment) {
        return fragment.getView();
    }

}
