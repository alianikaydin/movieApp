package com.example.android.movieapp.database.interactors;

import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;

import com.example.android.movieapp.database.dao.FavouritesDAO;
import com.example.android.movieapp.database.entities.FavouriteEntity;
import com.example.android.movieapp.features.movie.api.FavouriteMoviesLocalInteractor;
import com.example.android.movieapp.features.movie.pojo.Result;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.functions.Function;

@WorkerThread
class FavouriteMoviesLocalInteractorImpl implements FavouriteMoviesLocalInteractor {

    private final @NonNull
    FavouritesDAO favouritesDAO;
    private FavouriteEntityToResultMapper favouriteEntityResultMapper;

    @Inject
    FavouriteMoviesLocalInteractorImpl(@NonNull FavouritesDAO favouritesDAO,
                                       @NonNull FavouriteEntityToResultMapper favouriteEntityResultMapper) {
        this.favouritesDAO = favouritesDAO;
        this.favouriteEntityResultMapper = favouriteEntityResultMapper;
    }


    @NonNull
    @Override
    public Flowable<List<Result>> getAllFavourites() {
        return favouritesDAO.getAllFavourites().map(favouriteEntityResultMapper);
    }


    @NonNull
    @Override
    public Single<Result> getMovie(int id) {
        return favouritesDAO.getMovie(String.valueOf(id)).map(new Function<FavouriteEntity, Result>() {
            @Override
            public Result apply(FavouriteEntity favouriteEntity) throws Exception {
                Result result = new Result();
                result.setOriginalTitle(favouriteEntity.getOriginalTitle());
                result.setAdult(favouriteEntity.getAdult());
                result.setBackdropPath(favouriteEntity.getBackdropPath());
                result.setId(favouriteEntity.getId());
                result.setOverview(favouriteEntity.getOverview());
                result.setPosterPath(favouriteEntity.getPosterPath());
                result.setTitle(favouriteEntity.getTitle());
                return result;
            }
        });
    }

    @Override
    public void insertMovie(Result result) {
        FavouriteEntity favouriteEntity = new FavouriteEntity();
        favouriteEntity.setOriginalTitle(result.getOriginalTitle());
        favouriteEntity.setAdult(result.getAdult());
        favouriteEntity.setId(result.getId());
        favouriteEntity.setBackdropPath(result.getBackdropPath());
        favouriteEntity.setPosterPath(result.getPosterPath());
        favouriteEntity.setTitle(result.getTitle());
        favouriteEntity.setOverview(result.getOverview());
        favouritesDAO.insertFavourite(favouriteEntity);
    }

    @Override
    public void deleteMovie(Result result) {
        favouritesDAO.deleteFavourite(result.getId().toString());
    }


}
