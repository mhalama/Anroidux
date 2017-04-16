package cz.goedel.androidux;

import javax.inject.Singleton;

import cz.goedel.androidux.reducers.ReducerModule;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ReducerModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);

}
