package com.example.newsapp.Models;

import com.example.newsapp.Models.Model;

import java.util.ArrayList;

public class mainNews {
    private String status;
    private String totalResults;
    private ArrayList<Model> articles;

    public mainNews(String status, String totalResults, ArrayList<Model> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public mainNews() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<Model> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Model> articles) {
        this.articles = articles;
    }
}
