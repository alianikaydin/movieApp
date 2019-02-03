package com.example.android.movieapp.core.base;

import android.support.annotation.NonNull;


public interface FragmentFactory {
    @NonNull
    BaseFragment getInstance();
}
