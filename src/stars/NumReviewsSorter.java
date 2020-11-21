package stars;
import java.util.Comparator;

public class NumReviewsSorter implements Comparator<Course> {
    /**
     * Sort courses by number of reviews.
     * @param c1 first course to be compared
     * @param c2 second course to be compared
     * @return int
     */
    @Override
    public int compare(Course c1, Course c2) {
        return Double.compare(c2.getTotalReviews(), c1.getTotalReviews());
    }
}