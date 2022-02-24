package com.example.newsapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.Models.Model;
import com.example.newsapp.R;
import com.example.newsapp.webView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private Context context;
    ArrayList<Model> modelArrayList;

    public NewsAdapter(Context context, ArrayList<Model> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,parent,false);
        return new NewsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model model = modelArrayList.get(position);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, webView.class);
                intent.putExtra("url",model.getUrl());
                context.startActivity(intent);
            }
        });
        holder.txttime.setText(model.getPublishedAt());
        holder.txtauthor.setText(model.getAuthor());
        holder.txthead.setText(model.getTitle());
        holder.txtcontent.setText(model.getDescription());
        Picasso.get().load(model.getUrlToImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txthead,txtauthor,txttime,txtcontent;
        public ImageView imageView;
        public CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtauthor = itemView.findViewById(R.id.txtauthoritem);
            txttime = itemView.findViewById(R.id.txttimeitem);
            txtcontent = itemView.findViewById(R.id.txtcontentitem);
            txthead = itemView.findViewById(R.id.txtitemheading);
            imageView = itemView.findViewById(R.id.imgitem);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }
}
