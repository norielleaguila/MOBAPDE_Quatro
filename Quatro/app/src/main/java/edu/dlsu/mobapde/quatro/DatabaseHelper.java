package edu.dlsu.mobapde.quatro;

import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Janella on 14/11/2017.
 */

public class DatabaseHelper {

    final static String TAG = "DatabaseHelper";

    private FirebaseDatabase database;
    private DatabaseReference dbRefStudents;
    private DatabaseReference dbRefProf;
    private DatabaseReference dbRefPosts;
    private DatabaseReference dbRefCourses;

    private ArrayList<Student> allStudents;
    private ArrayList<Prof> allProfs;
    private ArrayList<Post> allPosts;
    private ArrayList<Course> allCourses;

    public void connectToDatabase(){

        // Connect to DB
        database = FirebaseDatabase.getInstance();
        dbRefStudents = database.getReference().child("students");
        dbRefProf = database.getReference().child("profs");
        dbRefPosts = database.getReference().child("posts");
        dbRefCourses = database.getReference().child("courses");

        Log.i(TAG, dbRefStudents.toString());
        Log.i(TAG, dbRefCourses.toString());
        Log.i(TAG, dbRefPosts.toString());
        Log.i(TAG, dbRefProf.toString());

        readAllStudents();

    }

    public void readAllStudents(){
        allStudents = new ArrayList<Student>();
        // Read from the database
        dbRefStudents.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.w(TAG, "getting all students");
                getStudents(((Map<String,Object>) dataSnapshot.getValue()));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e(TAG, "Failed to read values.");
            }
        });

        readallProfs();
    }

    public void readallProfs(){
        allProfs = new ArrayList<Prof>();
        // Read from the database
        dbRefProf.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.w(TAG, "getting all profs");
                getProfsArrayList((ArrayList<Object>) dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read values.");
            }
        });

        readAllCourses();
    }

    public void readAllPosts(){

        allPosts = new ArrayList<Post>();
        // Read from the database
        dbRefPosts.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.w(TAG, "getting all posts");
                getPosts(((Map<String,Object>) dataSnapshot.getValue()));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e(TAG, "Failed to read values.");
            }
        });
        setAverageRatingPerProf();

    }

    public void readAllCourses(){

        allCourses = new ArrayList<Course>();
        // Read from the database
        dbRefPosts.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.w(TAG, "getting all courses");
                getCourses(((Map<String,Object>) dataSnapshot.getValue()));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e(TAG, "Failed to read values.");
            }
        });

        readAllPosts();
    }

    private void getStudents(Map<String, Object> students){
        for (Map.Entry<String, Object> entry : students.entrySet()) {

            Student tempStudent = new Student();
            Map student = (Map) entry.getValue();

            tempStudent.setCollege(String.valueOf(student.get("college")));
            tempStudent.setCourse(String.valueOf(student.get("course")));
            tempStudent.setEmail(String.valueOf(student.get("email")));
            tempStudent.setFirst_name(String.valueOf(student.get("first_name")));
            tempStudent.setLast_name(String.valueOf(student.get("last_name")));
            tempStudent.setPassword(String.valueOf(student.get("password")));
            tempStudent.setStudent_id(allStudents.size()+1);

//            Log.i(TAG, tempStudent.toString());
            allStudents.add(tempStudent);
        }
    }

    public Student getStudentByID(int id){
        Student tempStudent = new Student();
        Log.w(TAG, "LOOKING FOR STUDENT");

        for(int i = 0; i < allStudents.size(); i++){
            if(allStudents.get(i).getStudent_id() == id) {
                Log.v(TAG, "found student");
                tempStudent = allStudents.get(i);
            }
        }

        return tempStudent;
    }

    private void getProfsArrayList(ArrayList<Object> profs){
        for(int i = 0; i < profs.size(); i++)
            getProfs((Map<String, Object>)profs.get(i));
    }

    private void getProfs(Map<String, Object> prof){
            Prof tempProf = new Prof();

            tempProf.setFirst_name(String.valueOf(prof.get("first_name")));
            tempProf.setLast_name(String.valueOf(prof.get("last_name")));
            tempProf.setDepartment(String.valueOf(prof.get("department")));
            tempProf.setTitle(String.valueOf(prof.get("title")));
            tempProf.setProf_id(allProfs.size());

            Prof.total_profs++;
            allProfs.add(tempProf);
    }

    private void getCourses(Map<String, Object> courses){
        for (Map.Entry<String, Object> entry : courses.entrySet()) {
            Course tempCourse = new Course();
            Map course = (Map) entry.getValue();

            tempCourse.setCourse_code(String.valueOf(course.get("course_code")));
            tempCourse.setCourse_name(String.valueOf(course.get("course_name")));

            allCourses.add(tempCourse);
        }
    }

    public Course getCourseByCourseCode(final String course_code){
        final Course tempCourse = new Course();
        for(int i = 0; i < allPosts.size(); i++){
            dbRefCourses.child(i+"").addValueEventListener (new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    Course temp  = snapshot.getValue(Course.class);
                    if(temp.getCourse_code().equals(course_code)) {
                        tempCourse.setCourse_code(temp.getCourse_code());
                        tempCourse.setCourse_name(temp.getCourse_name());
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.e(TAG, "failled to look for " + course_code);
                }
            });
        }
        return tempCourse;
    }

    public ArrayList<Prof> searchProfByLastName(String last_name){
        ArrayList<Prof> ProfList = new ArrayList<Prof>();

        Log.i(TAG, "SEARCHING");

        for(int i = 0; i < allProfs.size(); i++){
            if(allProfs.get(i).getLast_name().equalsIgnoreCase(last_name)) {
                ProfList.add(allProfs.get(i));
            }
        }

        return ProfList;
    }

    public ArrayList<Prof> searchProfByDepartment(String last_name){
        ArrayList<Prof> ProfList = new ArrayList<Prof>();

        for(int i = 0; i < allProfs.size(); i++){
            if(allProfs.get(i).getLast_name().equalsIgnoreCase(last_name)) {
                ProfList.add(allProfs.get(i));
            }
        }

        return ProfList;
    }

    public Prof searchProfByID(int id){
        Prof tempProf = new Prof();

        for(int i = 0; i < allProfs.size(); i++){
            if(allProfs.get(i).getProf_id() == id)
                tempProf = allProfs.get(i);
        }

        return tempProf;
    }

    public void setAverageRatingPerProf() {
        ArrayList<Post> postsPerProf = new ArrayList<Post>();
        int foundProfID = 0;
        double sum = 0;

        for(int i = 0; i < allPosts.size(); i++){
            for(int j = 0; j < allProfs.size(); j++){
                if(allPosts.get(i).getProf_id() == allProfs.get(j).getProf_id()){
                    foundProfID = allProfs.get(j).getProf_id();
                    postsPerProf.add(allPosts.get(i));
                }
            }

            for(int j = 0; j < postsPerProf.size(); j++)
                 sum += postsPerProf.get(j).getRating();

            allProfs.get(foundProfID).setRating(sum/postsPerProf.size());
            allProfs.get(foundProfID).setNum_reviews(postsPerProf.size());
        }
    }

    private void getPosts(Map<String, Object> posts){
        for (Map.Entry<String, Object> entry : posts.entrySet()) {
            Post tempPosts = new Post();
            Map post = (Map) entry.getValue();
            Student tempStudent = getStudentByID(tempPosts.getUser_id());
            Prof tempProf = searchProfByID(tempPosts.getProf_id());

            tempPosts.setProf_id(Integer.parseInt(String.valueOf(post.get("prof_id"))));
            tempPosts.setUser_id(Integer.parseInt(String.valueOf(post.get("user_id"))));
            tempPosts.setUser_name(tempStudent.getFirst_name() + " " + tempStudent.getLast_name());
            tempPosts.setProf_name(tempProf.getLast_name() + " " + tempProf.getFirst_name());
            tempPosts.setReview(String.valueOf(post.get("review")));
            tempPosts.setRating(Integer.parseInt(String.valueOf(post.get("rating"))));
            tempPosts.setUpvotes(Integer.parseInt(String.valueOf(post.get("upvotes"))));
            tempPosts.setDownvotes(Integer.parseInt(String.valueOf(post.get("downvotes"))));
//            tempPosts.setCourse(String.valueOf(post.get("course")));
            allPosts.add(tempPosts);

            Log.i(TAG, tempStudent.getFirst_name() + " " + tempStudent.getLast_name());
            Log.i(TAG, tempProf.getLast_name() + " " + tempProf.getFirst_name());
        }
    }

    public ArrayList<Student> getAllStudents() {
        return allStudents;
    }

    public ArrayList<Prof> getallProfs() {
        return allProfs;
    }

    public ArrayList<Post> getAllPosts() {
        return allPosts;
    }

    public void printAllData(){
        Log.i(TAG, "ALL COURSES: ");
        for (int i = 0; i < allCourses.size(); i++){
            Log.i(TAG, allCourses.get(i).toString());;
        }

        Log.i(TAG, "ALL PROFS: ");
        for (int i = 0; i < allProfs.size(); i++){
            Log.i(TAG, allProfs.get(i).toString());
        }

        Log.i(TAG, "ALL POSTS: ");
        for (int i = 0; i < allPosts.size(); i++){
            Log.i(TAG, allPosts.get(i).toString());
        }

        Log.i(TAG, "ALL STUDENTS: ");
        for (int i = 0; i < allPosts.size(); i++){
            Log.i(TAG, allStudents.get(i).toString());
        }
    }
}
