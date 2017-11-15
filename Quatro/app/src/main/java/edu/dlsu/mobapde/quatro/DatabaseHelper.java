package edu.dlsu.mobapde.quatro;

import android.app.PendingIntent;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Janella on 14/11/2017.
 */

public class DatabaseHelper {

    private FirebaseDatabase database;
    private DatabaseReference dbRefStudents;
    private DatabaseReference dbRefFaculty;
    private DatabaseReference dbRefReviews;

    private ArrayList<Student> allStudents;
    private ArrayList<Faculty> allFaculty;
    private ArrayList<Review> allReviews;

    public boolean connectToDatabase(){

        // Connect to DB
        database = FirebaseDatabase.getInstance();
        dbRefStudents = database.getReference().child("students");
        dbRefFaculty = database.getReference().child("faculty");
        dbRefReviews = database.getReference().child("reviews");

        System.out.println("dbRefFaculty: " + dbRefFaculty.toString());
        System.out.println("dbRefStudents: " + dbRefStudents.toString());
        System.out.println("dbRefReviews: " + dbRefReviews.toString());

        if(database != null)
            return true;
        else
            return false;
    }

    public void readAllStudents(){

//        System.out.println("wtf?");
        allStudents = new ArrayList<Student>();
        // Read from the database
        dbRefStudents.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Object temp = dataSnapshot.getValue();
                ArrayList<Object> tempArrayList = (ArrayList<Object>) temp;

                for (int i = 0; i < tempArrayList.size(); i++){
                    getStudent((Map<String, Object>)tempArrayList.get(i));
                }
//                printAllStudents();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                System.out.println("Failed to read values.");
            }
        });
    }

    public void readAllFaculty(){
        System.out.println("READING ALL FACULTY DATA FROM DB");
        allFaculty = new ArrayList<Faculty>();
        // Read from the database
        dbRefFaculty.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Object temp = dataSnapshot.getValue();
                System.out.print(temp.toString());
                ArrayList<Object> tempArrayList = (ArrayList<Object>) temp;

                for (int i = 0; i < tempArrayList.size(); i++){
                    getFaculty((Map<String, Object>)tempArrayList.get(i));
                }

                System.out.println("RETRIEVED DATA FROM DB");
                printAllFaculty();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                System.out.println("Failed to read values.");
            }
        });
    }

    public void readAllReviews(){

//        System.out.println("wtf?");
        allReviews = new ArrayList<Review>();
        // Read from the database
        dbRefReviews.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Object temp = dataSnapshot.getValue();
                ArrayList<Object> tempArrayList = (ArrayList<Object>) temp;

                for (int i = 0; i < tempArrayList.size(); i++){
                    getReview((Map<String, Object>)tempArrayList.get(i));
                }
//                printAllStudents();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                System.out.println("Failed to read values.");
            }
        });
    }
    private void getStudent(Map<String, Object> student){
        Student tempStudent = new Student();

        tempStudent.setCollege(String.valueOf(student.get("college")));
        tempStudent.setCourse(String.valueOf(student.get("course")));
        tempStudent.setEmail(String.valueOf(student.get("email")));
        tempStudent.setFirst_name(String.valueOf(student.get("first_name")));
        tempStudent.setLast_name(String.valueOf(student.get("last_name")));
        tempStudent.setPassword(String.valueOf(student.get("password")));
        tempStudent.setStudent_id(allStudents.size());

        allStudents.add(tempStudent);
    }

    private void printAllStudents(){
        for (int i = 0; i < allStudents.size(); i++){
            System.out.println(allStudents.get(i).toString());
        }
    }

    private void getFaculty(Map<String, Object> faculty){
        Faculty tempFaculty = new Faculty();

        System.out.println("GET FACULTY: " + faculty.toString() );

        tempFaculty.setFirst_name(String.valueOf(faculty.get("first_name")));
        tempFaculty.setLast_name(String.valueOf(faculty.get("last_name")));
        tempFaculty.setDepartment(String.valueOf(faculty.get("department")));
        tempFaculty.setTitle(String.valueOf(faculty.get("title")));
        tempFaculty.setFaculty_id(allFaculty.size());

        allFaculty.add(tempFaculty);
    }

    private void printAllFaculty(){
        for(int i = 0; i < 10; i++){
            System.out.println(allFaculty.get(i).toString());
        }
    }

    public ArrayList<Faculty> searchFacultyByLastName(String last_name){
        ArrayList<Faculty> facultyList = new ArrayList<Faculty>();

        System.out.println("SEARCHING");

        for(int i = 0; i < allFaculty.size(); i++){
            if(allFaculty.get(i).getLast_name().equalsIgnoreCase(last_name)) {
                facultyList.add(allFaculty.get(i));
            }
        }

        return facultyList;
    }

    private void getReview(Map<String, Object> review){
        System.out.println("REVIEW: " + review.toString());
        Review tempReview = new Review();

        tempReview.setFaculty_id(Integer.parseInt(String.valueOf(review.get("faculty_id"))));
        tempReview.setStudent_id(Integer.parseInt(String.valueOf(review.get("student_id"))));
        tempReview.setReview(String.valueOf(review.get("review")));
        tempReview.setRating(Integer.parseInt(String.valueOf(review.get("rating"))));
        tempReview.setUpvotes(Integer.parseInt(String.valueOf(review.get("upvotes"))));
        tempReview.setDownvotes(Integer.parseInt(String.valueOf(review.get("downvotes"))));
        tempReview.setSubject(String.valueOf(review.get("subject")));
        tempReview.setReview_id(allReviews.size());

        allReviews.add(tempReview);
    }

    public void printAllReviews(){
        for (int i = 0; i < allReviews.size(); i++){
            System.out.println(allReviews.get(i).toString());
        }
    }

    public ArrayList<Student> getAllStudents() {
        return allStudents;
    }

    public ArrayList<Faculty> getAllFaculty() {
        return allFaculty;
    }

    public ArrayList<Review> getAllReviews() {
        return allReviews;
    }
}
