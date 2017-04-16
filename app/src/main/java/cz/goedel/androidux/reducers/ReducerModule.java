package cz.goedel.androidux.reducers;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ReducerModule {

    @Provides
    @Singleton
    CounterReducer provideCounterReducer() {
        return new CounterReducer();
    }

    @Provides
    @Singleton
    LoaderReducer provideLoaderReducer() {
        return new LoaderReducer();
    }

    @Provides
    @Singleton
    AppReducer provideAppReducer(CounterReducer cr, LoaderReducer lr) {
        return new AppReducer(cr, lr);
    }

}
