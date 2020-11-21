package stars;

public class Review {
    private String review;
    private boolean recommended;
    private Student student;
    private Course course;

    public Review(String review, boolean recommended, Student s, Course c) {
        this.review = review;
        this.recommended = recommended;
        this.student = s;
        this.course = c;
        this.course.addReview(this);
        this.student.addMyReview(this);

    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public boolean isRecommended() {
        return recommended;
    }

    public void setRecommended(boolean recommended) {
        if (recommended  && !this.recommended) {
            course.setPercRecommended((course.getPercRecommended() * course.getTotalReviews() + 1)/(double) course.getTotalReviews());
        }
        this.recommended = recommended;

    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}

