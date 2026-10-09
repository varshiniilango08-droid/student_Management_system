import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students;

    // Constructor
    public StudentManager() 
    {
        students = new ArrayList<>();
    }

    // Add student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    // Display all students
    public void displayAllStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            student.displayStudent();
            System.out.println("-------------------------");
        }
    }

    // Search student by ID
    public void searchStudent(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                System.out.println("Student found!");
                student.displayStudent();
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Delete student by ID
    public void deleteStudent(int id) {

    for (int i = 0; i < students.size(); i++) {

        if (students.get(i).getId() == id) {
            students.remove(i);
            System.out.println("Student deleted successfully!");
            return;
        }
    }

    System.out.println("Student not found.");
    }
    // Update student details
public void updateStudent(int id) {

    for (Student student : students) {

        if (student.getId() == id) {

            java.util.Scanner sc =
                    new java.util.Scanner(System.in);

            sc.nextLine();

            System.out.print("Enter new name: ");
            String name = sc.nextLine();

            System.out.print("Enter new age: ");
            int age = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter new course: ");
            String course = sc.nextLine();

            System.out.print("Enter new marks: ");
            double marks = sc.nextDouble();

            student.setName(name);
            student.setAge(age);
            student.setCourse(course);
            student.setMarks(marks);

            System.out.println("Student updated successfully!");
            return;
        }
    }

    System.out.println("Student not found.");
    }
    
    public void setStudents(ArrayList<Student> students) {
    this.students = students;
    }
    
    public ArrayList<Student> getStudents() {
    return students;
    }
    // Check whether a student ID already exists
    public boolean studentExists(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                return true;
            }
        }

        return false;
    }
}