package com.example.android.movieapp.features.movie.pages;

import android.support.annotation.NonNull;

import com.example.android.movieapp.core.base.BaseFragment;
import com.example.android.movieapp.core.base.FragmentFactory;
import com.example.android.movieapp.features.movie.MovieNavigation;
import com.example.android.movieapp.features.movie.movie_details.MovieDetailsFragment;

import javax.inject.Inject;

public class MovieDetailsFragmentFactory implements FragmentFactory {

    @NonNull
    private final MovieNavigation movieNavigation;

    @Inject
    MovieDetailsFragmentFactory(@NonNull MovieNavigation movieNavigation) {
        this.movieNavigation = movieNavigation;
    }

    @NonNull
    @Override
    public BaseFragment getInstance() {
        MovieDetailsFragment movieDetailsFragment = MovieDetailsFragment.getInstance();
        movieDetailsFragment.setMovieNavigation(movieNavigation);
        return movieDetailsFragment;
    }
}