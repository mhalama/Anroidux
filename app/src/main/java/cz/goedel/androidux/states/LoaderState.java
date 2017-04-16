package cz.goedel.androidux.states;

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
}
