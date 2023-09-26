import java.util.Scanner;

public class UserInterface {
    public static void startGame() {
        Scanner scanner = new Scanner(System.in);
        Adventure adventure = new Adventure();

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("exit")) {
                break;
            } else if (input.equals("help")) {
                System.out.println("Commands: go [direction], exit, help, look");
            } else if (input.equals("look")) {
                adventure.lookAround();
            } else if (input.startsWith("go")) {
                String[] parts = input.split(" ");
                if (parts.length == 2) {
                    String direction = parts[1];
                    if (isValidDirection(direction)) {
                        adventure.move(direction);
                    } else {
                        System.out.println("Invalid direction!");
                    }
                } else {
                    System.out.println("Invalid command! Use 'go [direction]'.");
                }
            } else {
                System.out.println("Invalid command! Type 'help' for instructions.");
            }
        }
    }

    private static boolean isValidDirection(String direction) {
        String[] VALID_DIRECTIONS = {"north", "east", "south", "west", "n", "e", "s", "w"};

        for (String validDirection : VALID_DIRECTIONS) {
            if (validDirection.equals(direction)) {
                return true;
            }
        }
        return false;
    }
}