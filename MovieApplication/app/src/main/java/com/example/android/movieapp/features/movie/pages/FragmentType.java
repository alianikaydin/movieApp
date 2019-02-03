package com.example.android.movieapp.features.movie.pages;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

@IntDef({
        FragmentType.TABS,
        FragmentType.DETAILS
})
@Retention(SOURCE)
public @interface FragmentType {

    int TABS = 0;
    int DETAILS = 1;


}
