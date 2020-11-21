package stars;

import java.util.Comparator;

public class PercRecommendedSorter implements Comparator<Course> {
    /**
     * Sort courses by percentage recommended.
     * @param c1
     * @param c2
     * @return int
     */
    @Override
    public int compare(Course c1, Course c2) {
        return Double.compare(c2.getPercRecommended(),c1.getPercRecommended());
    }
}