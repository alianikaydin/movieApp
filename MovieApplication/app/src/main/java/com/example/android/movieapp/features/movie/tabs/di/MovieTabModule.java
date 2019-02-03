package com.example.android.movieapp.features.movie.tabs.di;

import android.support.v4.app.FragmentManager;

import com.example.android.movieapp.R;
import com.example.android.movieapp.features.movie.tabs.MovieTabContract;
import com.example.android.movieapp.features.movie.tabs.MovieTabFragment;
import com.example.android.movieapp.features.movie.tabs.MovieTabPresenter;
import com.example.android.movieapp.features.movie.tabs.item.MovieTabNavigationItem;
import com.example.android.movieapp.features.movie.tabs.pages.FragmentType;
import com.example.android.movieapp.features.movie.tabs.pages.MovieFavouritesFragmentFactory;
import com.example.android.movieapp.features.movie.tabs.pages.MovieNowPlayingFragmentFactory;
import com.example.android.movieapp.features.movie.tabs.pages.MovieTopRatedFragmentFactory;
import com.example.android.movieapp.features.movie.tabs.pages.MovieUpcomingFragmentFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.annotations.NonNull;

@Module(includes = MovieTabModule.Binder.class)
public class MovieTabModule {
    @Provides
    List<MovieTabNavigationItem> provideMovieNavigationItems(
            @NonNull MovieUpcomingFragmentFactory upcomingFragmentFactory,
            @NonNull MovieTopRatedFragmentFactory topRatedFragmentFactory,
            @NonNull MovieNowPlayingFragmentFactory nowPlayingFragmentFactory,
            @NonNull MovieFavouritesFragmentFactory favouritesFragmentFactory
            ) {
        return Collections.unmodifiableList(Arrays.asList(
                new MovieTabNavigationItem(FragmentType.UPCOMING, R.string.movie_upcoming, upcomingFragmentFactory),
                new MovieTabNavigationItem(FragmentType.TOP_RATED, R.string.movie_top_rated, topRatedFragmentFactory),
                new MovieTabNavigationItem(FragmentType.NOW_PLAYING, R.string.movie_now_playing, nowPlayingFragmentFactory),
                new MovieTabNavigationItem(FragmentType.FAVOURITES,R.string.favourites,favouritesFragmentFactory)

        ));
    }

    @Provides
    FragmentManager provideTabsFragmentManager(@NonNull MovieTabFragment fragment) {
        return fragment.getChildFragmentManager();
    }

    @Module
    public interface Binder {

        @Binds
        MovieTabContract.Presenter bindMovieTabPresenter(MovieTabPresenter impl);

        @Binds
        MovieTabContract.View bindMovieTabFragment(MovieTabFragment impl);
    }
}
