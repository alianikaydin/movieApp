package com.example.android.movieapp.features.movie.tabs.pages;

import android.support.annotation.NonNull;

import com.example.android.movieapp.core.base.BaseFragment;
import com.example.android.movieapp.core.base.FragmentFactory;
import com.example.android.movieapp.features.movie.tabs.top_rated.MovieTopRatedFragment;

import javax.inject.Inject;

public class MovieTopRatedFragmentFactory implements FragmentFactory {
    @Inject
    MovieTopRatedFragmentFactory() {
    }

    @NonNull
    @Override
    public BaseFragment getInstance() {
        return MovieTopRatedFragment.getInstance();
    }
}
