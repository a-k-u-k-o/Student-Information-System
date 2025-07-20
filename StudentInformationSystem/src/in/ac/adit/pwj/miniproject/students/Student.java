package in.ac.adit.pwj.miniproject.students;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Student implements Serializable {
    private String studentID;
    private String name;
    private String department;
    private List<String> courses = new ArrayList<>();
    public Student(String studentID, String name, String department) {
        this.studentID = studentID;
        this.name = name;
        this.department = department;
    }
    public String getStudentID() { return studentID; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public void enrollInCourse(String course) { courses.add(course); }
    public List<String> getCourses() { return courses; }
}
class Undergraduate extends Student {
    public Undergraduate(String studentID, String name, String department) {
        super(studentID, name, department);
    }
}
class Graduate extends Student {
    private String projectTopic;
    public Graduate(String studentID, String name, String department, String projectTopic) {
        super(studentID, name, department);
        this.projectTopic = projectTopic;
    }
    public String getProjectTopic() { return projectTopic; }
    public void setProjectTopic(String projectTopic) { this.projectTopic = projectTopic; }
}
