public class Player {
    private String username;
    private int winsAgainstEasyDifficulty;
    private int winsAgainstHardDifficulty;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getWinsAgainstEasyDifficulty() {
        return winsAgainstEasyDifficulty;
    }

    public void setWinsAgainstEasyDifficulty(int winsAgainstEasyDifficulty) {
        this.winsAgainstEasyDifficulty = winsAgainstEasyDifficulty;
    }

    public int getWinsAgainstHardDifficulty() {
        return winsAgainstHardDifficulty;
    }

    public void setWinsAgainstHardDifficulty(int winsAgainstHardDifficulty) {
        this.winsAgainstHardDifficulty = winsAgainstHardDifficulty;
    }
    public Player()
    {
        this.username = "default";
        this.winsAgainstEasyDifficulty = 0;
        this.winsAgainstHardDifficulty = 0;
    }
    public Player(String username, int winsAgainstEasyDifficulty, int winsAgainstHardDifficulty) {
        this.username = username;
        this.winsAgainstEasyDifficulty = winsAgainstEasyDifficulty;
        this.winsAgainstHardDifficulty = winsAgainstHardDifficulty;
    }
}
