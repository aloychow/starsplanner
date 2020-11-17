package stars;
import java.io.Serializable;
public class StudyGroup implements Serializable{

    private String venue;
    private String startTime;
    private String endTime;
    private int dayOfWeek;
    private String weekType;
    private Index index;
    private LessonType lessonType;
    public StudyGroup()
    {

    }
    public StudyGroup(String venue, String startTime, String endTime, int dayOfWeek, String weekType, LessonType lessonType,Index index) {
        this.venue = venue;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dayOfWeek = dayOfWeek;
        this.weekType = weekType;
        this.lessonType=lessonType;
        this.index = index;
    }
    public String getVenue() {
        return venue;
    }
    public void setVenue(String venue) {
        this.venue = venue;
    }
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    public int getDayOfWeek() {
        return dayOfWeek;
    }
    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
    public String getWeekType() {
        return weekType;
    }
    public void setWeekType(String weekType) {
        this.weekType = weekType;
    }
    public LessonType getLessonType()
    {
        return lessonType;
    }
    public void setLessonType(LessonType lessonType)
    {
        this.lessonType=lessonType;
    }
    public Index getIndex() {
        return index;
    }
    public void setIndex(Index index) {
        this.index = index;
    }


}