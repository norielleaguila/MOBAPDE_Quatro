package edu.dlsu.mobapde.quatro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static DatabaseHelper db = new DatabaseHelper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        db.connectToDatabase();
        db.readAllFaculty();
        db.readAllStudents();
        db.readAllReviews();

        Intent i = new Intent(getBaseContext(), HomeActivity.class);
        startActivity(i);
        finish();
    }

    public static DatabaseHelper getDb() {
        return db;
    }
}
