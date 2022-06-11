package com.mustafa.newsapp.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.mustafa.newsapp.models.ArticlesModel;

import java.util.List;

@Dao
public interface NewsDAO {

    @Insert
    public void insertNews(ArticlesModel articles);

    @Query("DELETE FROM favoraties_table WHERE id=:id")
    public void deleteNews(int id);

    @Query("SELECT * FROM favoraties_table")
    public LiveData<List<ArticlesModel>> getnews();
}
