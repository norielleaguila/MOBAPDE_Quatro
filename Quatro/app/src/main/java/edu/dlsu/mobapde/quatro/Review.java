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
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
