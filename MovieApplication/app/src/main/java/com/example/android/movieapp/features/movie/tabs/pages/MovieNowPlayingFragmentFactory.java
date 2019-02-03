package com.example.android.movieapp.features.movie.tabs.pages;

import android.support.annotation.NonNull;

import com.example.android.movieapp.core.base.BaseFragment;
import com.example.android.movieapp.core.base.FragmentFactory;
import com.example.android.movieapp.features.movie.tabs.now_playing.MovieNowPlayingFragment;

import javax.inject.Inject;

public class MovieNowPlayingFragmentFactory implements FragmentFactory {
    @Inject
    MovieNowPlayingFragmentFactory() {
    }

    @NonNull
    @Override
    public BaseFragment getInstance() {
        return MovieNowPlayingFragment.getInstance();
    }
}
