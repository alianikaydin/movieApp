package com.example.android.movieapp.features.movie.tabs.pages;

import android.support.annotation.NonNull;
import android.util.SparseArray;

import com.example.android.movieapp.core.base.BaseFragment;
import com.example.android.movieapp.features.movie.tabs.item.MovieTabNavigationItem;

import java.util.List;

public class MovieTabFragmentProvider {
    private final @NonNull
    SparseArray<MovieTabNavigationItem> descriptorMappings;

    public MovieTabFragmentProvider(@NonNull List<MovieTabNavigationItem> movieTabNavigationItems) {
        descriptorMappings = new SparseArray<>();
        for (MovieTabNavigationItem movieTabNavigationItem : movieTabNavigationItems) {
            descriptorMappings.append(movieTabNavigationItem.id, movieTabNavigationItem);
        }
    }

    public @NonNull
    BaseFragment getFragmentForType(@FragmentType int newFragmentId) {
        return descriptorMappings.get(newFragmentId).fragmentFactory.getInstance();
    }

}
