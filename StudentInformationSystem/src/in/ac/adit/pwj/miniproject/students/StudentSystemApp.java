package in.ac.adit.pwj.miniproject.students;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StudentSystemApp {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Student student1 = new Undergraduate("U1001", "Alice", "Engineering");
        Student student2 = new Graduate("G1002", "Bob", "Science", "Quantum Computing");

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(new StudentEnrollmentTask(manager, student1, "Math101"));
        executor.execute(new StudentEnrollmentTask(manager, student2, "CS102"));

        executor.execute(new GradeUpdateTask(manager, "U1001", 88.5));
        executor.execute(new GradeUpdateTask(manager, "G1002", 92.0));

        executor.shutdown();

        String filePath = "students.dat";
        try {
            manager.saveStudentsToFile(filePath);
            System.out.println("Student records saved.");

            manager.loadStudentsFromFile(filePath);
            System.out.println("Student records loaded.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("File handling error: " + e.getMessage());
        }
    }
}
