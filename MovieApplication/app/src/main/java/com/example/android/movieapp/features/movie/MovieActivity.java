package com.example.android.movieapp.features.movie;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.android.movieapp.R;
import com.example.android.movieapp.core.base.BaseActivity;

public class MovieActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
    }
}
