package edu.dlsu.mobapde.quatro;

public class Post {
    public static int total_posts = 0;

    public static final String TABLE_POST = "posts";
    public static final String COL_ID = "_id";
    public static final String COL_PROF_ID = "prof_id";
    public static final String COL_USER_ID = "user_id";
    public static final String COL_USER_ICON = "user_icon";
    public static final String COL_USER_NAME = "user_name";
    public static final String COL_PROF_NAME = "prof_name";
    public static final String COL_COURSE = "course";
    public static final String COL_REVIEW = "review";
    public static final String COL_RATING = "rating";
    public static final String COL_GRADE = "grade";
    public static final String COL_UPVOTES = "upvotes";
    public static final String COL_DOWNVOTES = "downvotes";

    private int post_id;
    private int prof_id;
    private int user_id;
    private int user_icon;

    private int upvotes;
    private int downvotes;

    private String user_name;
    private String prof_name;
    private String course;
    private String review;  // can be empty

    private double rating;  // can be 'empty'
    private double grade;   // user grade from prof

    private boolean rated;

    /**
     * empty constructor
     * sets default values for nullable fields
     */
    public Post () {
        total_posts ++;

        this.user_icon = 0;
        this.rating = 0;
        this.review = "";
        this.rated = false;
    }

    /**
     * without review/rating
     * @param post_id
     * @param prof_id
     * @param user_id
     * @param user_icon
     * @param upvotes
     * @param downvotes
     * @param user_name
     * @param prof_name
     * @param course
     * @param grade
     * @param rated
     */
    public Post(int post_id, int prof_id, int user_id, int user_icon, int upvotes, int downvotes, String user_name, String prof_name, String course, double grade, boolean rated) {
        this();
        this.post_id = post_id;
        this.prof_id = prof_id;
        this.user_id = user_id;
        this.user_icon = user_icon;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.user_name = user_name;
        this.prof_name = prof_name;
        this.course = course;
        this.grade = grade;
        this.rated = rated;
    }

    /**
     * With review
     * @param post_id
     * @param prof_id
     * @param user_icon
     * @param upvotes
     * @param downvotes
     * @param user_name
     * @param prof_name
     * @param course
     * @param review
     * @param grade
     * @param rated
     */
    public Post(int post_id, int prof_id, int user_id,  int user_icon, int upvotes, int downvotes, String user_name, String prof_name, String course, String review, double grade, boolean rated) {
        this();
        this.post_id = post_id;
        this.prof_id = prof_id;
        this.user_id = user_id;
        this.user_icon = user_icon;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.user_name = user_name;
        this.prof_name = prof_name;
        this.course = course;
        this.review = review;
        this.grade = grade;
        this.rated = rated;
    }

    /**
     * With rating
     * @param post_id
     * @param prof_id
     * @param user_icon
     * @param upvotes
     * @param downvotes
     * @param user_name
     * @param prof_name
     * @param course
     * @param rating
     * @param grade
     * @param rated
     */
    public Post(int post_id, int prof_id, int user_id, int user_icon, int upvotes, int downvotes, String user_name, String prof_name, String course, double rating, double grade, boolean rated) {
        this();
        this.post_id = post_id;
        this.prof_id = prof_id;
        this.user_id = user_id;
        this.user_icon = user_icon;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.user_name = user_name;
        this.prof_name = prof_name;
        this.course = course;
        this.rating = rating;
        this.grade = grade;
        this.rated = rated;
    }

    /**
     * with review and rating
     * @param post_id
     * @param prof_id
     * @param user_icon
     * @param upvotes
     * @param downvotes
     * @param user_name
     * @param prof_name
     * @param course
     * @param review
     * @param rating
     * @param grade
     * @param rated
     */
    public Post(int post_id, int prof_id, int user_id, int user_icon, int upvotes, int downvotes, String user_name, String prof_name, String course, String review, double rating, double grade, boolean rated) {
        this();
        this.post_id = post_id;
        this.prof_id = prof_id;
        this.user_id = user_id;
        this.user_icon = user_icon;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.user_name = user_name;
        this.prof_name = prof_name;
        this.course = course;
        this.review = review;
        this.rating = rating;
        this.grade = grade;
        this.rated = rated;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public int getProf_id() {
        return prof_id;
    }

    public void setProf_id(int prof_id) {
        this.prof_id = prof_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_icon() {
        return user_icon;
    }

    public void setUser_icon(int user_icon) {
        this.user_icon = user_icon;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public int getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(int downvotes) {
        this.downvotes = downvotes;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getProf_name() {
        return prof_name;
    }

    public void setProf_name(String prof_name) {
        this.prof_name = prof_name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public boolean isRated() {
        return rated;
    }

    public void setRated(boolean rated) {
        this.rated = rated;
    }

    @Override
    public String toString() {
        return "Post{" +
                "post_id=" + post_id +
                ", prof_id=" + prof_id +
                ", user_id=" + user_id +
                ", user_icon=" + user_icon +
                ", upvotes=" + upvotes +
                ", downvotes=" + downvotes +
                ", user_name='" + user_name + '\'' +
                ", prof_name='" + prof_name + '\'' +
                ", course='" + course + '\'' +
                ", review='" + review + '\'' +
                ", rating=" + rating +
                ", grade=" + grade +
                ", rated=" + rated +
                '}';
    }
}
