package com.example.android.movieapp.features.movie.tabs.now_playing;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
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

public class MovieNowPlayingFragment extends BaseFragment implements MovieNowPlayingContract.View {

    private NowPlayingListAdapter nowPlayingListAdapter;
    private Dialog mSplashDialog;

    public static MovieNowPlayingFragment getInstance() {
        return new MovieNowPlayingFragment();
    }

    @Inject
    MovieNowPlayingContract.Presenter presenter;

    @BindView(R.id.now_playing_movies)
    RecyclerView nowPlayingMoviesRecyclerView;

    private
    MovieNavigation movieNavigation;

    private static int page = 1;

    @Override
    protected int getContentViewID() {
        return R.layout.fragment_movie_now_playing;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        ButterKnife.bind(this, getView());
        AndroidSupportInjection.inject(this);
        presenter.bind();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getView().getContext(),
                4);
        nowPlayingMoviesRecyclerView.setLayoutManager(gridLayoutManager);
        nowPlayingListAdapter = new NowPlayingListAdapter(getContext(),this);
        nowPlayingMoviesRecyclerView.setAdapter(nowPlayingListAdapter);
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
        nowPlayingListAdapter.addAll(resultList);
        nowPlayingListAdapter.notifyDataSetChanged();
    }

    @Override
    public void showSplashScreen() {
        mSplashDialog = new Dialog(getContext(), R.style.splash_screen);
        mSplashDialog.setContentView(R.layout.splashscreen);
        mSplashDialog.setCancelable(false);
        mSplashDialog.show();

        // Set Runnable to remove splash screen just in case
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                removeSplashScreen();
            }
        }, 3000);
    }
    @Override
    public void removeSplashScreen() {
        if (mSplashDialog != null) {
            mSplashDialog.dismiss();
            mSplashDialog = null;
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        presenter.getMovies(page);

        RxRecyclerView.scrollEvents(nowPlayingMoviesRecyclerView)
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
}
