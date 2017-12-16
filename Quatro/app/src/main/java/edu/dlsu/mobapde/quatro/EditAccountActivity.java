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
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Asus on 11/14/2017.
 */

public class EditAccountActivity extends AppCompatActivity {

    Button submitButton;
    EditText et;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_edit);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        et = (EditText) findViewById(R.id.account_edit);
        TextView tv = (TextView) findViewById(R.id.edit_greet);

        final String passedData = getIntent().getExtras().getString("passed");
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        if(passedData.equals("course")){
            String course = sharedPreferences.getString(ProfileActivity.KEY_COURSE, null);

            if(course != null)
                et.setText(course);
            else
                et.setHint("Enter COURSE");
        }
        else if(passedData.equals("college")){
            String college = sharedPreferences.getString(ProfileActivity.KEY_COLLEGE, null);

            if(college != null)
                et.setText(college);
            else
                et.setHint("Enter COLLEGE");
        }
        else if(passedData.equals("username")){
            String username = sharedPreferences.getString(MainActivity.KEY_USERNAME, null);
            if(username != null){
                et.setText(username);
                tv.setText("Hello, " + username);
            }
            else{
                tv.setText("Hello, new user!");
                et.setHint("Enter USERNAME");
            }

        }



        submitButton = (Button)findViewById(R.id.submit_button);

        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
            setResult(RESULT_OK);

                SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(getBaseContext()).edit();

                if(passedData.equals("course"))
                    editor.putString(ProfileActivity.KEY_COURSE, et.getText().toString());
                else if(passedData.equals("college"))
                    editor.putString(ProfileActivity.KEY_COLLEGE, et.getText().toString());
                else if(passedData.equals("username"))
                    editor.putString(MainActivity.KEY_USERNAME, et.getText().toString());
                editor.commit();

            finish();
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
