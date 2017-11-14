package edu.dlsu.mobapde.quatro;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
                i.setClass(getBaseContext(), SecondActivity.class);

                startActivityForResult(i, 1);
            }
        });
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_prof_list:
                    mTextMessage.setText(R.string.title_prof_list);
                    return true;
                case R.id.navigation_me:
                    mTextMessage.setText(R.string.title_me);
                    return true;
            }
            return false;
        }

    };
}
