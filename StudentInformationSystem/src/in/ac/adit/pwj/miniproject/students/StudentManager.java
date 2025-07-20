package in.ac.adit.pwj.miniproject.students;
import java.io.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
public class StudentManager {
    private Map<String, Student> studentMap = new ConcurrentHashMap<>();
    public void addStudent(Student student) {
        studentMap.put(student.getStudentID(), student);
    }
    public void updateGrade(String studentID, double grade) throws InvalidGradeException {
        if (grade < 0 || grade > 100) {
            throw new InvalidGradeException("Grade must be between 0 and 100.");
        }
        System.out.println("Grade for " + studentID + " updated to " + grade);
    }
    public class GradeCalculator {
        public double calculateGPA(double[] grades) {
            double sum = 0;
            for (double grade : grades) sum += grade;
            return grades.length > 0 ? sum / grades.length : 0;
        }
    }
    public Student getStudent(String studentID) { return studentMap.get(studentID); }
    public void saveStudentsToFile(String filePath) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(studentMap);
        }
    }
    public void loadStudentsFromFile(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            studentMap = (Map<String, Student>) in.readObject();
        }
    }
}
