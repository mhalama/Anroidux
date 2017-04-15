package cz.goedel.androidux;

import android.app.Application;
import android.content.Context;

public class App extends Application {

    private AppComponent appComponent;

    public static AppComponent getComponent(Context context) {
        return ((App) context.getApplicationContext()).appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
}
