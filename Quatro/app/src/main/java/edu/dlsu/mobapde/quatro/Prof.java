package edu.dlsu.mobapde.quatro;

import java.util.ArrayList;

public class Prof {
    public static int total_profs = 0;

    public static final String TABLE_PROF = "profs";
    public static final String COL_ID = "_id";

    private int prof_id;

    private int num_reviews;

    private double rating;      // can be null
    private double avg_grade;

    private boolean rated;

    private String first_name;
    private String last_name;
    private String college;
    private String title;
    private String department;

    private ArrayList<Course> courses;

    public Prof() {
        this.rating = 0;
        this.rated = false;
    }

    /**
     * without rating
     * @param prof_id
     * @param num_reviews
     * @param avg_grade
     * @param rated
     * @param first_name
     * @param last_name
     * @param college
     * @param title
     * @param department
     */
    public Prof(int prof_id, int num_reviews, double avg_grade, boolean rated, String first_name, String last_name, String college, String title, String department) {
        this();
        this.prof_id = prof_id;
        this.num_reviews = num_reviews;
        this.avg_grade = avg_grade;
        this.rated = rated;
        this.first_name = first_name;
        this.last_name = last_name;
        this.college = college;
        this.title = title;
        this.department = department;
    }

    /**
     * without arraylist of courses
     * @param prof_id
     * @param num_reviews
     * @param rating
     * @param avg_grade
     * @param rated
     * @param first_name
     * @param last_name
     * @param college
     * @param title
     * @param department
     */
    public Prof(int prof_id, int num_reviews, double rating, double avg_grade, boolean rated, String first_name, String last_name, String college, String title, String department) {
        this();
        this.prof_id = prof_id;
        this.num_reviews = num_reviews;
        this.rating = rating;
        this.avg_grade = avg_grade;
        this.rated = rated;
        this.first_name = first_name;
        this.last_name = last_name;
        this.college = college;
        this.title = title;
        this.department = department;
        this.rated = true;
    }

    public Prof(int prof_id, int num_reviews, double rating, double avg_grade, String first_name, String last_name, String college, String title, String department, ArrayList<Course> courses) {
        this();
        this.prof_id = prof_id;
        this.num_reviews = num_reviews;
        this.rating = rating;
        this.avg_grade = avg_grade;
        this.first_name = first_name;
        this.last_name = last_name;
        this.college = college;
        this.title = title;
        this.department = department;
        this.courses = courses;
        this.rated = true;
    }

    public int getProf_id() {
        return prof_id;
    }

    public void setProf_id(int prof_id) {
        this.prof_id = prof_id;
    }

    public int getNum_reviews() {
        return num_reviews;
    }

    public void setNum_reviews(int num_reviews) {
        this.num_reviews = num_reviews;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getAvg_grade() {
        return avg_grade;
    }

    public void setAvg_grade(double avg_grade) {
        this.avg_grade = avg_grade;
    }

    public boolean isRated() {
        return rated;
    }

    public void setRated(boolean rated) {
        this.rated = rated;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Prof{" +
                "prof_id=" + prof_id +
                ", num_reviews=" + num_reviews +
                ", rating=" + rating +
                ", avg_grade=" + avg_grade +
                ", rated=" + rated +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", college='" + college + '\'' +
                ", title='" + title + '\'' +
                ", department='" + department + '\'' +
                ", courses=" + courses +
                '}';
    }

    public void addCourse(Course course){
        if(course == null)
            courses = new ArrayList<Course>();
        else{
            courses.add(course);
        }
    }
}
