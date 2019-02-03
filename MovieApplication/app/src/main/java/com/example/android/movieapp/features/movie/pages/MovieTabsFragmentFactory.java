package com.example.android.movieapp.features.movie.pages;

import android.support.annotation.NonNull;

import com.example.android.movieapp.core.base.BaseFragment;
import com.example.android.movieapp.core.base.FragmentFactory;
import com.example.android.movieapp.features.movie.MovieNavigation;
import com.example.android.movieapp.features.movie.tabs.MovieTabFragment;

import javax.inject.Inject;

public class MovieTabsFragmentFactory implements FragmentFactory {

    @NonNull
    private final MovieNavigation movieNavigation;

    @Inject
    MovieTabsFragmentFactory(@NonNull MovieNavigation movieNavigation) {
        this.movieNavigation = movieNavigation;
    }

    @NonNull
    @Override
    public BaseFragment getInstance() {
        MovieTabFragment movieTabFragment = MovieTabFragment.getInstance();
        movieTabFragment.setMovieNavigation(movieNavigation);
        return movieTabFragment;
    }
}
