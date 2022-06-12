package com.mustafa.newsapp.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.mustafa.newsapp.models.ArticlesModel;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;

@Dao
public interface NewsDAO {

    @Insert
    Completable insertNews(ArticlesModel articles);

    @Query("DELETE FROM favoraties_table WHERE id=:id")
    public void deleteNews(int id);

    @Query("SELECT * FROM favoraties_table")
    public Observable<List<ArticlesModel>> getnews();
}
