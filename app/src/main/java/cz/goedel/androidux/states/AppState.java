package cz.goedel.androidux.states;

public class AppState {

    private boolean loading;
    private int number;

    public AppState(int i) {
        this.number = i;
    }

    public AppState(int i, boolean l) {
        this.number = i;
        this.loading = l;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isLoading() {
        return loading;
    }

    public void setLoading(boolean loading) {
        this.loading = loading;
    }

}
