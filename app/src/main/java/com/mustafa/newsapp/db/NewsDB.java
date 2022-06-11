package com.mustafa.newsapp.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.mustafa.newsapp.models.ArticlesModel;

@Database(entities = ArticlesModel.class,version = 1)
public abstract class NewsDB extends RoomDatabase {
    public abstract NewsDAO newsDAO();
}
