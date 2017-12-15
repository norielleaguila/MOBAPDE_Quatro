package edu.dlsu.mobapde.quatro;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;

public class ProfListActivity extends AppCompatActivity {
    private TextView mTextMessage;

    RecyclerView rv;
    ArrayList<Prof> profList;

    TextView rateBtn;
    TextView reviewBtn;
    ArrayList<Prof> facultyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof_list);
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        rv = (RecyclerView) findViewById(R.id.profListFeed);

        initList();

        final ProfListAdapter pa = new ProfListAdapter(profList);

        pa.setmOnItemClickListener(new ProfListAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(int which, final Prof prof){
                FragmentManager f = getFragmentManager();
                switch(which){
                    case 0:

                        final RateDialog rateDialog = new RateDialog();

                        rateDialog.setOnUserApprovesListener(new RateDialog.OnUserApprovesListener() {
                            @Override
                            public void onUserApproves(DialogInterface dialog, int which, String course, String grade, float rating) {
                                DatabaseHelper db  = MainActivity.getDb();

                                Post temp = new Post();
                                temp.setCourse(course);
                                temp.setGrade(Double.parseDouble(grade));
                                temp.setRating(rating);

                                temp.setProf_name(prof.getLast_name() + ", " + prof.getFirst_name());
                                temp.setProf_id(prof.getProf_id());

                                /* TODO: get logged in user's values (name and user id) */

                                temp.setPost_id(db.getAllPosts().size()+1);

                                db.addPost(temp);
                            }
                        });

                        rateDialog.show(f, "");

//                        TextView title = (TextView) findViewById(R.id.rate_title);
//                        title.setText("Rate " + prof.getProfName());
                        break;
                    case 1:

                        ReviewDialog reviewDialog = new ReviewDialog();

                        reviewDialog.setOnUserApprovesListener(new ReviewDialog.OnUserApprovesListener() {
                            @Override
                            public void onUserApproves(DialogInterface dialog, int which, String course, String grade, String review) {

                                DatabaseHelper db  = MainActivity.getDb();

                                Post temp = new Post();
                                temp.setCourse(course);
                                temp.setGrade(Double.parseDouble(grade));
                                temp.setReview(review);

                                temp.setProf_name(prof.getLast_name() + ", " + prof.getFirst_name());
                                temp.setProf_id(prof.getProf_id());

                                /* TODO: get logged in user's values (name and user id) */

                                temp.setPost_id(db.getAllPosts().size()+1);

                                db.addPost(temp);
                            }
                        });

                        reviewDialog.show(getSupportFragmentManager(), "");


//                        TextView title2 = (TextView) findViewById(R.id.review_title);
//                        title2.setText("Review " + prof.getProfName());
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
//                    mTextMessage.setText(R.string.title_home);
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
        profList = MainActivity.getDb().getallProfs();
    }

}
