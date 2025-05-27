package lab5;

import java.util.Scanner;

public class StudentView {
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("---------------------");
        System.out.println("1. Show all students");
        System.out.println("2. Filter by group");
        System.out.println("3. Filter by faculty");
        System.out.println("4. Filter by year");
        System.out.println("5. Save to text file");
        System.out.println("6. Load from text file");
        System.out.println("7. Save to binary file");
        System.out.println("8. Load from binary file");
        System.out.println("0. Exit");
        System.out.print("Choose: ");
    }

    public int getChoice() {
        return Integer.parseInt(scanner.nextLine());
    }

    public String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int getInt(String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(scanner.nextLine());
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }
}