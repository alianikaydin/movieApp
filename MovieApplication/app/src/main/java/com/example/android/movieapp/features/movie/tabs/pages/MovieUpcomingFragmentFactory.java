package com.example.android.movieapp.features.movie.tabs.pages;

import android.support.annotation.NonNull;

import com.example.android.movieapp.core.base.BaseFragment;
import com.example.android.movieapp.core.base.FragmentFactory;
import com.example.android.movieapp.features.movie.tabs.upcoming.MovieUpcomingFragment;

import javax.inject.Inject;

public class MovieUpcomingFragmentFactory implements FragmentFactory {
    @Inject
    MovieUpcomingFragmentFactory() {
    }

    @NonNull
    @Override
    public BaseFragment getInstance() {
        return MovieUpcomingFragment.getInstance();
    }
}
