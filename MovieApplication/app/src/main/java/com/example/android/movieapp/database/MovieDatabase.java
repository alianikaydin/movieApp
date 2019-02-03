package com.example.android.movieapp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.android.movieapp.database.dao.FavouritesDAO;
import com.example.android.movieapp.database.entities.FavouriteEntity;

@Database(entities = {FavouriteEntity.class}, version = 1)
public abstract class MovieDatabase extends RoomDatabase {
    private static volatile MovieDatabase INSTANCE;

    public abstract FavouritesDAO favouritesDAO();


    public static MovieDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (MovieDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MovieDatabase.class, "Sample9f.db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
