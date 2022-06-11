package com.mustafa.newsapp.network;

import com.mustafa.newsapp.models.HeadLinesModel;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApiService {

    @GET("top-headlines")
    Observable<HeadLinesModel> getHeadLineService(@Query("country") String country,
                                                  @Query("apiKey") String apiKey);
}
