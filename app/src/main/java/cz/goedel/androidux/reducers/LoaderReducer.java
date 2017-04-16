package cz.goedel.androidux.reducers;

import cz.goedel.androidux.actions.Action;
import cz.goedel.androidux.actions.DataLoadedAction;
import cz.goedel.androidux.actions.LoadProcessAction;
import cz.goedel.androidux.states.LoaderState;

/**
 * Loader reducer focus only on Loader state - knows nothing
 * about other part of the application.
 */
public class LoaderReducer implements Reducer<LoaderState, Action> {

    public LoaderState reduce(LoaderState s, Action a) {
        if (a instanceof LoadProcessAction) {
            return new LoaderState(true);
        }

        if (a instanceof DataLoadedAction) {
            DataLoadedAction dla = (DataLoadedAction) a;

            return new LoaderState(false);
        }

        return s;
    }

}
