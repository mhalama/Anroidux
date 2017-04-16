package cz.goedel.androidux.states;

import android.os.Bundle;

import lombok.Data;

/**
 * Representation of loader state and initial state.
 */
@Data
public class LoaderState {
    private boolean loading;

    public LoaderState() {
        this.loading = false;
    }

    public LoaderState(boolean loading) {
        setLoading(loading);
    }

    public LoaderState(Bundle state) {
        loading = state.getBoolean("LOADER_LOADING");
    }

    public void onSaveInstanceState(Bundle state) {
        state.putBoolean("LOADER_LOADING", loading);
    }
}