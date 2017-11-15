package edu.dlsu.mobapde.quatro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Asus on 11/15/2017.
 */

public class AccountActivity extends AppCompatActivity {

    private TextView course,college;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        course = (TextView)findViewById(R.id.tv_course);
        college = (TextView)findViewById(R.id.tv_college);

        course.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.putExtra("course",course.getText());
                i.setClass(getBaseContext(),EditAccountActivity.class);

                startActivityForResult(i,0);
            }
        });

        college.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.putExtra("college",college.getText());
                i.setClass(getBaseContext(),EditAccountActivity.class);

                startActivityForResult(i,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0 && resultCode == RESULT_OK)
            course.setText(data.getExtras().getString("passedData"));
        if(requestCode == 1 && resultCode == RESULT_OK)
            college.setText(data.getExtras().getString("passedData"));
    }
}
