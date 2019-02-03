package com.example.android.movieapp.features.movie;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.example.android.movieapp.features.movie.item.MovieNavigationItem;
import com.example.android.movieapp.features.movie.pages.FragmentType;

import java.util.List;

public class MovieContract {
    public interface View{
        void changeFragment(@FragmentType int lastItem, Bundle bundle);

        void changeFragment(@FragmentType int lastItem);

        void createNavigationItems(@NonNull List<MovieNavigationItem> descriptors);

    }
    public interface Presenter {

        void bind();

        void navigateFragment(@FragmentType int fragmentType);

    }
}
