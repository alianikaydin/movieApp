package com.example.android.movieapp.network.interactors;

import com.example.android.movieapp.features.movie.api.MoviesNetworkInteractor;
import com.example.android.movieapp.features.movie.pojo.Response;
import com.example.android.movieapp.network.item.RestRequestObjects;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Retrofit;

class MoviesNetworkInteractorImpl implements MoviesNetworkInteractor {

    private RestRequestObjects restRequestObjects;


    private static String API_KEY = "45f014399c5aae5b7b114657a5169a20";

    @Inject
    MoviesNetworkInteractorImpl(Retrofit retrofit) {
        restRequestObjects = retrofit.create(RestRequestObjects.class);
    }

    @Override
    public Observable<Response> getNowPlayingMovies(int page) {
        Map<String, String> params = new HashMap<>();
        params.put("api_key",API_KEY);
        params.put("page", String.valueOf(page));
        return restRequestObjects.getNowPlayingMovies(params);
    }

    @Override
    public Observable<Response> getTopRatedMovies(int page) {
        Map<String, String> params = new HashMap<>();
        params.put("api_key",API_KEY);
        params.put("page", String.valueOf(page));
        return restRequestObjects.getTopRatedMovies(params);
    }

    @Override
    public Observable<Response> getUpcomingMovies(int page) {
        Map<String, String> params = new HashMap<>();
        params.put("api_key",API_KEY);
        params.put("page", String.valueOf(page));
        return restRequestObjects.getUpcomingMovies(params);
    }
}
