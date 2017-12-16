package edu.dlsu.mobapde.quatro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public final static String KEY_USERNAME = "username";
    private Button login;

    public static DatabaseHelper db = new DatabaseHelper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String username = sharedPreferences.getString(KEY_USERNAME, null);


        if(username == null){
            Intent i = new Intent();

            i.putExtra("passed", "username");
            i.setClass(getBaseContext(), EditAccountActivity.class);

            startActivity(i);
        }

        login = (Button)findViewById(R.id.fbLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), HomeActivity.class);
                startActivity(i);
                finish();
            }
        });

        db.connectToDatabase();

    }

    public static DatabaseHelper getDb() {
        return db;
    }
}
