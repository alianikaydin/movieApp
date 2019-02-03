package com.example.android.movieapp.database.di;

import android.support.annotation.NonNull;

import com.example.android.movieapp.database.MovieDatabase;
import com.example.android.movieapp.database.dao.FavouritesDAO;
import com.example.android.movieapp.database.interactors.DatabaseInteractorBindingModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {DatabaseInteractorBindingModule.class})
public class DatabaseModule {

    @Provides
    @Singleton
    FavouritesDAO provideFavouritesEntityDAO(@NonNull MovieDatabase movieDatabase) {
        return movieDatabase.favouritesDAO();
    }
}
