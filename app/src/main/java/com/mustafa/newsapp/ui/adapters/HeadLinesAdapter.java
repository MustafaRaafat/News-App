package com.mustafa.newsapp.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mustafa.newsapp.R;
import com.mustafa.newsapp.models.ArticlesModel;

import java.util.ArrayList;
import java.util.List;

public class HeadLinesAdapter extends RecyclerView.Adapter<HeadLinesAdapter.HeadLineHolder> {
    private List<ArticlesModel> data = new ArrayList<>();

    public void setData(List<ArticlesModel> data) {
        this.data = data;
        notifyDataSetChanged();

    }

    public ArticlesModel getArticle(int position){
        return data.get(position);
    }

    @NonNull
    @Override
    public HeadLineHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HeadLineHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.headlines_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HeadLineHolder holder, int position) {

        holder.title.setText(data.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        if (data == null) {
            return 0;
        }
        return data.size();
    }

    public class HeadLineHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image;
        public HeadLineHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.news_title);
            image=itemView.findViewById(R.id.news_image);
        }
    }
}
