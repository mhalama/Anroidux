package cz.goedel.androidux.actions;

import lombok.Data;

@Data
public class DataLoadedAction implements Action {

    private int number;

    public DataLoadedAction(int number) {
        this.number = number;
    }
}
