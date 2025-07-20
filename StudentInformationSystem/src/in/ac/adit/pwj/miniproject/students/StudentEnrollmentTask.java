package in.ac.adit.pwj.miniproject.students;
public class StudentEnrollmentTask implements Runnable {
    private StudentManager manager;
    private Student student;
    private String course;
    public StudentEnrollmentTask(StudentManager manager, Student student, String course) {
        this.manager = manager;
        this.student = student;
        this.course = course;
    }
    @Override
    public void run() {
        student.enrollInCourse(course);
        manager.addStudent(student);
        System.out.println("Enrolled " + student.getName() + " in " + course);
    }
}
