package prac.retrofit.com.au.retroprac.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import prac.retrofit.com.au.retroprac.repository.MoviesRepository;

/**
 * Created by hbahri on 27/2/18.
 */

@Module
public class AppModule {

    @Singleton
    @Provides
    public MoviesRepository providesMoviesRepository() {
        return new MoviesRepository();
    }


}
