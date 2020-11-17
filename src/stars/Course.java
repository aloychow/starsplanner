package stars;
import java.util.*;
import java.io.Serializable;
public class Course implements Serializable {
    private String name;
    private String courseCode;
    private School school;
    private ArrayList<Index> index;
    private CourseType courseType;
    private int vacancy;
    private int totalAUs;
    private int nLectures;
    public Course()
    {

    }
    public Course(String name, String courseCode, School school, CourseType courseType,int vacancy, int totalAUs, int nLectures)
    {	//need to do object creation for ArrayList index here maybe
        //if school is a composition of course, can we add a school object inside course?
        this.name=name;
        this.courseCode=courseCode;
        this.school=school;
        this.courseType=courseType;
        this.vacancy=vacancy;
        this.totalAUs=totalAUs;
        this.nLectures=nLectures;
    }
    public Course(String name, String courseCode, School school, CourseType courseType, int totalAUs, int nLectures)
    {	//need to do object creation for ArrayList index here maybe
        //if school is a composition of course, can we add a school object inside course?
        this.name=name;
        this.courseCode=courseCode;
        this.school=school;
        this.courseType=courseType;
        this.vacancy=0;
        this.totalAUs=totalAUs;
        this.nLectures = nLectures;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return this.name;
    }
    public void setCourseCode(String courseCode)
    {
        this.courseCode=courseCode;
    }
    public String getCourseCode()
    {
        return this.courseCode;
    }
    public void setCourseType(CourseType courseType)
    {
        this.courseType=courseType;
    }
    public CourseType getCourseType()
    {
        return this.courseType;
    }
    public int getnLectures() {
        return nLectures;
    }
    public void setnLectures(int nLectures) {
        this.nLectures = nLectures;
    }
    public void setVacancy(int vacancy)
    {
        this.vacancy=vacancy;
    }
    public int getVacancy()
    {
        return this.vacancy;
    }
    public void setTotalAUs(int totalAUs)
    {
        this.totalAUs=totalAUs;
    }
    public int getTotalAUs()
    {
        return this.totalAUs;
    }
    public void setSchool(School school)
    {
        this.school=school;
    }
    public School getSchool()
    {
        return this.school;
    }

    public Index setIndex(int indexNum, String groupNum, int vacancies)
    {
        Index i = new Index(indexNum, groupNum, vacancies, this);
        this.index.add(i);
        this.editVacancies(vacancies);
        return i;
    }
    public void deleteIndex(Index indID) {
        for (int i = 0 ; i < this.index.size(); i ++){

            if(this.index.get(i).getIndexNum() == indID.getIndexNum()){
                this.index.remove(i);
                System.out.println("Index successfully removed");
                break;
            }
        }
    }
    //allows increase or decrease of number of vacancies by n
    public void editVacancies(int n) {
        this.vacancy = this.vacancy + n;
    }
    public ArrayList<Index> getIndex()
    {
        return this.index;
    }


}