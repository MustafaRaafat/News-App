package com.mustafa.newsapp.repository;


import com.mustafa.newsapp.db.NewsDAO;
import com.mustafa.newsapp.models.ArticlesModel;
import com.mustafa.newsapp.models.HeadLinesModel;
import com.mustafa.newsapp.network.NewsApiService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;

public class NewsRepository {

    private NewsApiService newsApiService;
    private NewsDAO newsDAO;

    //    my personal Api key
    private String ApiKey = "78fc13aac8984c62a02ea891dcd7ff6d";

    @Inject
    public NewsRepository(NewsApiService newsApiService, NewsDAO newsDAO) {
        this.newsApiService = newsApiService;
        this.newsDAO = newsDAO;
    }

    public Observable<HeadLinesModel> getHeadLines() {
        return newsApiService.getHeadLineService("eg", ApiKey);
    }

    public Completable insertNews(ArticlesModel articlesModel){
        return newsDAO.insertNews(articlesModel);
    }
    public void deletenews(int id){
        newsDAO.deleteNews(id);
    }
    public Observable<List<ArticlesModel>> getFavNews(){
        return newsDAO.getnews();
    }
}
