import java.util.Scanner;

public class Menu {
    public static void menu() {
        System.out.println("CHESS \nby Stanislav Haldarov and Belis Aliosmanova");
        Player player = new Player();
        player.setUsername(enterName());
    }

    public static String enterName() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter name: ");
        return scan.nextLine();
    }
    public static void chooseDifficulty(){
        Scanner scan = new Scanner(System.in);
        System.out.println("The options are -> easy and difficult");
        System.out.println("Enter 1 for easy game or 2 for difficult game");
        int choice = scan.nextInt();

    }
}
