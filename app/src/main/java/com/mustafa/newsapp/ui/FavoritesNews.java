package com.mustafa.newsapp.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mustafa.newsapp.R;
import com.mustafa.newsapp.databinding.FragmentFavoritesNewsBinding;
import com.mustafa.newsapp.ui.adapters.FavoritesAdapter;
import com.mustafa.newsapp.viewModels.NewsViewModel;

public class FavoritesNews extends Fragment {
    private FragmentFavoritesNewsBinding binding;
    private FavoritesAdapter favoritesAdapter;
    private NewsViewModel newsViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFavoritesNewsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        favoritesAdapter=new FavoritesAdapter();
        binding.favoritesNewsRecycler.setAdapter(favoritesAdapter);

        newsViewModel=new ViewModelProvider(getActivity()).get(NewsViewModel.class);
        newsViewModel.getFavNews();
        newsViewModel.getFavorites().observe(getViewLifecycleOwner(),articlesModels -> {
            favoritesAdapter.setData(articlesModels);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}