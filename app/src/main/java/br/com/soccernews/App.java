package br.com.soccernews;

import android.app.Application;

// Mundanças Futuras
// Injeção de dependências com Dagger ou Hilt

public class App extends Application {

    private static App instance;

    public static App getInstance() { return instance;}

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }


}
