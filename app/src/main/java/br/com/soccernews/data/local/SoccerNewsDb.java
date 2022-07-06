package br.com.soccernews.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import br.com.soccernews.domain.News;

@Database(entities = {News.class}, version = 1)
public abstract class SoccerNewsDb extends RoomDatabase {
    public abstract NewsDao newsDao();
}
