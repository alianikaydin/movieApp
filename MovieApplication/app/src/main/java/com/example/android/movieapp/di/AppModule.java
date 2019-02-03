package com.example.android.movieapp.di;

import com.example.android.movieapp.core.scheduler.JobScheduler;
import com.example.android.movieapp.core.scheduler.SchedulerIO;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {AppModule.Binder.class})
class AppModule {

    @Provides
    @Singleton
    static JobScheduler provideJobScheduler() {
        return new SchedulerIO();
    }

    @Module
    interface Binder {

    }
}
