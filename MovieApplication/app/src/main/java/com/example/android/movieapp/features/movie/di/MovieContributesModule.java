package com.example.android.movieapp.features.movie.di;

import com.example.android.movieapp.features.movie.MovieFragment;
import com.example.android.movieapp.features.movie.movie_details.di.MovieDetailsContributeModule;
import com.example.android.movieapp.features.movie.tabs.di.MovieTabContributesModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(includes = {
        MovieTabContributesModule.class,
        MovieDetailsContributeModule.class
})
public interface MovieContributesModule {

    @ContributesAndroidInjector(modules = MovieModule.class)
    MovieFragment bindMovieFragment();

}
