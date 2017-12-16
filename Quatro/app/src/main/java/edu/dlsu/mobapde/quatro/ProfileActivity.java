package edu.dlsu.mobapde.quatro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Asus on 11/14/2017.
 */

public class ProfileActivity extends AppCompatActivity {
    public final static String KEY_USERNAME = "username";
    public final static String KEY_COURSE = "course";
    public final static String KEY_COLLEGE = "college";

    private TextView mTextMessage;
    private TextView userName, courseTV, collegeTV;
    private Button btnSettings;

    private RecyclerView notifs;

    private ArrayList<Notif> notifList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mTextMessage = (TextView) findViewById(R.id.message);

        userName = (TextView) findViewById(R.id.user_name);
        courseTV = (TextView) findViewById(R.id.user_course);
        collegeTV = (TextView) findViewById(R.id.user_college);

        btnSettings = (Button)findViewById(R.id.button_settings);
        notifs = (RecyclerView) findViewById(R.id.rv_notifs);

        userName.setText("Janella Co");

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        String username = sharedPreferences.getString(KEY_USERNAME, null);
        String course = sharedPreferences.getString(KEY_COURSE, null);
        String college = sharedPreferences.getString(KEY_COLLEGE, null);

        if(username != null)
            userName.setText(username);

        if(course != null)
            courseTV.setText(course);

        if(college != null)
            collegeTV.setText(college);

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();        // Intent = opening new Activity

                i.putExtra("passed", btnSettings.getText());
                i.setClass(getBaseContext(), SettingsActivity.class);

                startActivity(i);
            }
        });

        initList();

        NotifAdapter na = new NotifAdapter(notifList);

        notifs.setAdapter(na);
        notifs.setLayoutManager(new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL, false));

    }

    private void initList(){
        notifList = new ArrayList<>();
        notifList.add(new Notif("Caleb Pensica", "upvoted"));
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
