package lab5;

public class StudentController {
    private Student[] students;
    private final StudentService service;
    private final StudentView view;
    private final StudentRepository textRepo;
    private final StudentRepository binRepo;

    public StudentController(Student[] students) {
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
                case 1 -> service.printAllStudents(students);
                case 2 -> {
                    String group = view.getString("Enter group: ");
                    service.printStudentsByGroup(students, group);
                }
                case 3 -> {
                    String faculty = view.getString("Enter faculty: ");
                    service.printStudentsByFaculty(students, faculty);
                }
                case 4 -> {
                    int year = view.getInt("Enter year: ");
                    service.printStudentsByYear(students, year);
                }
                case 5 -> {
                    String fileName = view.getString("Enter file name: ");
                    textRepo.outputArray(students, fileName);
                    view.showMessage("Saved to text file.");
                }
                case 6 -> {
                    String fileName = view.getString("Enter file name: ");
                    students = textRepo.readArray(fileName);
                    view.showMessage("Loaded from text file.");
                }
                case 7 -> {
                    String fileName = view.getString("Enter file name: ");
                    binRepo.outputArray(students, fileName);
                    view.showMessage("Saved to binary file.");
                }
                case 8 -> {
                    String fileName = view.getString("Enter file name: ");
                    students = binRepo.readArray(fileName);
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