package edu.dlsu.mobapde.quatro;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class ProfListActivity extends AppCompatActivity {

    private TextView mTextMessage;

    RecyclerView rv;
    ArrayList<Prof> profList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof_list);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        rv = (RecyclerView) findViewById(R.id.profListFeed);

        initList();

        ProfListAdapter pa = new ProfListAdapter(profList);

        pa.setmOnItemClickListener(new ProfListAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(Prof prof){
                // TODO: intent to go to prof page
            }
        });

        rv.setAdapter(pa);
        rv.setLayoutManager(new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL, false));
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    Intent i = new Intent(getBaseContext(),HomeActivity.class);
                    startActivity(i);
                    finish();
                    return true;
                case R.id.navigation_prof_list:
                    mTextMessage.setText(R.string.title_prof_list);

                    return true;
                case R.id.navigation_me:
                    mTextMessage.setText(R.string.title_me);
                    Intent i2 = new Intent(getBaseContext(),ProfileActivity.class);
                    startActivity(i2);
                    finish();
                    return true;
            }
            return false;
        }

    };

    public void initList(){
        profList = new ArrayList<>();

        profList.add(new Prof("Jordan Deja", "ST", 4.5f, 3.0f, 41));
        profList.add(new Prof("Solomon Sy", "ST", 3.0f, 2.0f, 36));
        profList.add(new Prof("Roger Uy", "ST", 5.0f, 2.5f, 62));

    }
}
