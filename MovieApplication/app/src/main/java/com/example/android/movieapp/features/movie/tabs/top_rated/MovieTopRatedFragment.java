package com.example.android.movieapp.features.movie.tabs.top_rated;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.movieapp.R;
import com.example.android.movieapp.core.base.BaseFragment;
import com.example.android.movieapp.features.movie.MovieNavigation;
import com.example.android.movieapp.features.movie.pages.FragmentType;
import com.example.android.movieapp.features.movie.pojo.Result;
import com.jakewharton.rxbinding2.support.v7.widget.RxRecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static com.example.android.movieapp.features.movie.movie_details.MovieDetailsFragment.MOVIE_DETAILS;

public class MovieTopRatedFragment extends BaseFragment implements MovieTopRatedContract.View {
    private TopRatedListAdapter topRatedListAdapter;

    public static MovieTopRatedFragment getInstance() {
        return new MovieTopRatedFragment();
    }

    @Inject
    MovieTopRatedContract.Presenter presenter;

    @BindView(R.id.top_rated_movies)
    RecyclerView topRatedRecyclerView;

    private
    MovieNavigation movieNavigation;

    private static int page = 1;

    @Override
    protected int getContentViewID() {
        return R.layout.fragment_movie_top_rated;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        ButterKnife.bind(this, getView());
        AndroidSupportInjection.inject(this);
        presenter.bind();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getView().getContext(),
                4);
        topRatedRecyclerView.setLayoutManager(gridLayoutManager);
        topRatedListAdapter = new TopRatedListAdapter(getContext(),this);
        topRatedRecyclerView.setAdapter(topRatedListAdapter);
        presenter.getMovies(page);

        RxRecyclerView.scrollEvents(topRatedRecyclerView)
                .map(recyclerViewScrollEvent ->  page = page + 1)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer page) {
                        presenter.getMovies(page);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
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
        topRatedListAdapter.addAll(resultList);
        topRatedListAdapter.notifyDataSetChanged();
    }
}
