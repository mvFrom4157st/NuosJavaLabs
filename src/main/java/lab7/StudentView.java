package lab7;

import java.util.Scanner;

public class StudentView {
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("---------------------");
        System.out.println("1. List of students of a specified faculty");
        System.out.println("2. List of students born after a specified year");
        System.out.println("3. List of a study group");
        System.out.println("4. List of students sorted by descending date of birth (and name)");
        System.out.println("5. Check if a student is in the list and display their birth month and day");
        System.out.println("6. List of groups (only фiз.особа) (With streams)");
        System.out.println("7. List of groups (only фiз.особа) (Without streams)");
        System.out.println("8. For each faculty: list of students (sorted by name)");
        System.out.println("9. For each birth year: count of students");
        System.out.println("10. Search student by name and remove (With streams)");
        System.out.println("11. Search student by name and remove (Without streams)");
        System.out.println("12. Show all students");
        System.out.println("13. Save to a text file");
        System.out.println("14. Load from a text file");
        System.out.println("15. Save to a binary file");
        System.out.println("16. Load from a binary file");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
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