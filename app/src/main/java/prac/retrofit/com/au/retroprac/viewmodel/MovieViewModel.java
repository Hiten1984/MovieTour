package prac.retrofit.com.au.retroprac.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import prac.retrofit.com.au.retroprac.BuildConfig;
import prac.retrofit.com.au.retroprac.response.MovieDataResponse;
import prac.retrofit.com.au.retroprac.response.MovieListDataResponse;
import prac.retrofit.com.au.retroprac.services.MessageService;
import prac.retrofit.com.au.retroprac.services.ServiceBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by hbahri on 21/2/18.
 */

public class MovieViewModel extends AndroidViewModel {

    private final MessageService taskService;
    private MutableLiveData<List<MovieListDataResponse>> movieLiveData;
    private Call<MovieDataResponse> call;

    public MovieViewModel(@NonNull Application application) {
        super(application);
        taskService = ServiceBuilder.buildService(MessageService.class);
    }

    public MutableLiveData<List<MovieListDataResponse>> getPopularMovie() {
        final MutableLiveData<List<MovieListDataResponse>> data = new MutableLiveData<>();
        call = taskService.popularMovies(BuildConfig.API_KEY);
        call.enqueue(new Callback<MovieDataResponse>() {
            @Override
            public void onResponse(Call< MovieDataResponse > call, Response< MovieDataResponse > response){
                if (response != null && response.body() != null)
                    data.setValue(response.body().getMovieResults());
            }

            @Override
            public void onFailure (Call < MovieDataResponse > call, Throwable t) {

            }
        });
        return data;
    }

}
