package com.example.android.movieapp.features.movie.tabs;

import com.example.android.movieapp.features.movie.tabs.item.MovieTabNavigationItem;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

public class MovieTabPresenter implements MovieTabContract.Presenter {

    private final @NonNull
    MovieTabContract.View view;
    private final @NonNull
    List<MovieTabNavigationItem> movieTabNavigationItems;

    @Inject
    public MovieTabPresenter(@NonNull MovieTabContract.View view,
                                      @NonNull List<MovieTabNavigationItem> movieTabNavigationItems) {
        this.view = view;
        this.movieTabNavigationItems = movieTabNavigationItems;
    }

    @Override
    public void bind() {
        view.createNavigationItems(movieTabNavigationItems);
    }

}
