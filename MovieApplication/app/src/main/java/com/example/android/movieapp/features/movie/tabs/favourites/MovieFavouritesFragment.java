package com.example.android.movieapp.features.movie.tabs.favourites;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.movieapp.R;
import com.example.android.movieapp.core.base.BaseFragment;
import com.example.android.movieapp.features.movie.MovieNavigation;
import com.example.android.movieapp.features.movie.pages.FragmentType;
import com.example.android.movieapp.features.movie.pojo.Result;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

import static com.example.android.movieapp.features.movie.movie_details.MovieDetailsFragment.MOVIE_DETAILS;

public class MovieFavouritesFragment extends BaseFragment implements MovieFavouritesContract.View {

    private FavouritesListAdapter favouritesAdapter;

    public static MovieFavouritesFragment getInstance() {
        return new MovieFavouritesFragment();
    }

    @Inject
    MovieFavouritesContract.Presenter presenter;

    @BindView(R.id.favourites_movies)
    RecyclerView favouritesMoviesRecyclerView;

    private
    MovieNavigation movieNavigation;

    @Override
    protected int getContentViewID() {
        return R.layout.fragment_movie_favourites;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        ButterKnife.bind(this, getView());
        AndroidSupportInjection.inject(this);
        presenter.bind();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getView().getContext(),
                4);
        favouritesMoviesRecyclerView.setLayoutManager(gridLayoutManager);
        favouritesAdapter = new FavouritesListAdapter(getContext(),this);
        favouritesMoviesRecyclerView.setAdapter(favouritesAdapter);
    }

    public void setMovieNavigation(@NonNull MovieNavigation movieNavigation) {
        this.movieNavigation = movieNavigation;
    }

    @Override
    public void onMovieItemSelected(Result result) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(MOVIE_DETAILS,result);
        movieNavigation.changeFragmentFromOtherFragment(FragmentType.DETAILS, bundle);
    }

    @Override
    public void setMovieData(List<Result> resultList) {
        favouritesAdapter.addAll(resultList);
        favouritesAdapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.getMovies();
    }
}