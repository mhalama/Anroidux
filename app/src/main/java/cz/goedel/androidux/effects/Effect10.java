package cz.goedel.androidux.effects;

import cz.goedel.androidux.Store;
import cz.goedel.androidux.actions.DataLoadedAction;
import io.reactivex.disposables.Disposable;

/**
 * Sample effect which dispatches background load process action when state of
 * application changes in a way that number % 10 == 0.
 */
public class Effect10 implements Effect {

    private Store store;

    private Disposable subscription;

    public Effect10(Store store) {
        this.store = store;
    }

    @Override
    public void register() {
        subscription = store.getCounter()
                .filter(s -> s % 10 == 0)
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