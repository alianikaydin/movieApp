package com.example.android.movieapp.features.movie.movie_details;

import com.example.android.movieapp.features.movie.pojo.Result;

public interface MovieDetailsContract {
    interface View{

        Result getMovie();

        void setButtonNameAddFav(boolean buttonNameAddFav);
    }
    interface Presenter{

        void bind();

        void addMovieToFavs(Result selectedMovie);
        void removeMovieFromFavs(Result selectedMovie);

        void isMovieLiked(int selectedMovieId);

    }
}
