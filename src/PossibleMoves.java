public class PossibleMoves {
    private String startCords;
    private String moveCords;
    private int value;

    public String getStartCords() {
        return startCords;
    }

    public void setStartCords(String startCords) {
        this.startCords = startCords;
    }

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

    public PossibleMoves(String startCords, String moveCords, int value) {
        this.startCords = startCords;
        this.moveCords = moveCords;
        this.value = value;
    }
}
