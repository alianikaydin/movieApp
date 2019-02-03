package com.example.android.movieapp.features.movie.tabs.item;

import android.support.annotation.StringRes;

import com.example.android.movieapp.core.base.FragmentFactory;
import com.example.android.movieapp.features.movie.tabs.pages.FragmentType;

import io.reactivex.annotations.NonNull;

public class MovieTabNavigationItem {
    public final @FragmentType
    int id;
    public final @StringRes
    int name;
    public final @NonNull
    FragmentFactory fragmentFactory;

    public MovieTabNavigationItem(@FragmentType int id, @StringRes int name, @NonNull FragmentFactory fragmentFactory) {
        this.id = id;
        this.name = name;
        this.fragmentFactory = fragmentFactory;
    }
}

