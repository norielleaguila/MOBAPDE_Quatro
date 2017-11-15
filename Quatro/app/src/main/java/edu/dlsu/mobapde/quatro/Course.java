package edu.dlsu.mobapde.quatro;

/**
 * Created by Janella on 14/11/2017.
 */

public class Course {

    private String course_code;
    private String course_name;

    public Course() {

    }

    public Course(String course_code, String course_name) {
        this.course_code = course_code;
        this.course_name = course_name;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }
}
