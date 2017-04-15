package cz.goedel.androidux.effects;

import cz.goedel.androidux.Store;
import cz.goedel.androidux.actions.DataLoadedAction;
import cz.goedel.androidux.actions.LoadProcessAction;
import io.reactivex.disposables.Disposable;

public class LoadEffect implements Effect {

    private Store store;

    private Disposable subscription;

    public LoadEffect(Store store) {
        this.store = store;
    }

    @Override
    public void register() {
        subscription = store.getAction()
                .filter(a -> (a instanceof LoadProcessAction))
                .subscribe(a -> {
                    store.dispatch(new DataLoadedAction(111));
                });
    }

    @Override
    public void unregister() {
        if (!subscription.isDisposed()) {
            subscription.dispose();
        }
    }
}