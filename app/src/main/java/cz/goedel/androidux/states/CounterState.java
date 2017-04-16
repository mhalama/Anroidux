package cz.goedel.androidux.states;

import android.os.Bundle;

import lombok.Data;

/**
 * Representation of counter state and initial state.
 */
@Data
public class CounterState {

    private int number;

    public CounterState() {
        this.number = 0; // initial state
    }

    public CounterState(int number) {
        setNumber(number);
    }

    public CounterState(Bundle state) {
        number = state.getInt("COUNTER_NUMBER");
    }

    public void onSaveInstanceState(Bundle state) {
        state.putInt("COUNTER_NUMBER", number);
    }
}