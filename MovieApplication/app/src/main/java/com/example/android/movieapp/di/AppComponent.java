package com.example.android.movieapp.di;

import com.example.android.movieapp.database.di.DatabaseModule;
import com.example.android.movieapp.network.di.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {
        AppModule.class,
        ContributeModule.class,
        NetworkModule.class,
        DatabaseModule.class,
        AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class,
})
@Singleton
public interface AppComponent extends BaseAppComponent {

    @Component.Builder
    interface Builder extends BaseAppComponent.Builder<AppComponent, Builder> {

    }
}
