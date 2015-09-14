package com.vinoth.dineout.Home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vinoth.dineout.POJO.Restaurant;
import com.vinoth.dineout.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by vinothkathiravan on 01/09/15.
 */
public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RstrntHolder>
{
    List<Restaurant> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;

    public RestaurantAdapter(Context context, List<Restaurant> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    public void delete(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public RstrntHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.restaurant_adapter, parent, false);
        RstrntHolder holder = new RstrntHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(RstrntHolder holder, int position) {
        Restaurant current = data.get(position);
        holder.rstntName.setText(current.getName());
        holder.rstntLocation.setText(current.getDisplayArea());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class RstrntHolder extends RecyclerView.ViewHolder {
        TextView rstntName;
        TextView rstntLocation;
        ImageView rstntImage;

        public RstrntHolder(View itemView) {
            super(itemView);
            rstntName = (TextView) itemView.findViewById(R.id.restaurantName);
            rstntLocation = (TextView) itemView.findViewById(R.id.restaurantLocation);
            rstntImage = (ImageView) itemView.findViewById(R.id.restaurantImage);
        }
    }
}