package in.ac.adit.pwj.miniproject.students;
public class GradeUpdateTask implements Runnable {
    private StudentManager manager;
    private String studentID;
    private double grade;
    public GradeUpdateTask(StudentManager manager, String studentID, double grade) {
        this.manager = manager;
        this.studentID = studentID;
        this.grade = grade;
    }
    @Override
    public void run() {
        try {
            manager.updateGrade(studentID, grade);
        } catch (InvalidGradeException e) {
            System.out.println(e.getMessage());
        }
    }
}
