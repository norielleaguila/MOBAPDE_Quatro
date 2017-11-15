package edu.dlsu.mobapde.quatro;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

        et = (EditText) findViewById(R.id.account_edit);
        final String passedData = getIntent().getExtras().getString("passed");
        if (passedData!="college" || passedData!="course")
            et.setText(passedData);
        submitButton = (Button)findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                setResult(RESULT_OK, new Intent().putExtra("passedData", et.getText().toString()));
                finish();
            }
        });
    }
}
