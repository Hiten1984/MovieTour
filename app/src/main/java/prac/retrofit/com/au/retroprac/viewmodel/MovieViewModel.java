package prac.retrofit.com.au.retroprac.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import prac.retrofit.com.au.retroprac.MoviesApplication;
import prac.retrofit.com.au.retroprac.repository.MoviesRepository;
import prac.retrofit.com.au.retroprac.response.MovieListDataResponse;

/**
 * Created by hbahri on 21/2/18.
 */

public class MovieViewModel extends AndroidViewModel {

    @Inject
    MoviesRepository moviesRepository;

    public MovieViewModel(@NonNull Application application) {
        super(application);
        MoviesApplication.getApplication().getAppComponent().inject(this);
    }


    public LiveData<List<MovieListDataResponse>> getPopularMovies() {
        return moviesRepository.getPopularMovies();
    }

    public LiveData<List<MovieListDataResponse>> getHighestRatedMovies() {
        return moviesRepository.getHighestRatedMoviesMovies();
    }

}
