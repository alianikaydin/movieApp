package com.example.android.movieapp.features.movie.di;

import android.support.v4.app.FragmentManager;

import com.example.android.movieapp.R;
import com.example.android.movieapp.features.movie.MovieContract;
import com.example.android.movieapp.features.movie.MovieFragment;
import com.example.android.movieapp.features.movie.MovieNavigation;
import com.example.android.movieapp.features.movie.MoviePresenter;
import com.example.android.movieapp.features.movie.item.MovieNavigationItem;
import com.example.android.movieapp.features.movie.pages.FragmentType;
import com.example.android.movieapp.features.movie.pages.MovieDetailsFragmentFactory;
import com.example.android.movieapp.features.movie.pages.MovieTabsFragmentFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.annotations.NonNull;

@Module(includes = {MovieModule.Binder.class})
public class MovieModule {

    @Provides
    List<MovieNavigationItem> provideMovieNavigationItems(
            @NonNull MovieTabsFragmentFactory movieTabsFragmentFactory,
            @NonNull MovieDetailsFragmentFactory movieDetailsFragmentFactory
    ) {
        return Collections.unmodifiableList(Arrays.asList(
                new MovieNavigationItem(FragmentType.TABS, R.string.movie_tabs_page, movieTabsFragmentFactory),
                new MovieNavigationItem(FragmentType.DETAILS, R.string.movie_details_page, movieDetailsFragmentFactory)

        ));
    }

    @Provides
    FragmentManager provideFragmentManager(@NonNull MovieFragment fragment) {
        return fragment.getChildFragmentManager();
    }

    @Module
    public interface Binder {

        @Binds
        MovieContract.Presenter bindMoviePresenter(MoviePresenter impl);

        @Binds
        MovieContract.View bindMovieFragment(MovieFragment impl);

        @Binds
        MovieNavigation bindMovieNavigation(MovieFragment impl);
    }
}
