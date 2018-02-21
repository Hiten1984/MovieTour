package prac.retrofit.com.au.retroprac;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import prac.retrofit.com.au.retroprac.adapter.BaseRecyclerAdapter;
import prac.retrofit.com.au.retroprac.adapter.MovieListAdapter;
import prac.retrofit.com.au.retroprac.response.MovieDataResponse;
import prac.retrofit.com.au.retroprac.response.MovieListDataResponse;
import prac.retrofit.com.au.retroprac.view.MovieListingActivity;
import prac.retrofit.com.au.retroprac.viewmodel.MovieViewModel;
import retrofit2.Call;

import static prac.retrofit.com.au.retroprac.util.MovieConstants.MOVIE_LIST_KEY;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.movie_list_recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private Call<MovieDataResponse> call;
    private MovieListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.toolbar_title));

        MovieViewModel movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        movieViewModel.getPopularMovie().observe(this, new Observer<List<MovieListDataResponse>>() {
            @Override
            public void onChanged(@Nullable List<MovieListDataResponse> movieListDataResponses) {
                initAdapter(movieListDataResponses);
            }
        });

    }

    private void initAdapter(List<MovieListDataResponse> movieListData) {
        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManagaer);
        adapter = new MovieListAdapter(getApplicationContext());
        recyclerView.setAdapter(adapter);
        adapter.setMovieData(movieListData);
        adapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view1, int position, BaseRecyclerAdapter.ViewHolder viewHolder) {
                MovieListDataResponse item = adapter.getMovieItem(position);
                callMovieList(item);
            }
        });

    }

    private void callMovieList(MovieListDataResponse item) {
        Intent intent = new Intent(this, MovieListingActivity.class);
        intent.putExtra(MOVIE_LIST_KEY, item);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
