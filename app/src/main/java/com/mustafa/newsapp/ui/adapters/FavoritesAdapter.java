package com.mustafa.newsapp.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mustafa.newsapp.R;
import com.mustafa.newsapp.models.ArticlesModel;

import java.util.ArrayList;
import java.util.List;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.FavoritesHolder> {
    List<ArticlesModel> data = new ArrayList<>();

    public void setData(List<ArticlesModel> data) {
        this.data = data;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public FavoritesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FavoritesHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.favorites_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (data == null) {
            return 0;
        }
        return data.size();
    }

    public class FavoritesHolder extends RecyclerView.ViewHolder {
        public FavoritesHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
