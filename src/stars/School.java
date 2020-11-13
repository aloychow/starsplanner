package stars;
import java.util.*;
import java.io.Serializable;
public class School implements Serializable{
    private String name;
    private Date registrationStartPeriod = new Date();
    private Date registrationEndPeriod = new Date();
    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    public School()
    {
    }
    public School(String name, Date registrationStartPeriod, Date registrationEndPeriod) {
        this.name = name;
        this.registrationStartPeriod = registrationStartPeriod;
        this.registrationEndPeriod = registrationEndPeriod;
        this.courses=null;
        this.students=null;
    }
    public School(String name, Date registrationStartPeriod, Date registrationEndPeriod, ArrayList<Student> students, ArrayList<Course> courses) {
        this.name = name;
        this.registrationStartPeriod = registrationStartPeriod;
        this.registrationEndPeriod = registrationEndPeriod;
        this.courses=courses;
        this.students=students;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegistrationStartPeriod() {
        return this.registrationStartPeriod;
    }

    public void setRegistrationStartPeriod(Date date) {
        this.registrationStartPeriod = date;
    }

    public Date getRegistrationEndPeriod() {
        return this.registrationEndPeriod;
    }

    public void setRegistrationEndPeriod(Date date) {
        this.registrationEndPeriod = date;
    }
    public void setStudents(ArrayList<Student> students)
    {
        this.students=students;
    }
    public ArrayList<Student> getStudents()
    {
        return students;
    }
    public void setCourses(ArrayList<Course> courses)
    {
        this.courses=courses;
    }
    public ArrayList<Course> getCourses()
    {
        return courses;
    }
    public void deleteCourse(Course c) {
        for (int i = 0 ; i < this.courses.size(); i ++){

            if(this.courses.get(i).getCourseCode().equals(c.getCourseCode())){
                this.courses.remove(i);
                System.out.println("Course successfully removed");
                break;
            }
        }
    }
    public Course addCourse(String name, String courseCode, String courseType, int vacancies, int totalAUs) {
        Course c = new Course(name, courseCode, this,courseType,vacancies, totalAUs);
        this.courses.add(c);
        System.out.println("Course successfully added!");
        return c;
    }
    public boolean checkWithinAccessPeriod()
    { //add functionality to see if it is within access period
        return true;
    }

}
