package edu.dlsu.mobapde.quatro;

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

    private ArrayList<Student> allStudents;

    public boolean connectToDatabase(){

        // Connect to DB
        database = FirebaseDatabase.getInstance();
        dbRefStudents = database.getReference().child("students");

        if(database != null)
            return true;
        else
            return false;
    }

    public void readAllStudents(){

        allStudents = new ArrayList<Student>();
        // Read from the database
        dbRefStudents.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               getAllStudents((Map<String,Object>) dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                System.out.println("Failed to read values.");
            }
        });
    }

    private void getAllStudents(Map<String,Object> students) {

        //iterate through each student
        for (Map.Entry<String, Object> entry : students.entrySet()){

            //Get user map
            Map student = (Map) entry.getValue();
            Student tempStudent = new Student();

            tempStudent.setCollege(String.valueOf(student.get("college")));
            tempStudent.setCourse(String.valueOf(student.get("course")));
            tempStudent.setEmail(String.valueOf(student.get("email")));
            tempStudent.setFirst_name(String.valueOf(student.get("first_name")));
            tempStudent.setLast_name(String.valueOf(student.get("last_name")));
            tempStudent.setStudent_id(allStudents.size()+1);

            allStudents.add(tempStudent);
        }

        printAllStudents();
//        return  allStudents;
    }

    private void printAllStudents(){
        for (int i = 0; i < allStudents.size(); i++){
            System.out.println(allStudents.get(i).toString());
        }
    }

    public ArrayList<Student> getAllStudents() {
        return allStudents;
    }
}
