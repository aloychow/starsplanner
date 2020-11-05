package stars;
import java.util.*;
public class Course {
private String name;
private String courseCode;
private School school;
private ArrayList<Index> index;
private String courseType;
private int vacancy;
private int totalAUs;

public Course(String name, String courseCode, School school, String courseType,int vacancy, int totalAUs)
{	//need to do object creation for ArrayList index here maybe
	//if school is a composition of course, can we add a school object inside course?
	this.name=name;
	this.courseCode=courseCode;
	this.school=school;
	this.courseType=courseType;
	this.vacancy=vacancy;
	this.totalAUs=totalAUs;
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
public void setCourseType(String courseType)
{
	this.courseType=courseType;
}
public String getCourseType()
{
	return this.courseType;
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
public void setIndex()
{
	//setIndex decide what to put
	sys
}
public ArrayList<Index> getIndex()
{
	return this.index;
}


}