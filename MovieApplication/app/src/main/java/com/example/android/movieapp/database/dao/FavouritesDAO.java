package com.example.android.movieapp.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.android.movieapp.database.entities.FavouriteEntity;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

import static com.example.android.movieapp.database.entities.FavouriteEntity.TABLE_NAME;

@Dao
public interface FavouritesDAO {

    @Query("SELECT * FROM " + TABLE_NAME)
    Flowable<List<FavouriteEntity>> getAllFavourites();

    @Query("SELECT * FROM " + TABLE_NAME + " WHERE id=:id")
    Single<FavouriteEntity> getMovie(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFavourite(FavouriteEntity favourite);

    @Query("DELETE FROM " + TABLE_NAME + " WHERE id=:id")
    void deleteFavourite(String id);


}
