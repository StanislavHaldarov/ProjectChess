public class PossibleMoves {
    private String moveCords;
    private int value;

    public String getMoveCords() {
        return moveCords;
    }

    public void setMoveCords(String moveCords) {
        this.moveCords = moveCords;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public PossibleMoves(String moveCords, int value) {
        this.moveCords = moveCords;
        this.value = value;
    }
}
