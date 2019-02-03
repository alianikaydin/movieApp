package com.example.android.movieapp.features.movie.movie_details;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.android.movieapp.BuildConfig;
import com.example.android.movieapp.R;
import com.example.android.movieapp.core.base.BaseFragment;
import com.example.android.movieapp.features.movie.MovieNavigation;
import com.example.android.movieapp.features.movie.pojo.Result;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.AndroidSupportInjection;
import io.reactivex.annotations.NonNull;

public class MovieDetailsFragment extends BaseFragment implements MovieDetailsContract.View {
    public static final String MOVIE_DETAILS = "MOVIE_DETAILS";
    private Result selectedMovie;

    public static MovieDetailsFragment getInstance() {
        return new MovieDetailsFragment();
    }

    private @NonNull
    MovieNavigation movieNavigation;

    @Inject
    MovieDetailsContract.Presenter presenter;

    @BindView(R.id.movie_details_description_text_view)
    TextView descriptionTextView;

    @BindView(R.id.movie_details_fav_button)
    Button favButton;

    @BindView(R.id.movie_details_image_view)
    ImageView imageView;

    @BindView(R.id.movie_details_title_text_view)
    TextView title;


    @Override
    protected int getContentViewID() {
        return R.layout.fragment_movie_details;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        ButterKnife.bind(this, getView());
        AndroidSupportInjection.inject(this);
        handleBackButton();
        presenter.bind();
    }


    public void setMovieNavigation(MovieNavigation movieNavigation) {
        this.movieNavigation = movieNavigation;
    }

    @OnClick(R.id.movie_details_fav_button)
    public void onFavouriteButtonClicked(){
        if(favButton.getText().toString().equals(getString(R.string.add_fav)))
            presenter.addMovieToFavs(selectedMovie);
        else
            presenter.removeMovieFromFavs(selectedMovie);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getArguments() != null) {
            selectedMovie = (Result) getArguments().getSerializable(MOVIE_DETAILS);
            if (selectedMovie != null) {
                updateUI(selectedMovie);
            }
        }
    }

    private void updateUI(Result selectedMovie) {
        title.setText(selectedMovie.getTitle());
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.ic_launcher_foreground);
        requestOptions.error(R.drawable.ic_launcher_foreground);
        requestOptions.fitCenter();
        Glide.with(getContext())
                .asDrawable()
                .apply(requestOptions)
                .load(BuildConfig.IMAGE_URL_BASE + selectedMovie.getPosterPath())
                .into(imageView);
        descriptionTextView.setText(selectedMovie.getOverview());
        presenter.isMovieLiked(selectedMovie.getId());
    }

    private void handleBackButton() {
        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() != KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK) {
                        movieNavigation.goBack();
                        return true;
                    }
                    return false;
                }
                return false;
            }
        });
    }

    @Override
    public Result getMovie() {
        return selectedMovie;
    }

    @Override
    public void setButtonNameAddFav(boolean buttonNameAddFav) {
        if(buttonNameAddFav){
            favButton.setText(R.string.remove_fav);
        } else{
            favButton.setText(R.string.add_fav);
        }
    }
}
