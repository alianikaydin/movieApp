package com.example.android.movieapp.features.movie.tabs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.android.movieapp.R;
import com.example.android.movieapp.core.base.BaseFragment;
import com.example.android.movieapp.features.movie.MovieNavigation;
import com.example.android.movieapp.features.movie.tabs.favourites.MovieFavouritesFragment;
import com.example.android.movieapp.features.movie.tabs.item.MovieTabNavigationItem;
import com.example.android.movieapp.features.movie.tabs.now_playing.MovieNowPlayingFragment;
import com.example.android.movieapp.features.movie.tabs.pages.FragmentType;
import com.example.android.movieapp.features.movie.tabs.pages.MovieTabFragmentProvider;
import com.example.android.movieapp.features.movie.tabs.top_rated.MovieTopRatedFragment;
import com.example.android.movieapp.features.movie.tabs.upcoming.MovieUpcomingFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

public class MovieTabFragment extends BaseFragment implements MovieTabContract.View {
    public static MovieTabFragment getInstance() {
        return new MovieTabFragment();
    }

    @Inject
    MovieTabContract.Presenter presenter;
    @Inject
    ViewPagerAdapter viewPagerAdapter;

    private @io.reactivex.annotations.NonNull
    MovieNavigation movieNavigation;

    private
    MovieTabFragmentProvider movieTabFragmentProvider;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @BindView(R.id.tabs)
    TabLayout tabLayout;


    public void setMovieNavigation(MovieNavigation movieNavigation) {
        this.movieNavigation = movieNavigation;
    }

    @Override
    protected int getContentViewID() {
        return R.layout.fragment_movie_tab;
    }
    @Override
    protected void initView(Bundle savedInstanceState) {
        ButterKnife.bind(this, getView());
        AndroidSupportInjection.inject(this);
        presenter.bind();
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        MovieNowPlayingFragment movieNowPlayingFragment = (MovieNowPlayingFragment) movieTabFragmentProvider.getFragmentForType(FragmentType.NOW_PLAYING);
        movieNowPlayingFragment.setMovieNavigation(movieNavigation);
        viewPagerAdapter.addFragment(movieNowPlayingFragment, getString(R.string.movie_now_playing));

        MovieTopRatedFragment movieTopRatedFragment = (MovieTopRatedFragment) movieTabFragmentProvider.getFragmentForType(FragmentType.TOP_RATED);
        movieTopRatedFragment.setMovieNavigation(movieNavigation);
        viewPagerAdapter.addFragment(movieTopRatedFragment, getString(R.string.movie_top_rated));

        MovieUpcomingFragment movieUpcomingFragment = (MovieUpcomingFragment) movieTabFragmentProvider.getFragmentForType(FragmentType.UPCOMING);
        movieUpcomingFragment.setMovieNavigation(movieNavigation);
        viewPagerAdapter.addFragment(movieUpcomingFragment, getString(R.string.movie_upcoming));
        viewPager.setAdapter(viewPagerAdapter);

        MovieFavouritesFragment movieFavouritesFragment = (MovieFavouritesFragment) movieTabFragmentProvider.getFragmentForType(FragmentType.FAVOURITES);
        movieFavouritesFragment.setMovieNavigation(movieNavigation);
        viewPagerAdapter.addFragment(movieFavouritesFragment, getString(R.string.favourites));
        viewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    public void createNavigationItems(@NonNull List<MovieTabNavigationItem> descriptors) {
        movieTabFragmentProvider = new MovieTabFragmentProvider(descriptors);
    }

}
