package stars;
import java.util.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Student extends User implements Serializable{
    private String   name;
    private String   matricNumber;
    private String   gender;
    private String   nationality;
    private int    year;
    private int    numberOfAUs;
    private ArrayList<RegisteredCourse> regCourses;
    private School school;
    private HashMap<String, String> notificationType=new HashMap<String, String>();
    public static final  int MAX_AUs = 22;
    public Student()
    {
        super();
    }

    public Student(String name, String matricNumber, String gender, String nationality, int year, int numberOFAUs,
                   ArrayList<RegisteredCourse> regCourses, School school, String choice, String recipient, String email, String password, String typeOfUser, String userName) {
        super(email, password, typeOfUser, userName);
        this.name = name;
        this.matricNumber = matricNumber;
        this.gender = gender;
        this.nationality = nationality;
        this.year = year;
        this.numberOfAUs = numberOFAUs;
        this.regCourses = regCourses;
        this.school = school;
        notificationType.put(choice, recipient);

    }
    public Student(String name, String matricNumber, String gender, String nationality, int year, School school,String choice,String recipient, String email, String password,String typeOfUser, String userName)

    {
        super(email, password, typeOfUser, userName);
        this.name = name;
        this.matricNumber = matricNumber;
        this.gender = gender;
        this.nationality = nationality;
        this.year = year;
        this.school = school;
        notificationType.put(choice,recipient);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMatricNumber() {
        return matricNumber;
    }

    public void setMatricNumber(String matricNumber) {
        this.matricNumber = matricNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumberOfAUs() {
        return numberOfAUs;
    }

    public void setNumberOfAUs(int numberOFAUs) {
        this.numberOfAUs = numberOFAUs;
    }

    public ArrayList<RegisteredCourse> getRegCourses() {
        return regCourses;
    }

    public void setRegCourses(ArrayList<RegisteredCourse> regCourses) {
        this.regCourses = regCourses;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    //adding a registered course for the student
    public void addRegCourses(RegisteredCourse Course) {
        this.regCourses.add(Course);
    }
    //removing a course which the student unregistered from
    public void removeRegCourses(RegisteredCourse Course) {
        this.regCourses.remove(Course);
    }

    public HashMap<String, String> getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(HashMap<String, String> notificationType) {
        this.notificationType = notificationType;
    }
}
