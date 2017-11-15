package edu.dlsu.mobapde.quatro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Created by Asus on 11/15/2017.
 */

public class PostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

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
                    break;
                case R.id.navigation_prof_list:
                    break;
                case R.id.navigation_me:
                    Intent i2 = new Intent(getBaseContext(),ProfileActivity.class);
                    startActivity(i2);
                    finish();
                    break;
            }
            return false;
        }

    };
}
