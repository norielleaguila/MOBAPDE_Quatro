package edu.dlsu.mobapde.quatro;

import java.util.ArrayList;

/**
 * Created by Norielle on 11/14/2017.
 */

public class Prof {
    private String profName;
    private String dept;
    private ArrayList<String> courses;
    private float rating;
    private float avgGrade;
    private int numReviews;

    public Prof(String profName, String dept, float rating, float avgGrade, int numReviews) {
        this.profName = profName;
        this.dept = dept;
        this.rating = rating;
        this.avgGrade = avgGrade;
        this.numReviews = numReviews;
        this.courses = new ArrayList<>();
        this.courses.add("NA");
    }

    public Prof(String profName, String dept, ArrayList<String> courses, float rating, float avgGrade, int numReviews) {
        this.profName = profName;
        this.dept = dept;
        this.courses = courses;
        this.rating = rating;
        this.avgGrade = avgGrade;
        this.numReviews = numReviews;
    }

    public String getProfName() {
        return profName;
    }

    public void setProfName(String profName) {
        this.profName = profName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public float getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(float avgGrade) {
        this.avgGrade = avgGrade;
    }

    public int getNumReviews() {
        return numReviews;
    }

    public void setNumReviews(int numReviews) {
        this.numReviews = numReviews;
    }

    public boolean checkIfTeaches(String course){
        if(courses.contains(course.toUpperCase()))
            return true;
        return false;
    }

    public String getCoursesForDisplay(){
        String temp = "";

        for(String course: courses){
            temp += course.toUpperCase() + ", ";
        }

        temp = temp.substring(0, temp.length() - 1);

        return temp;
    }

    public void addCourse(String course){
        if(courses.contains("NA"))
            courses.clear();

        courses.add(course);
    }


}
