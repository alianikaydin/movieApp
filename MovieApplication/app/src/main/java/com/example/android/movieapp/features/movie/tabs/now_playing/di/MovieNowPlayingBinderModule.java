package com.example.android.movieapp.features.movie.tabs.now_playing.di;

import com.example.android.movieapp.features.movie.tabs.now_playing.MovieNowPlayingContract;
import com.example.android.movieapp.features.movie.tabs.now_playing.MovieNowPlayingFragment;
import com.example.android.movieapp.features.movie.tabs.now_playing.MovieNowPlayingPresenter;

import dagger.Binds;
import dagger.Module;

@Module
public interface MovieNowPlayingBinderModule {
    @Binds
    MovieNowPlayingContract.View bindMovieNowPlayingView(MovieNowPlayingFragment impl);


    @Binds
    MovieNowPlayingContract.Presenter bindMoiveNowPlayingPresenter(MovieNowPlayingPresenter impl);
}
