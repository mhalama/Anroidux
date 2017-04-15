package cz.goedel.androidux.reducers;

import cz.goedel.androidux.actions.DataLoadedAction;
import cz.goedel.androidux.actions.LoadProcessAction;
import cz.goedel.androidux.states.AppState;
import cz.goedel.androidux.actions.Action;
import cz.goedel.androidux.actions.IncrementAction;

public class AppReducer implements Reducer<AppState> {

    @Override
    public AppState reduce(AppState s, Action a) {
        if (a instanceof IncrementAction) {
            return new AppState(s.getNumber() + ((IncrementAction) a).getIncr());
        }

        if (a instanceof LoadProcessAction) {
            return new AppState(s.getNumber(), true);
        }

        if (a instanceof DataLoadedAction) {
            DataLoadedAction dla = (DataLoadedAction) a;

            return new AppState(((DataLoadedAction) a).getNumber(), false);
        }

        return s;
    }
}
