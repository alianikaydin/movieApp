package com.example.android.movieapp.features.movie.tabs.pages;

import android.support.annotation.NonNull;

import com.example.android.movieapp.core.base.BaseFragment;
import com.example.android.movieapp.core.base.FragmentFactory;
import com.example.android.movieapp.features.movie.tabs.favourites.MovieFavouritesFragment;

import javax.inject.Inject;

public class MovieFavouritesFragmentFactory implements FragmentFactory {
    @Inject
    MovieFavouritesFragmentFactory() {
    }

    @NonNull
    @Override
    public BaseFragment getInstance() {
        return MovieFavouritesFragment.getInstance();
    }
}
