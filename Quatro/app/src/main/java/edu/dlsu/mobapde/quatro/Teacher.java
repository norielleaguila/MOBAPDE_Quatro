package edu.dlsu.mobapde.quatro;

/**
 * Created by Janella on 14/11/2017.
 */

public class Teacher {

    private int faculty_id;
    private String first_name;
    private String lastname;
    private String college;
    private String department;

    public Teacher() {

    }

    public Teacher(String first_name, String lastname, String college, String department) {
        this.first_name = first_name;
        this.lastname = lastname;
        this.college = college;
        this.department = department;
    }

    public int getFaculty_id() {
        return faculty_id;
    }

    public void setFaculty_id(int faculty_id) {
        this.faculty_id = faculty_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

