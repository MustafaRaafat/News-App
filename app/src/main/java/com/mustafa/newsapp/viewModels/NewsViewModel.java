package com.mustafa.newsapp.viewModels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mustafa.newsapp.models.ArticlesModel;
import com.mustafa.newsapp.models.HeadLinesModel;
import com.mustafa.newsapp.repository.NewsRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

@HiltViewModel
public class NewsViewModel extends ViewModel {
    private static final String TAG = "new view Model: ";

    private NewsRepository repository;
    private MutableLiveData<HeadLinesModel> headLines = new MutableLiveData<>();
    private MutableLiveData<List<ArticlesModel>> favorites = new MutableLiveData<>();

    @Inject
    public NewsViewModel(NewsRepository repository) {
        this.repository = repository;
    }

    public MutableLiveData<HeadLinesModel> getHeadLines() {
        return headLines;
    }

    public MutableLiveData<List<ArticlesModel>> getFavorites() {
        return favorites;
    }

    public void getHeadLinesFromRepository() {
        repository.getHeadLines()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(headLinesModel -> {
                    headLines.setValue(headLinesModel);
                }, throwable -> {
                    Log.d(TAG, throwable.toString());
                });
    }

    public void insertNewsFav(ArticlesModel articlesModel) {
        repository.insertNews(articlesModel)
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    public void deleteFromFav(int id) {
        repository.deletenews(id);
    }

    public void getFavNews() {
        repository.getFavNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(articlesModels -> {
                    favorites.setValue(articlesModels);
                },throwable -> {
                    Log.d(TAG,throwable.toString());
                });
    }
}
