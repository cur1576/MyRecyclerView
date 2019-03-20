package com.example.myrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_layout,null);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.itemName.setText(MainActivity.personArrayList.get(i).getName());
        viewHolder.itemCity.setText(MainActivity.personArrayList.get(i).getCity());
    }

    @Override
    public int getItemCount() {
        return MainActivity.personArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemName, itemCity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.tv_user_name);
            itemCity = itemView.findViewById(R.id.tv_user_city);
        }
    }
}
