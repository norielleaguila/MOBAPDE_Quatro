package edu.dlsu.mobapde.quatro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Asus on 11/15/2017.
 */

public class SettingsActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private Button editCourse, editCollege, logout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mTextMessage = (TextView) findViewById(R.id.message);
        mTextMessage.setText("Settings");

        editCourse = (Button) findViewById(R.id.button_course);
        editCollege = (Button) findViewById(R.id.button_college);
        logout = (Button) findViewById(R.id.logout);

        editCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();        // Intent = opening new Activity

                i.putExtra("passed", "course");

                i.setClass(getBaseContext(), EditAccountActivity.class);

                startActivity(i);
            }
        });

        editCollege.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();        // Intent = opening new Activity

                i.putExtra("passed", "college");

                i.setClass(getBaseContext(), EditAccountActivity.class);

                startActivity(i);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();

                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                sharedPreferences.edit().clear().commit();

                i.setClass(getBaseContext(), MainActivity.class);

                startActivity(i);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0 && resultCode == RESULT_OK){
            SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(getBaseContext()).edit();
            editor.putString(ProfileActivity.KEY_COURSE, data.getExtras().getString("passedData"));
            editor.commit();
        }
        if(requestCode == 1 && resultCode == RESULT_OK){
            SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(getBaseContext()).edit();
            editor.putString(ProfileActivity.KEY_COLLEGE, data.getExtras().getString("passedData"));
            editor.commit();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent i = new Intent(getBaseContext(),HomeActivity.class);
                    startActivity(i);
                    finish();
                    return true;
                case R.id.navigation_prof_list:
                    Intent i3 = new Intent(getBaseContext(), ProfListActivity.class);
                    startActivity(i3);
                    finish();
                    return true;
                case R.id.navigation_me:
                    Intent i2 = new Intent(getBaseContext(),ProfileActivity.class);
                    startActivity(i2);
                    finish();
                    return true;
            }
            return false;
        }

    };
}
