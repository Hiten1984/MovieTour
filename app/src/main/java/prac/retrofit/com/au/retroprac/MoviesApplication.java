package prac.retrofit.com.au.retroprac;

import android.app.Application;

import prac.retrofit.com.au.retroprac.di.AppComponent;
import prac.retrofit.com.au.retroprac.di.AppModule;
import prac.retrofit.com.au.retroprac.di.DaggerAppComponent;

/**
 * Created by hbahri on 27/2/18.
 */

public class MoviesApplication extends Application {

    private static MoviesApplication application;
    private AppComponent appComponent;

    public static MoviesApplication getApplication() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule())
                .build();
        appComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
