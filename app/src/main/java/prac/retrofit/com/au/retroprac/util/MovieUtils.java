package prac.retrofit.com.au.retroprac.util;

import android.content.Context;

import com.google.gson.Gson;

import java.io.InputStreamReader;
import java.io.Reader;

import prac.retrofit.com.au.retroprac.response.MovieListDataResponse;

/**
 * Created by hbahri on 29/01/2018.
 */

public class MovieUtils {

    public static MovieListDataResponse fromMovieJson(Context context, String path) {
        Gson gson = new Gson();
        Reader reader = getReader(context, path);
        return gson.fromJson(reader, MovieListDataResponse.class);
    }

    private static Reader getReader(Context context, String path) {
        return new InputStreamReader(context.getResources().openRawResource(
                context.getResources().getIdentifier(path, "raw", context.getPackageName())
        ));
    }

    public static final String BASE_POSTER_PATH = "http://image.tmdb.org/t/p/w342";
    public static final String BASE_BACKDROP_PATH = "http://image.tmdb.org/t/p/w780";

    public static String getPosterPath(String posterPath) {
        return BASE_POSTER_PATH + posterPath;
    }

    public static String getBackdropPath(String backdropPath) {
        return BASE_BACKDROP_PATH + backdropPath;
    }

}
