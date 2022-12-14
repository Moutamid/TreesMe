package com.moutamid.treesme.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moutamid.treesme.Model.ProductModel;
import com.moutamid.treesme.R;
import com.moutamid.treesme.User.ProductTestingDetails;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductTestingListAdaper extends RecyclerView.Adapter<ProductTestingListAdaper.ProductTestingViewHolder>{

    private Context mContext;
    private List<ProductModel> hairstylesList;

    public ProductTestingListAdaper(Context mContext, List<ProductModel> hairstylesList) {
        this.mContext = mContext;
        this.hairstylesList = hairstylesList;
    }

    @NonNull
    @Override
    public ProductTestingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.custom_layout,parent,false);
        return new ProductTestingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductTestingViewHolder holder, int position) {
        ProductModel model = hairstylesList.get(position);
        holder.name.setText(model.getName());
        Picasso.with(mContext)
                .load(model.getImage())
                .into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ProductTestingDetails.class);
                intent.putExtra("style",model.getName());
                intent.putExtra("image",model.getImage());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return hairstylesList.size();
    }

    public class ProductTestingViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView name;

        public ProductTestingViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.images);
            name = itemView.findViewById(R.id.name);
        }
    }
}
