package prac.retrofit.com.au.retroprac.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import prac.retrofit.com.au.retroprac.R;
import prac.retrofit.com.au.retroprac.response.MovieDataResponse;
import prac.retrofit.com.au.retroprac.response.MovieListDataResponse;
import prac.retrofit.com.au.retroprac.util.MovieUtils;

/**
 * This is the adapter class for setting up the View Holder and binding the view holder with the data.
 */

public class MovieListAdapter extends BaseRecyclerAdapter {

    private final Context context;
    private List<MovieListDataResponse> data;

    public MovieListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MovieEventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.movie_items_cell, parent, false);
        return new MovieEventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        MovieEventViewHolder holder = (MovieEventViewHolder) viewHolder;
        holder.itemView.setClickable(true);
        holder.title.setText(data.get(position).getTitle());
        holder.overview.setText(data.get(position).getOverview());
        String poster_img_url = MovieUtils.getPosterPath(data.get(position).getPosterPath());
        Glide.with(context).load(poster_img_url).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setMovieData(List<MovieListDataResponse> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public MovieListDataResponse getMovieItem(int position) {
        return data.get(position);
    }

    public class MovieEventViewHolder extends BaseRecyclerAdapter.ViewHolder {

        TextView title;
        TextView overview;
        ImageView imageView;

        public MovieEventViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.movie_image);
            title = itemView.findViewById(R.id.movie_title);
            overview = itemView.findViewById(R.id.movie_overview);
        }
    }

}
