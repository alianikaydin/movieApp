package com.example.android.movieapp.features.movie.tabs.upcoming.di;


import android.view.View;

import com.example.android.movieapp.features.movie.api.MoviesAPIBinderModule;
import com.example.android.movieapp.features.movie.tabs.upcoming.MovieUpcomingFragment;

import org.simpleframework.xml.Root;

import dagger.Module;
import dagger.Provides;

@Module(includes = {
        MovieUpcomingBinderModule.class,
        MoviesAPIBinderModule.class
})
public class MovieUpcomingModule {
    @Provides
    @Root
    static View provideRootView(MovieUpcomingFragment fragment) {
        return fragment.getView();
    }

}

