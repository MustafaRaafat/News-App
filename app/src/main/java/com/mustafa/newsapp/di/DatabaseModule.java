package com.mustafa.newsapp.di;

import android.app.Application;

import androidx.room.Room;

import com.mustafa.newsapp.db.NewsDAO;
import com.mustafa.newsapp.db.NewsDB;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DatabaseModule {

    @Provides
    @Singleton
    public static NewsDB provideDB(Application application) {
        return Room.databaseBuilder(application, NewsDB.class, "fav_DB")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

    @Provides
    @Singleton
    public static NewsDAO provideDao(NewsDB newsDB) {
        return newsDB.newsDAO();
    }
}
