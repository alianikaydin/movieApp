package com.example.android.movieapp.features.movie.tabs.pages;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

@IntDef({
        FragmentType.TOP_RATED,
        FragmentType.NOW_PLAYING,
        FragmentType.UPCOMING,
        FragmentType.FAVOURITES
})
@Retention(SOURCE)
public @interface FragmentType {

    int TOP_RATED = 0;
    int NOW_PLAYING = 1;
    int UPCOMING = 2;
    int FAVOURITES = 3;

}

