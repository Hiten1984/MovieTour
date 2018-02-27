package prac.retrofit.com.au.retroprac.services;

import io.reactivex.Observable;
import prac.retrofit.com.au.retroprac.response.MovieDataResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by hbahri on 20/2/18.
 */

public interface MessageService {

    @GET("3/discover/movie?language=en&sort_by=popularity.desc")
    Observable<MovieDataResponse> popularMovies(@Query("api_key") String apiKey);

    @GET("3/discover/movie?vote_count.gte=500&language=en&sort_by=vote_average.desc")
    Observable<MovieDataResponse> highestRatedMovies(@Query("api_key") String apiKey);

}
