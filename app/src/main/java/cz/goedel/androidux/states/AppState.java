package cz.goedel.androidux.states;

import lombok.Data;

/**
 * Compose application state.
 *
 * TODO: This should be generated somehow from annotations.
 */

@Data
public class AppState {

    private CounterState counter;
    private LoaderState loader;

    public AppState() {
        this.counter = new CounterState();
        this.loader = new LoaderState();
    }

}
