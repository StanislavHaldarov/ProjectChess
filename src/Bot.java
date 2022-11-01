public class Bot {
    private String name;
    private boolean isRandom;
    
    public Bot(){
        this.name = "Bot";
        this.isRandom = true;
    }

    public Bot(String name, boolean isRandom) {
        this.name = name;
        this.isRandom = isRandom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRandom() {
        return isRandom;
    }

    public void setRandom(boolean random) {
        isRandom = random;
    }

}
