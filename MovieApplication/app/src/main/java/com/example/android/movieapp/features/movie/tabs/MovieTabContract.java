package com.example.android.movieapp.features.movie.tabs;

import android.support.annotation.NonNull;

import com.example.android.movieapp.features.movie.tabs.item.MovieTabNavigationItem;

import java.util.List;

public interface MovieTabContract {
    interface View {
        void createNavigationItems(@NonNull List<MovieTabNavigationItem> descriptors);

    }
    interface Presenter{
        void bind();

    }
}
