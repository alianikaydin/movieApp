package com.example.android.movieapp.database.interactors;

import com.example.android.movieapp.database.entities.FavouriteEntity;
import com.example.android.movieapp.features.movie.pojo.Result;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Function;

class FavouriteEntityToResultMapper implements Function<List<FavouriteEntity>, List<Result>> {

    @Inject
    FavouriteEntityToResultMapper() {
    }

    @Override
    public List<Result> apply(List<FavouriteEntity> favouriteEntities) throws Exception {
        List<Result> resultList = new ArrayList<>();
        for (FavouriteEntity favouriteEntity : favouriteEntities){
            Result result = new Result();
            result.setOriginalTitle(favouriteEntity.getOriginalTitle());
            result.setAdult(favouriteEntity.getAdult());
            result.setBackdropPath(favouriteEntity.getBackdropPath());
            result.setId(favouriteEntity.getId());
            result.setOverview(favouriteEntity.getOverview());
            result.setPosterPath(favouriteEntity.getPosterPath());
            result.setTitle(favouriteEntity.getTitle());
            resultList.add(result);
        }
        return resultList;
    }}


