package cz.goedel.androidux.reducers;

import cz.goedel.androidux.actions.Action;

public interface Reducer<AppState> {
    AppState reduce(AppState s, Action a);
}
