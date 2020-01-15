package com.example.restaurantapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.restaurantapp.Model.RestaurantInfo;
import com.example.restaurantapp.R;

public class RestaurantInfoAdapter extends RecyclerView.Adapter<RestaurantInfoAdapter.RecyclerViewHolder> {

    private final RestaurantInfo mRestaurantInfo;
    public RestaurantInfoAdapter(RestaurantInfo restaurantInfo) {
        this.mRestaurantInfo = restaurantInfo;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_info,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.mResaurantName.setText(mRestaurantInfo.getRestaurants().get(position).getRestaurant().getName());
        holder.mRatingbar.setRating(Float.parseFloat(mRestaurantInfo.getRestaurants().get(position).getRestaurant().getUserRating().getAggregateRating()));
        holder.mTotalVotes.setText("Total Votes:".concat(mRestaurantInfo.getRestaurants().get(position).getRestaurant().getUserRating().getVotes()));
        Glide.with(holder.itemView.getContext()).load(mRestaurantInfo.getRestaurants().get(position).getRestaurant().getFeaturedImage()).error(R.drawable.ic_launcher_background).diskCacheStrategy(DiskCacheStrategy.DATA).into(holder.mBannerImageView);
    }

    @Override
    public int getItemCount() {
        return mRestaurantInfo.getRestaurants().size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder{
        final TextView mResaurantName;
        final TextView mTotalVotes;
        final RatingBar mRatingbar;
        final ImageView mBannerImageView;
        RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            mResaurantName = itemView.findViewById(R.id.restaurantName);
            mRatingbar = itemView.findViewById(R.id.appCompatRatingBar);
            mBannerImageView = itemView.findViewById(R.id.restaurantImage);
            mTotalVotes = itemView.findViewById(R.id.totalVotes);

        }
    }
}
