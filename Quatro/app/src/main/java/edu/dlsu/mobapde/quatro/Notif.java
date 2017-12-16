package edu.dlsu.mobapde.quatro;

public class Notif {
    public final static String TABLE_NOTIF = "notifs";
    public final static String COL_ID = "_id";
    public final static String COL_READ = "read";
    public final static String COL_USER = "user";
    public final static String COL_ACTION = "action";
    public final static String COL_POST = "post";

    private int id;

    private boolean read = false;

    private String user;
    private String action;
    private String post;    // link to post

    public Notif() {
        post = "post";
    }

    public Notif(String user, String action) {
        this();
        this.user = user;
        this.action = action;
    }

    public Notif(int id, String user, String action) {
        this();
        this.id = id;
        this.user = user;
        this.action = action;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
