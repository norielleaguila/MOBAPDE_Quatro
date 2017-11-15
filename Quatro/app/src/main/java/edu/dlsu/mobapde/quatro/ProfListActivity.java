package edu.dlsu.mobapde.quatro;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ProfListActivity extends AppCompatActivity {

    private TextView mTextMessage;

    RecyclerView rv;
    ArrayList<Prof> profList;

    TextView rateBtn;
    TextView reviewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof_list);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        rv = (RecyclerView) findViewById(R.id.profListFeed);

        initList();

        ProfListAdapter pa = new ProfListAdapter(profList);

        pa.setmOnItemClickListener(new ProfListAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(int which, Prof prof){

                switch(which){
                    case 0:
                        RateDialog rateDialog = new RateDialog();

                        rateDialog.setOnUserApprovesListener(new RateDialog.OnUserApprovesListener() {
                            @Override
                            public void onUserApproves(DialogInterface dialog, int which, String course, String grade, float rating) {
                                // TODO create post to add to db
                            }
                        });

                        TextView title = (TextView) findViewById(R.id.rate_title);
                        title.setText("Rate " + prof.getProfName());
                        break;
                    case 1:
                        ReviewDialog reviewDialog = new ReviewDialog();

                        reviewDialog.setOnUserApprovesListener(new ReviewDialog.OnUserApprovesListener() {
                            @Override
                            public void onUserApproves(DialogInterface dialog, int which, String course, String grade, String review) {
                                // TODO create post to add to db
                            }
                        });

                        TextView title2 = (TextView) findViewById(R.id.review_title);
                        title2.setText("Review " + prof.getProfName());
                        break;
                    case 2:
                        Intent i = new Intent(getBaseContext(), ProfPageActivity.class);
                        startActivity(i);
                        finish();
                        break;
                }
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

    public void initList(){
        profList = new ArrayList<>();

        profList.add(new Prof("Jordan Deja", "ST", 4.5f, 3.0f, 41));
        profList.add(new Prof("Solomon Sy", "ST", 3.0f, 2.0f, 36));
        profList.add(new Prof("Roger Uy", "ST", 5.0f, 2.5f, 62));

    }
}
