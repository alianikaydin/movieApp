package com.example.android.movieapp.features.movie;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.android.movieapp.R;
import com.example.android.movieapp.core.base.BaseFragment;
import com.example.android.movieapp.features.movie.item.MovieNavigationItem;
import com.example.android.movieapp.features.movie.pages.FragmentType;
import com.example.android.movieapp.features.movie.pages.MovieFragmentProvider;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

public class MovieFragment extends BaseFragment implements MovieContract.View, MovieNavigation {

    private MovieFragmentProvider movieFragmentProvider;

    @Inject
    MovieContract.Presenter presenter;

    @Override
    protected int getContentViewID() {
        return R.layout.fragment_movie;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        ButterKnife.bind(this, getView());
        AndroidSupportInjection.inject(this);
        presenter.bind();
    }


    @Override
    public void changeFragment(int lastItem, Bundle bundle) {
        replaceFragment(lastItem, bundle);
    }

    @Override
    public void changeFragment(int lastItem) {
        replaceFragment(lastItem, new Bundle());
    }

    @Override
    public void createNavigationItems(@NonNull List<MovieNavigationItem> descriptors) {
        movieFragmentProvider = new MovieFragmentProvider(descriptors);
    }

    private void replaceFragment(@FragmentType int newFragmentId, Bundle bundle) {
        final FragmentManager fragmentManager = getChildFragmentManager();
        String tag = String.valueOf(newFragmentId);
        Fragment fragment;
        fragment = fragmentManager.findFragmentByTag(tag);
        fragment = (fragment == null) ? movieFragmentProvider.getFragmentForType(newFragmentId): fragment;
        fragment.setArguments(bundle);
        fragmentManager.beginTransaction()
                .replace(R.id.movie_fragment_content, fragment, tag)
                .addToBackStack(tag)
                .commit();
    }

    @Override
    public void changeFragmentFromOtherFragment(int showFragmentType) {
        changeFragment(showFragmentType, new Bundle());
    }

    @Override
    public void changeFragmentFromOtherFragment(int showFragmentType, Bundle bundle) {
        changeFragment(showFragmentType, bundle);
    }

    @Override
    public void goBack() {
        final FragmentManager fragmentManager = getChildFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager .popBackStack();
        }
    }
}
