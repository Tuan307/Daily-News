package com.example.newsapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newsapp.Adapter.NewsAdapter;
import com.example.newsapp.ApiUlititi;
import com.example.newsapp.Models.Model;
import com.example.newsapp.Models.mainNews;
import com.example.newsapp.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SportFragment extends Fragment {


    private String api = "46cc9d3f8a6d4497a19985680c6912a4";
    private ArrayList<Model> modelArrayList;
    private NewsAdapter newsAdapter;
    private String country = "us";
    private RecyclerView recyclerView;
    private String category = "sports";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sport, container, false);
        recyclerView  = view.findViewById(R.id.recysport);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        modelArrayList = new ArrayList<>();
        newsAdapter = new NewsAdapter(getContext(),modelArrayList);
        recyclerView.setAdapter(newsAdapter);

        loadNews();
        return view;
    }

    private void loadNews() {
        ApiUlititi.getApiInterface().getCategoryNews(country,category,100,api).enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                if(response.isSuccessful())
                {
                    modelArrayList.addAll(response.body().getArticles());
                    newsAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {

            }
        });
    }
}