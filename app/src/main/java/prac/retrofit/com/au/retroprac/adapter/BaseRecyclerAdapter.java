package prac.retrofit.com.au.retroprac.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * A custom class to provide OnItemClickListener functionality without having to code it for each and every adapter
 */

public abstract class BaseRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected OnItemClickListener itemClickListener;

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public abstract class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (itemClickListener != null)
                itemClickListener.onItemClick(v, getAdapterPosition(), this);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position, ViewHolder viewHolder);
    }

}