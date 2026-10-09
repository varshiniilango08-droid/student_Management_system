import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private static final String FILE_NAME = "students.txt";

    // Save students to a file
    public static void saveStudents(List<Student> students) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Student student : students) {

                writer.write(
                    student.getId() + "," +
                    student.getName() + "," +
                    student.getAge() + "," +
                    student.getCourse() + "," +
                    student.getMarks()
                );

                writer.newLine();
            }

            System.out.println("Student records saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving student records.");
        }
    }

    // Load students from a file
    public static ArrayList<Student> loadStudents() {

        ArrayList<Student> students = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return students;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",", -1);

                if (data.length != 5) {
                    continue;
                }

                try {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    String course = data[3];
                    double marks = Double.parseDouble(data[4]);

                    Student student = new Student(
                        id, name, age, course, marks
                    );

                    students.add(student);

                } catch (NumberFormatException e) {
                    System.out.println("Skipping an invalid student record.");
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading student records.");
        }

        return students;
    }
}