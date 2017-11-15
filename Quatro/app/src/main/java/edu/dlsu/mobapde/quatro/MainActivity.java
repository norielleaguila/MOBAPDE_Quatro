package edu.dlsu.mobapde.quatro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        Intent i = new Intent(getBaseContext(), NavigationActivity.class);
        startActivity(i);
        finish();
    }
}
