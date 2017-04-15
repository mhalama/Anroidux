package cz.goedel.androidux;

import android.util.Log;

import cz.goedel.androidux.actions.Action;
import cz.goedel.androidux.reducers.Reducer;
import cz.goedel.androidux.states.AppState;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

public class Store {

    // TODO: nemusi byt behaviour subject
    private BehaviorSubject<Action> action$;

    private Observable<AppState> state$;

    public Store(AppState initialState, Reducer<AppState> reducer) {
        this.action$ = BehaviorSubject.create();
        this.state$ = BehaviorSubject.createDefault(initialState);

        Observable<AppState> nextStates$ = this.action$
                .scan(initialState, (state, action) -> {
                    return reducer.reduce(state,action);
                });

        this.state$ = this.state$.mergeWith(nextStates$);
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
                .map(s -> s.isLoading())
                .distinctUntilChanged();

    }

}
