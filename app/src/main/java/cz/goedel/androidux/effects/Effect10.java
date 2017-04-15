package cz.goedel.androidux.effects;

import cz.goedel.androidux.Store;
import cz.goedel.androidux.actions.DataLoadedAction;
import cz.goedel.androidux.actions.LoadProcessAction;
import io.reactivex.disposables.Disposable;

public class Effect10 implements Effect {

    private Store store;

    private Disposable subscription;

    public Effect10(Store store) {
        this.store = store;
    }

    @Override
    public void register() {
        subscription = store.getState()
                .filter(s -> s.getNumber() == 10)
                .subscribe(s -> {
                    store.dispatch(new DataLoadedAction(222));
                });
    }

    @Override
    public void unregister() {
        if (!subscription.isDisposed()) {
            subscription.dispose();
        }
    }
}