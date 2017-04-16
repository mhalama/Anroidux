package cz.goedel.androidux;

import android.os.Bundle;

import cz.goedel.androidux.actions.Action;
import cz.goedel.androidux.reducers.Reducer;
import cz.goedel.androidux.states.AppState;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

public class Store {

    // TODO: nemusi byt behaviour subject
    private BehaviorSubject<Action> action$;

    private BehaviorSubject<AppState> stateSubject;
    private Observable<AppState> state$;

    public Store(AppState initialState, Reducer<AppState, Action> reducer) {
        this.action$ = BehaviorSubject.create();
        this.stateSubject = BehaviorSubject.createDefault(initialState);

        Observable<AppState> nextStates$ = this.action$
                .scan(initialState, (state, action) -> {
                    return reducer.reduce(state, action);
                });

        this.state$ = this.stateSubject.mergeWith(nextStates$);

        this.state$.subscribe(s -> {
            this.lastState = s;
        });
    }

    public void dispatch(Action a) {
        action$.onNext(a);
    }

    public Observable<AppState> getState() {
        return this.state$;
    }

    public Observable<Action> getAction() {
        return this.action$;
    }

    public Observable<Boolean> isLoading() {
        return getState()
                .map(s -> s.getLoader().isLoading())
                .distinctUntilChanged();
    }

    public Observable<Integer> getCounter() {
        return getState()
                .map(s -> s.getCounter().getNumber())
                .distinctUntilChanged();
    }

    private AppState lastState;

    public void onSaveInstanceState(Bundle outState) {
        lastState.onSaveInstanceState(outState);
    }

    public void onRestoreSavedInstance(Bundle savedInstanceState) {
        if (savedInstanceState != null)
            this.stateSubject.onNext(new AppState(savedInstanceState));
    }

}
