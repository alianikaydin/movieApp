package com.example.android.movieapp.network.item;

import com.example.android.movieapp.features.movie.pojo.Response;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface RestRequestObjects {

    @GET("/3/movie/now_playing")
    Observable<Response> getNowPlayingMovies(@QueryMap Map<String, String> params);
    @GET("/3/movie/top_rated")
    Observable<Response> getTopRatedMovies(@QueryMap Map<String, String> params);
    @GET("/3/movie/upcoming")
    Observable<Response> getUpcomingMovies(@QueryMap Map<String, String> params);
}
