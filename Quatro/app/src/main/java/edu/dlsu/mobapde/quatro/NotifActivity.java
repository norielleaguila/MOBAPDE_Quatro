package edu.dlsu.mobapde.quatro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by Asus on 11/15/2017.
 */

public class NotifActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private Switch pushNotifSwitch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mTextMessage = (TextView) findViewById(R.id.message);
        mTextMessage.setText("Notifications");

        pushNotifSwitch = (Switch) findViewById(R.id.notifSwitch);

        pushNotifSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pushNotifSwitch.isChecked()){
                    pushNotifSwitch.setChecked(false);
                }
                else{
                    pushNotifSwitch.setChecked(true);
                }

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
