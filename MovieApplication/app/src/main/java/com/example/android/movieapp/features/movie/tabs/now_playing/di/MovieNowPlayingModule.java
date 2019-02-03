package com.example.android.movieapp.features.movie.tabs.now_playing.di;

import android.view.View;

import com.example.android.movieapp.features.movie.api.MoviesAPIBinderModule;
import com.example.android.movieapp.features.movie.tabs.now_playing.MovieNowPlayingFragment;

import org.simpleframework.xml.Root;

import dagger.Module;
import dagger.Provides;

@Module(includes = {
        MovieNowPlayingBinderModule.class,
        MoviesAPIBinderModule.class
})
public class MovieNowPlayingModule {
    @Provides
    @Root
    static View provideRootView(MovieNowPlayingFragment fragment) {
        return fragment.getView();
    }

}
