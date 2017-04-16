package cz.goedel.androidux.reducers;

import cz.goedel.androidux.actions.Action;
import cz.goedel.androidux.states.AppState;

/**
 * Compose all application reducers.
 *
 * TODO: This should be generated somehow from annotations.
 */
public class AppReducer implements Reducer<AppState,Action> {

    CounterReducer counter;
    LoaderReducer loader;

    public AppReducer(CounterReducer cr, LoaderReducer lr) {
        this.counter = cr;
        this.loader = lr;
    }

    @Override
    public AppState reduce(AppState s, Action a) {
        AppState nas = new AppState();

        nas.setCounter(counter.reduce(s.getCounter(),a));
        nas.setLoader(loader.reduce(s.getLoader(),a));

        return nas;
    }
}
