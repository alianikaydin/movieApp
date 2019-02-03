package com.example.android.movieapp.features.movie.tabs.di;

import com.example.android.movieapp.features.movie.tabs.MovieTabFragment;
import com.example.android.movieapp.features.movie.tabs.favourites.di.MovieFavouritesContributeModule;
import com.example.android.movieapp.features.movie.tabs.now_playing.di.MovieNowPlayingContributeModule;
import com.example.android.movieapp.features.movie.tabs.top_rated.di.MovieTopRatedContributeModule;
import com.example.android.movieapp.features.movie.tabs.upcoming.di.MovieUpcomingContributeModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(includes = {
        MovieNowPlayingContributeModule.class,
        MovieTopRatedContributeModule.class,
        MovieUpcomingContributeModule.class,
        MovieFavouritesContributeModule.class
})
public interface MovieTabContributesModule {

    @ContributesAndroidInjector(modules = MovieTabModule.class)
    MovieTabFragment bindMovieTabFragment();
}
