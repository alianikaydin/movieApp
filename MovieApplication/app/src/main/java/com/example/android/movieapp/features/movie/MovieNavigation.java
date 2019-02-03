package com.example.android.movieapp.features.movie;

import android.os.Bundle;

import com.example.android.movieapp.features.movie.pages.FragmentType;

public interface MovieNavigation {
    void changeFragmentFromOtherFragment(@FragmentType int showFragmentType);

    void changeFragmentFromOtherFragment(@FragmentType int showFragmentType, Bundle bundle);

    void goBack();
}
