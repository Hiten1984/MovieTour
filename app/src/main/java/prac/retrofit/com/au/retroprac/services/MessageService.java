package prac.retrofit.com.au.retroprac.services;

import io.reactivex.Observable;
import prac.retrofit.com.au.retroprac.response.MovieDataResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by hbahri on 20/2/18.
 */

public interface MessageService {

    @GET("3/discover/movie?language=en&sort_by=popularity.desc")
    Observable<MovieDataResponse> popularMovies(@Query("api_key") String apiKey);

}
