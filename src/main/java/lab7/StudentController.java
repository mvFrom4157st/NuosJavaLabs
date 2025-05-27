package lab7;

import java.util.List;

public class StudentController {
    private List<Student> students;
    private final StudentService service;
    private final StudentView view;
    private final StudentRepository textRepo;
    private final StudentRepository binRepo;

    public StudentController(List<Student> students) {
        this.students = students;
        this.service = new StudentService();
        this.view = new StudentView();
        this.textRepo = new StudentRepositoryTextImpl();
        this.binRepo = new StudentRepositoryBinaryImpl();
    }

    public void run() {
        while (true) {
            view.showMenu();
            int choice = view.getChoice();
            switch (choice) {
                case 1 -> {
                    String faculty = view.getString("Enter faculty: ");
                    service.printStudentsByFaculty(students, faculty);
                }
                case 2 -> {
                    int year = view.getInt("Enter year: ");
                    service.printStudentsBornAfterYear(students, year);
                }
                case 3 -> {
                    String group = view.getString("Enter group: ");
                    service.printStudentsByGroup(students, group);
                }
                case 4 -> service.printSortedByBirthDateAndName(students);
                case 5 -> {
                    String name = view.getString("Enter full name: ");
                    service.checkAndPrintStudentBirthday(students, name);
                }
                case 6 -> service.printGroupsOnlyFizOsobaWithStreams(students);
                case 7 -> service.printGroupsOnlyFizOsobaWithoutStreams(students);
                case 8 -> service.printFacultyToStudentsMap(students);
                case 9 -> service.printBirthYearToCountMap(students);
                case 10 -> {
                    String name = view.getString("Enter full name to remove: ");
                    boolean removed = service.removeStudentByNameWithStreams(students, name);
                    view.showMessage(removed ? "Removed." : "Not found.");
                }
                case 11 -> {
                    String name = view.getString("Enter full name to remove: ");
                    boolean removed = service.removeStudentByNameWithoutStreams(students, name);
                    view.showMessage(removed ? "Removed." : "Not found.");
                }
                case 12 -> service.printAllStudents(students);
                case 13 -> {
                    String fileName = view.getString("Enter file name: ");
                    textRepo.outputList(students, fileName);
                    view.showMessage("Saved to text file.");
                }
                case 14 -> {
                    String fileName = view.getString("Enter file name: ");
                    students = textRepo.readList(fileName);
                    view.showMessage("Loaded from text file.");
                }
                case 15 -> {
                    String fileName = view.getString("Enter file name: ");
                    binRepo.outputList(students, fileName);
                    view.showMessage("Saved to binary file.");
                }
                case 16 -> {
                    String fileName = view.getString("Enter file name: ");
                    students = binRepo.readList(fileName);
                    view.showMessage("Loaded from binary file.");
                }
                case 0 -> {
                    view.showMessage("Exiting...");
                    return;
                }
                default -> view.showMessage("Invalid choice.");
            }
        }
    }
}