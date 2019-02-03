package com.example.android.movieapp.features.movie;

import com.example.android.movieapp.features.movie.item.MovieNavigationItem;
import com.example.android.movieapp.features.movie.pages.FragmentType;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

public class MoviePresenter implements MovieContract.Presenter {

    @Inject
    MovieContract.View view;
    private final @NonNull
    List<MovieNavigationItem> movieNavigationItems;

    @Inject
    public MoviePresenter(@NonNull MovieContract.View view,
                                   @NonNull List<MovieNavigationItem> movieNavigationItems) {
        this.view = view;
        this.movieNavigationItems = movieNavigationItems;

    }

    @Override
    public void bind() {
        view.createNavigationItems(movieNavigationItems);
        view.changeFragment(FragmentType.TABS);
    }


    @Override
    public void navigateFragment(int fragmentType) {
        this.view.changeFragment(fragmentType);
    }
}
