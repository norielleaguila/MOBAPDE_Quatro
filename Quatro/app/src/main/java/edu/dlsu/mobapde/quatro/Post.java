package edu.dlsu.mobapde.quatro;

/**
 * Created by Norielle on 11/14/2017.
 */

public abstract class Post {
    private int userIcon;
    private String userName;
    private String action;
    private String course;
    private double grade;
    private int upVotes;
    private int downVotes;

    public Post(int userIcon, String userName, String action, String course, double grade, int upVotes, int downVotes) {
        this.userIcon = userIcon;
        this.userName = userName;
        this.action = action;
        this.course = course;
        this.grade = grade;
        this.upVotes = upVotes;
        this.downVotes = downVotes;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(int userIcon) {
        this.userIcon = userIcon;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(int upVotes) {
        this.upVotes = upVotes;
    }

    public int getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(int downVotes) {
        this.downVotes = downVotes;
    }
}
