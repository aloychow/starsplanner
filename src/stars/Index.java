package stars;
import java.util.*;
import java.io.Serializable;
public class Index implements Serializable {
    private Course course;
    private int indexNum;
    private int vacancies;
    private int totalSlots;
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
        int diff = vacancies-this.vacancies;
        this.course.editVacancies(diff);//changing the course vacancies accordingly
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

    public int getTotalSlots() {
        return totalSlots;
    }

    public void setTotalSlots(int totalSlots) {
        this.totalSlots = totalSlots;
    }

    public void setWaitList(Queue<Student> waitList) {
        this.waitList = waitList;
    }

    public ArrayList<RegisteredCourse> getRegList() {
        return regList;
    }

    public void setRegList(ArrayList<RegisteredCourse> regList) {
        this.regList = regList;
    }

    public void addStudyGroup(String venue, String startTime, String endTime, int dayOfWeek, String weekType, String lessonType) {
        StudyGroup sg = new StudyGroup(venue,startTime,endTime,dayOfWeek,weekType,lessonType, this);
        this.studyGroup.add(sg);

    }

}