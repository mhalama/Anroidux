package cz.goedel.androidux.reducers;

public interface Reducer<State,Action> {
    State reduce(State s, Action a);
}
