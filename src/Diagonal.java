public interface Diagonal {
    boolean checkNorthwest(int startX, int startY, int moveToX, int moveToY);
    boolean checkNortheast(int startX, int startY, int moveToX, int moveToY);
    boolean checkSouthwest(int startX, int startY, int moveToX, int moveToY);
    boolean checkSoutheast(int startX, int startY, int moveToX, int moveToY);
}
