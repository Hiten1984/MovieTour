package prac.retrofit.com.au.retroprac.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hbahri on 20/2/18.
 */

public class MovieDataResponse {

    @SerializedName("page")
    int page;

    @SerializedName("total_results")
    int totalResults;

    @SerializedName("total_pages")
    int totalPages;

    @SerializedName("results")
    List<MovieListDataResponse> movieResults;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<MovieListDataResponse> getMovieResults() {
        return movieResults;
    }

    public void setMovieResults(List<MovieListDataResponse> movieResults) {
        this.movieResults = movieResults;
    }
}
