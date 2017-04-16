package cz.goedel.androidux;

import android.app.Application;

import javax.inject.Singleton;

import cz.goedel.androidux.effects.ComposedEffect;
import cz.goedel.androidux.effects.Effect;
import cz.goedel.androidux.effects.Effect10;
import cz.goedel.androidux.effects.LoadEffect;
import cz.goedel.androidux.reducers.AppReducer;
import cz.goedel.androidux.states.AppState;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    final Application app;

    public AppModule(Application app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Application provideApplicationInstanceID() {
        return app;
    }

//    @Provides
//    @Singleton
//    Reducer<AppState> provideReducer(Reducer<AppState> reducer) {
//        return new AppReducer();
//    }

    @Provides
    @Singleton
    LoadEffect provideLoadEffect(Store store) {
        return new LoadEffect(store);
    }

    @Provides
    @Singleton
    Effect10 provideEffect10(Store store) {
        return new Effect10(store);
    }

    @Provides
    @Singleton
    ComposedEffect provideEffectManager(LoadEffect loadEffect, Effect10 effect10) {
        return new ComposedEffect(new Effect[] {loadEffect, effect10});
    }

    @Provides
    @Singleton
    Store provideStore(AppReducer appReducer) {
        return new Store(new AppState(), appReducer);
    }
}
