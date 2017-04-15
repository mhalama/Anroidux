package cz.goedel.androidux.actions;

import lombok.Data;

@Data
public class IncrementAction implements Action {

    private int incr;

    public IncrementAction(int incr) {
        this.incr = incr;
    }
}
