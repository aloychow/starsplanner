package stars;
import java.util.*;
import java.io.Serializable;
public class Index implements Serializable {
    private Course course;
    private int indexNum;
    private int vacancies;
    private String groupNum;
    private Queue<Student> waitList;
    private ArrayList<RegisteredCourse> regList;
    private ArrayList<StudyGroup> studyGroup;
    public Index()
    {

    }
    public Index(int indexNum, String groupNum, int vacancies, Course course)
    {	this.course=course;
        this.indexNum=indexNum;
        this.groupNum=groupNum;
        this.vacancies=vacancies;

    }
    public void setIndexNum(int indexNum)
    {
        this.indexNum=indexNum;
    }
    public int getIndexNum()
    {
        return this.indexNum;
    }
    public void setCourse(Course course)
    {
        this.course=course;
    }
    public Course getCourse()
    {
        return this.course;
    }
    public void setVacancies(int vacancies)
    {
        this.vacancies=vacancies;
    }
    public int getVacancies()
    {
        return this.vacancies;
    }
    public void setGroupNum(String groupNum)
    {
        this.groupNum=groupNum;
    }
    public String getGroupNum()
    {
        return this.groupNum;
    }
    public void setWaitlist(Queue<Student> waitList)
    {
        this.waitList=waitList;
    }
    public Queue<Student> getWaitList()
    {
        return this.waitList;
    }
    public void setRegisteredCourses(ArrayList<RegisteredCourse> regList)
    {
        this.regList=regList;
    }
    public ArrayList<RegisteredCourse> getRegisteredCourses()
    {
        return regList;
    }
    public void setStudyGroup(ArrayList<StudyGroup> studyGroup)
    {
     this.studyGroup=studyGroup;
    }
    public ArrayList<StudyGroup> getStudyGroup()
    {
        return studyGroup;
    }

}