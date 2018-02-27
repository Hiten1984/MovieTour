package prac.retrofit.com.au.retroprac.di;

import javax.inject.Singleton;

import dagger.Component;
import prac.retrofit.com.au.retroprac.MoviesApplication;
import prac.retrofit.com.au.retroprac.viewmodel.MovieViewModel;


/**
 * Created by hbahri on 27/2/18.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(MovieViewModel viewModel);

    void inject(MoviesApplication moviesApplication);
}
