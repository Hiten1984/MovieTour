package prac.retrofit.com.au.retroprac.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import prac.retrofit.com.au.retroprac.R;
import prac.retrofit.com.au.retroprac.response.MovieListDataResponse;

import static prac.retrofit.com.au.retroprac.util.MovieConstants.MOVIE_LIST_KEY;

/**
 * Created by hbahri on 29/01/2018.
 */

public class MovieListingActivity extends AppCompatActivity {

    @BindView(R.id.details_title)
    TextView title;
    @BindView(R.id.details_released)
    TextView releasedDate;
    @BindView(R.id.details_overview_summary)
    TextView overviewSummary;
    @BindView(R.id.details_ratings)
    TextView ratings;

    MovieListDataResponse data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list_details);
        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey(MOVIE_LIST_KEY))
            data = extras.getParcelable(MOVIE_LIST_KEY);

        if (data != null) {
            releasedDate.setText(data.getReleaseDate());
            title.setText(data.getTitle());
            overviewSummary.setText(data.getOverview());
            ratings.setText("Ratings: " + data.getVoteAverage() + "/10");
        }
    }
}
