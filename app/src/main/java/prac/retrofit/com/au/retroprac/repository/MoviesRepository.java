package prac.retrofit.com.au.retroprac.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import prac.retrofit.com.au.retroprac.BuildConfig;
import prac.retrofit.com.au.retroprac.response.MovieDataResponse;
import prac.retrofit.com.au.retroprac.response.MovieListDataResponse;
import prac.retrofit.com.au.retroprac.services.MessageService;

/**
 * Created by hbahri on 27/2/18.
 */

@Singleton
public class MoviesRepository {

    @Inject
    MessageService messageService;

    /**
     *  Message service is now passed into Movie repository as a dependency and is provided by the module
     *  rather than initiating it here directly so as to reduce the load on this class.
     * @param messageService
     */
    @Inject
    public MoviesRepository(MessageService messageService) {
        this.messageService = messageService;
    }

    public LiveData<List<MovieListDataResponse>> getPopularMovies() {
        final MutableLiveData<List<MovieListDataResponse>> data = new MutableLiveData<>();
        messageService.popularMovies(BuildConfig.API_KEY)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieDataResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MovieDataResponse movieDataResponse) {
                        if (movieDataResponse != null)
                            data.setValue(movieDataResponse.getMovieResults());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return data;
    }

    public LiveData<List<MovieListDataResponse>> getHighestRatedMoviesMovies() {
        final MutableLiveData<List<MovieListDataResponse>> data = new MutableLiveData<>();
        messageService.highestRatedMovies(BuildConfig.API_KEY)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieDataResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MovieDataResponse movieDataResponse) {
                        if (movieDataResponse != null)
                            data.setValue(movieDataResponse.getMovieResults());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return data;
    }

}
