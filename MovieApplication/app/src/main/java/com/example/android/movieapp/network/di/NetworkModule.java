package com.example.android.movieapp.network.di;

import com.example.android.movieapp.BuildConfig;
import com.example.android.movieapp.core.scheduler.JobExecutor;
import com.example.android.movieapp.network.interactors.NetworkInteractorBindingModule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes ={
        NetworkInteractorBindingModule.class})

public class NetworkModule {


    @Singleton
    @Provides
    Retrofit getMoviesBaseRetrofit() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        if(BuildConfig.DEBUG) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .callbackExecutor(new JobExecutor())
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .callbackExecutor(new JobExecutor())
                .build();
    }



}
