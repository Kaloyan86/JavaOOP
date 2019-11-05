package WorkingWithAbstraction.Lab.P3StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();

        String line = scanner.nextLine();

        while (!line.equals("Exit")) {
            String[] input = line.split(" ");
            studentSystem.ParseCommand(input);
            line = scanner.nextLine();
        }
    }
}
