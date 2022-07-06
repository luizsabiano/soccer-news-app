package br.com.soccernews.ui.favorites;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import br.com.soccernews.databinding.FragmentFavoritesBinding;
import br.com.soccernews.ui.adapters.NewsAdapter;

public class FavoritesFragment extends Fragment {

    private FavoritesViewModel favoritesViewModel;
    private FragmentFavoritesBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        favoritesViewModel =
                new ViewModelProvider(this).get(FavoritesViewModel.class);

        binding = FragmentFavoritesBinding.inflate(inflater, container, false);
        binding.rvNews.setLayoutManager(new LinearLayoutManager(getContext()));

        loadFavoriteNews();


        return binding.getRoot();
    }

    private void loadFavoriteNews() {
        this.favoritesViewModel.loadFavoriteNews().observe(getViewLifecycleOwner(), localNews -> {
            binding.rvNews.setLayoutManager(new LinearLayoutManager(getContext()));
            binding.rvNews.setAdapter(new NewsAdapter(localNews, updatedNews -> {
                this.favoritesViewModel.saveNews(updatedNews);
                loadFavoriteNews();
            }));
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}