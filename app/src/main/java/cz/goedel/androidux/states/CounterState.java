package cz.goedel.androidux.states;

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

}
