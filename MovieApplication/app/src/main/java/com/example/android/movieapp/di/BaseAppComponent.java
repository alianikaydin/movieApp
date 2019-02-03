package com.example.android.movieapp.di;


import android.app.Application;

import com.example.android.movieapp.MovieApplication;
import com.example.android.movieapp.database.MovieDatabase;

import dagger.BindsInstance;

public interface BaseAppComponent {

    void inject(MovieApplication application);


    /**
     * @param <B> actual Builder class
     * @param <C> actual Component class
     */
    interface Builder<C extends BaseAppComponent, B extends Builder<C, B>> {

        @BindsInstance
        B application(Application application);

        @BindsInstance
        B database(MovieDatabase roomDatabase);

        C build();
    }
}
