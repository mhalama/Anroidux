package cz.goedel.androidux.states;

import android.os.Bundle;

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

    public AppState(Bundle savedInstanceState) {
        this.counter = new CounterState(savedInstanceState);
        this.loader = new LoaderState(savedInstanceState);
    }

    public void onSaveInstanceState(Bundle outState) {
        this.counter.onSaveInstanceState(outState);
        this.loader.onSaveInstanceState(outState);
    }

}
