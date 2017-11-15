package edu.dlsu.mobapde.quatro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Asus on 11/14/2017.
 */

public class ProfileActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Button btnAccount, btnNotif, btnSettings, btnPosts;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mTextMessage = (TextView) findViewById(R.id.message);
        btnAccount = (Button)findViewById(R.id.button_account);
        btnNotif = (Button)findViewById(R.id.button_notifs);
        btnSettings = (Button)findViewById(R.id.button_settings);
        btnPosts = (Button)findViewById(R.id.button_posts);

        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();        // Intent = opening new Activity

                i.putExtra("passed", btnAccount.getText());
                i.setClass(getBaseContext(), AccountActivity.class);

                startActivity(i);
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();        // Intent = opening new Activity

                i.putExtra("passed", btnSettings.getText());
                i.setClass(getBaseContext(), SettingsActivity.class);

                startActivity(i);
            }
        });

        btnNotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();        // Intent = opening new Activity

                i.putExtra("passed", btnNotif.getText());
                i.setClass(getBaseContext(), NotifActivity.class);

                startActivity(i);
            }
        });

        btnPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();        // Intent = opening new Activity

                i.putExtra("passed", btnPosts.getText());
                i.setClass(getBaseContext(), PostActivity.class);

                startActivity(i);
            }
        });

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
