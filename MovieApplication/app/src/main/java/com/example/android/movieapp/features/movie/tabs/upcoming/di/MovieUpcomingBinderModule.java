package com.example.android.movieapp.features.movie.tabs.upcoming.di;

import com.example.android.movieapp.features.movie.tabs.upcoming.MovieUpcomingFragment;
import com.example.android.movieapp.features.movie.tabs.upcoming.MovieUpcomingPresenter;
import com.example.android.movieapp.features.movie.tabs.upcoming.MoviewUpcomingContract;

import dagger.Binds;
import dagger.Module;

@Module
public interface MovieUpcomingBinderModule
{
    @Binds
    MoviewUpcomingContract.View bindMovieUpcomingView(MovieUpcomingFragment impl);


    @Binds
    MoviewUpcomingContract.Presenter bindMovieUpcomingPresenter(MovieUpcomingPresenter impl);
}
