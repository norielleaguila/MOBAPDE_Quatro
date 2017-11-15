package edu.dlsu.mobapde.quatro;

/**
 * Created by Norielle on 11/14/2017.
 */

public class Review extends Post {

    private String review;

    public Review(int userIcon, String userName, String profName, String course, double grade, int upVotes, int downVotes, String review) {
        super(userIcon, userName, profName, course, grade, upVotes, downVotes);
        this.review = review;
        this.action = "Reviewed";
 * Created by Janella on 14/11/2017.
 */

public class Review {

    private int review_id;
    private int student_id;
    private int faculty_id;
    private float rating;
    private String review;
    private int upvotes;
    private int downvotes;
    private double grade;
    private String subject;

    public Review() {

    }

    public Review(int student_id, int faculty_id, int rating, String review, int upvotes, int downvotes, double grade) {
        this.student_id = student_id;
        this.faculty_id = faculty_id;
        this.rating = rating;
        this.review = review;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.grade = grade;
    }

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getFaculty_id() {
        return faculty_id;
    }

    public void setFaculty_id(int faculty_id) {
        this.faculty_id = faculty_id;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
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

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Review{" +
                "review_id=" + review_id +
                ", student_id=" + student_id +
                ", faculty_id=" + faculty_id +
                ", rating=" + rating +
                ", review='" + review + '\'' +
                ", upvotes=" + upvotes +
                ", downvotes=" + downvotes +
                ", grade=" + grade +
                ", subject='" + subject + '\'' +
                '}';
    }
}
