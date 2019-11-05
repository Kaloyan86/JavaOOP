package WorkingWithAbstraction.Exercises.P5JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        Galaxy galaxy = new Galaxy(dimensions[0], dimensions[1]);
        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {

            int[] playerPositions = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();

            int[] evilPositions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Evil evil = new Evil(evilPositions[0], evilPositions[1], galaxy);


            while (evil.isInField()) {
                evil.move();
            }
            Player player = new Player(playerPositions[0], playerPositions[1], galaxy);

            while (player.isInField()) {
                sum += player.move();

            }

            command = scanner.nextLine();
        }

        System.out.println(sum);


    }
}
