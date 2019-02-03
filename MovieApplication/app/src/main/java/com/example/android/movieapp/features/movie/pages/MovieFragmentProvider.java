package com.example.android.movieapp.features.movie.pages;

import android.support.annotation.NonNull;
import android.util.SparseArray;

import com.example.android.movieapp.core.base.BaseFragment;
import com.example.android.movieapp.features.movie.item.MovieNavigationItem;

import java.util.List;

public class MovieFragmentProvider {
    private final @NonNull
    SparseArray<MovieNavigationItem> descriptorMappings;

    public MovieFragmentProvider(@NonNull List<MovieNavigationItem> movieNavigationItemSparseArray) {
        this.descriptorMappings = new SparseArray<>();
        for (MovieNavigationItem movieNavigationItem : movieNavigationItemSparseArray) {
            descriptorMappings.append(movieNavigationItem.id, movieNavigationItem);
        }
    }
    public @NonNull
    BaseFragment getFragmentForType(@FragmentType int newFragmentId) {
        return descriptorMappings.get(newFragmentId).fragmentFactory.getInstance();
    }

}
