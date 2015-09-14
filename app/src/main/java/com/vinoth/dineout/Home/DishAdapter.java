package com.vinoth.dineout.Home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vinoth.dineout.POJO.Dish;
import com.vinoth.dineout.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by vinothkathiravan on 03/09/15.
 */
public class DishAdapter extends RecyclerView.Adapter<DishAdapter.DishHolder>
{
    List<Dish> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;

    public DishAdapter(Context context, List<Dish> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    public void delete(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public DishHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.dish_adapter, parent, false);
        DishHolder holder = new DishHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(DishHolder holder, int position) {
        Dish current = data.get(position);
        holder.dishName.setText(current.getName());
//        holder.dishPrice.setText("Rs "+current.getPrice());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class DishHolder extends RecyclerView.ViewHolder {
        TextView dishName;
        TextView dishPrice;
        ImageView dishImage;

        public DishHolder(View itemView) {
            super(itemView);
            dishName = (TextView) itemView.findViewById(R.id.dishNameText);
            dishPrice = (TextView) itemView.findViewById(R.id.dishPriceText);
            dishImage = (ImageView) itemView.findViewById(R.id.dishImage);
        }
    }
}