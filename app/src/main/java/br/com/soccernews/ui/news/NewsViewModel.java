package br.com.soccernews.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import br.com.soccernews.domain.News;

public class NewsViewModel extends ViewModel {

    private MutableLiveData<List<News>> news;

    public NewsViewModel() {
        this.news = new MutableLiveData<>();

        // TODO remover mock de notícias
        List<News> news =  new ArrayList<>();
        news.add(new News("Ferroviária Tem Desfalque Importante", "Lorazepam, sold under the brand name Ativan among others, is a benzodiazepine medication. It is used to treat anxiety..."));
        news.add(new News("Ferrinha Joga no Sábado", "Lorazepam, sold under the brand name Ativan among others, is a benzodiazepine medication. It is used to treat anxiety..."));
        news.add(new News("Copa do Mundo Feminina Está Iniciando", "Lorazepam, sold under the brand name Ativan among others, is a benzodiazepine medication. It is used to treat anxiety..."));

        this.news.setValue(news);

    }

    public LiveData<List<News>> getNews() {
        return this.news;
    }
}