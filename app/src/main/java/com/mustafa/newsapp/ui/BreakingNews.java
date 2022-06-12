package com.mustafa.newsapp.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mustafa.newsapp.databinding.FragmentBreakingNewsBinding;
import com.mustafa.newsapp.models.ArticlesModel;
import com.mustafa.newsapp.ui.adapters.HeadLinesAdapter;
import com.mustafa.newsapp.viewModels.NewsViewModel;


public class BreakingNews extends Fragment {
    private HeadLinesAdapter headLinesAdapter;
    private NewsViewModel newsViewModel;
    private FragmentBreakingNewsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBreakingNewsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        headLinesAdapter = new HeadLinesAdapter();
        binding.breakingNewsRecycler.setAdapter(headLinesAdapter);
        setupSwipe();

        newsViewModel = new ViewModelProvider(getActivity()).get(NewsViewModel.class);
        newsViewModel.getHeadLinesFromRepository();
        newsViewModel.getHeadLines().observe(getViewLifecycleOwner(), headLinesModel -> {
            headLinesAdapter.setData(headLinesModel.getArticles());
        });

        binding.goToFavorites.setOnClickListener(view1 -> {
            NavDirections n = BreakingNewsDirections.actionBreakingNewsToFavoritesNews();
            Navigation.findNavController(view1).navigate(n);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;

    }


//    function to send data to fav
    private void setupSwipe(){
        ItemTouchHelper.SimpleCallback simpleCallback=new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int sw=viewHolder.getAdapterPosition();
                ArticlesModel dd=headLinesAdapter.getArticle(sw);
                newsViewModel.insertNewsFav(dd);


            }
        };
        ItemTouchHelper itemTouchHelper=new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(binding.breakingNewsRecycler);
    }
}