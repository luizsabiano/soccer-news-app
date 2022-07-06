package br.com.soccernews.ui.favorites;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import br.com.soccernews.data.SoccerNewsRepository;
import br.com.soccernews.domain.News;

public class FavoritesViewModel extends ViewModel {


    public FavoritesViewModel() {

    }

    public LiveData<List<News>> loadFavoriteNews() {
        final LiveData<List<News>> news;
        return SoccerNewsRepository.getInstance().getLocalDb().newsDao().loadFavoriteNews();
    }

    public void saveNews(News news) {
        AsyncTask.execute(() -> SoccerNewsRepository.getInstance().getLocalDb().newsDao().save(news));
    }

}