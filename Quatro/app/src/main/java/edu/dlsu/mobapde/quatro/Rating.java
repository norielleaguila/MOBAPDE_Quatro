package edu.dlsu.mobapde.quatro;

/**
 * Created by Norielle on 11/14/2017.
 */

public class Rating extends Post {
    private float rating;

    public Rating(int userIcon, String userName, String profName, String course, double grade, int upVotes, int downVotes, float rating) {
        super(userIcon, userName, profName, course, grade, upVotes, downVotes);
        this.rating = rating;
        this.action = "Rated";
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
