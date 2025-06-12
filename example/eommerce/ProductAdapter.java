package com.example.eommerce;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product> {
    private Context context;
    private List<Product> products;

    public ProductAdapter(Context context, List<Product> products) {
        super(context, R.layout.one_raw, products);
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.one_raw, parent, false);
        }
        Product product = products.get(position);
        TextView nameTextView = convertView.findViewById(R.id.ItemName);
        TextView priceTextView = convertView.findViewById(R.id.ItemPerice);
        nameTextView.setText(product.getProductName());
        priceTextView.setText("Rs  "+product.getPrice().toString());
        ImageView productImageView = convertView.findViewById(R.id.productImage);
        Glide.with(this.getContext())
                .load(product.getImgUrl())
                .into(productImageView);

        return convertView;
    }
}
