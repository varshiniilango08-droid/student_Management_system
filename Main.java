import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        manager.setStudents(FileManager.loadStudents());

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    int id = readInt(scanner, "Enter Student ID: ");

                    if (id <= 0) {
                        System.out.println("Student ID must be positive!");
                        break;
                    }

                    if (manager.studentExists(id)) {
                        System.out.println("Student ID already exists!");
                        break;
                    }

                    scanner.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine().trim();

                    if (name.isEmpty()) {
                        System.out.println("Error: Name cannot be empty!");
                        break;
                    }

                    int age = readInt(scanner, "Enter Age: ");

                    if (age <= 0 || age > 100) {
                        System.out.println("Age must be between 1 and 100!");
                        break;
                    }

                    scanner.nextLine();

                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine().trim();

                    if (course.isEmpty()) {
                        System.out.println("Error: Course cannot be empty!");
                        break;
                    }

                    double marks = readDouble(scanner, "Enter Marks (0-100): ");

                    if (marks < 0 || marks > 100) {
                        System.out.println("Marks must be between 0 and 100!");
                        break;
                    }

                    Student student = new Student(
                            id,
                            name,
                            age,
                            course,
                            marks
                    );
                    

                    manager.addStudent(student);
                    FileManager.saveStudents(manager.getStudents());
                    break;

                case 2:
                    manager.displayAllStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID to search: ");
                    int searchId = scanner.nextInt();

                    manager.searchStudent(searchId);
                    break;

                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = scanner.nextInt();

                    manager.deleteStudent(deleteId);
                    FileManager.saveStudents(manager.getStudents());
                    break;
                case 5:
                    System.out.print("Enter Student ID to update: ");
                    int updateId = scanner.nextInt();

                    manager.updateStudent(updateId);
                    FileManager.saveStudents(manager.getStudents());
                    break;

                case 6:
                    System.out.println("Thank you for using Student Management System!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static int readInt(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);

            if (scanner.hasNextInt()) {
                 return scanner.nextInt();
            }

            System.out.println("Invalid input! Enter a whole number.");
            scanner.next();
        }
    }

    public static double readDouble(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);

            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            }

            System.out.println("Invalid input! Enter a numeric value.");
            scanner.next();
        }
    }
}