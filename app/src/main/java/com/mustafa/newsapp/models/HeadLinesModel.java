package com.mustafa.newsapp.models;


import java.util.List;

public class HeadLinesModel {
    private String status;
    private int totalResults;
    private List<ArticlesModel> articles;

    public HeadLinesModel(String status, int totalResults, List<ArticlesModel> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<ArticlesModel> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticlesModel> articles) {
        this.articles = articles;
    }


}
