package com.mustafa.newsapp.repository;

import com.mustafa.newsapp.models.HeadLinesModel;
import com.mustafa.newsapp.network.NewsApiService;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class NewsRepository {

    private NewsApiService newsApiService;

//    my personal Api key
    private String ApiKey="78fc13aac8984c62a02ea891dcd7ff6d";

    @Inject
    public NewsRepository(NewsApiService newsApiService) {
        this.newsApiService = newsApiService;
    }

    public Observable<HeadLinesModel> getHeadLines(){
        return newsApiService.getHeadLineService("eg",ApiKey);
    }
}
