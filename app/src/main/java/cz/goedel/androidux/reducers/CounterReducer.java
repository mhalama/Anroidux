package cz.goedel.androidux.reducers;

import cz.goedel.androidux.actions.Action;
import cz.goedel.androidux.actions.DataLoadedAction;
import cz.goedel.androidux.actions.IncrementAction;
import cz.goedel.androidux.actions.LoadProcessAction;
import cz.goedel.androidux.states.CounterState;

/**
 * Counter reducer focus only on Counter state - knows nothing
 * about other part of the application.
 */
public class CounterReducer implements Reducer<CounterState, Action> {

    public CounterState reduce(CounterState s, Action a) {
        if (a instanceof IncrementAction) {
            return new CounterState(s.getNumber() + ((IncrementAction) a).getIncr());
        }

        if (a instanceof LoadProcessAction) {
            return new CounterState(s.getNumber());
        }

        if (a instanceof DataLoadedAction) {
            DataLoadedAction dla = (DataLoadedAction) a;

            return new CounterState(((DataLoadedAction) a).getNumber());
        }

        return s;
    }

}
