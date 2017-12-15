package edu.dlsu.mobapde.quatro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private RecyclerView rv;
    private ArrayList<Post> posts;

    private ArrayList<Review> reviewsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mTextMessage = (TextView) findViewById(R.id.message);
        mTextMessage.setText(R.string.title_home);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        rv = (RecyclerView) findViewById(R.id.homeFeed);

        initList();

        PostAdapter pa = new PostAdapter(posts);

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
                    return true;
                case R.id.navigation_prof_list:
//                    mTextMessage.setText(R.string.title_prof_list);

                    Intent i = new Intent(getBaseContext(), ProfListActivity.class);
                    startActivity(i);
                    finish();

                    return true;
                case R.id.navigation_me:
//                    mTextMessage.setText(R.string.title_me);
                    Intent i2 = new Intent(getBaseContext(),ProfileActivity.class);
                    startActivity(i2);
                    finish();
                    return true;
            }
            return false;
        }

    };

    private void initList(){
        posts = new ArrayList<>();
//
//        posts.add(new Rating(R.drawable.ic_profileicon, "Jasper Pillejera", "Remedios de Dios Bulos", "ST-STAT", 3.0, 53, 2, 3.0f));
//        posts.add(new Review(R.drawable.ic_profileicon, "Jasper Pillejera", "Remedios de Dios Bulos", "OPERSYS", 3.0, 41, 8,
//                "Nwala ko notes ko sa class nya pero ok lg kasi kumpleto slides"));
//        posts.add(new Rating(R.drawable.ic_profileicon, "Jasper Pillejera", "Roger Uy", "ARCHORG", 4.0, 63, 7, 5.0f));
//        posts.add(new Review(R.drawable.ic_profileicon, "Jasper Pillejera", "Roger Uy", "ARCHORG", 4.0, 28, 12,
//                "EZ"));
        reviewsList = new ArrayList<Review>();

        DatabaseHelper db = MainActivity.getDb();
        reviewsList = db.getAllReviews();
        ArrayList<Student> userList = db.getAllStudents();
        ArrayList<Faculty> facultyList  = db.getAllFaculty();
        db.printAllReviews();

//        posts.add(new Rating(R.mipmap.ic_launcher, "Jasper Pillejera", "Remedios de Dios Bulos", "ST-STAT", 3.0, 53, 2, 3.0f));
//        posts.add(new PostReview(R.mipmap.ic_launcher, "Jasper Pillejera", "Remedios de Dios Bulos", "OPERSYS", 3.0, 41, 8,
//                "Nwala ko notes ko sa class nya pero ok lg kasi kumpleto slides"));
//        posts.add(new Rating(R.mipmap.ic_launcher, "Jasper Pillejera", "Remedios de Dios Bulos", "ST-STAT", 3.0, 53, 2, 3.0f));
//        posts.add(new Rating(R.mipmap.ic_launcher, "Jasper Pillejera", "Remedios de Dios Bulos", "ST-STAT", 3.0, 53, 2, 3.0f));

        for(int i = 0; i < reviewsList.size(); i++){
            Student student = userList.get(reviewsList.get(i).getStudent_id());
            Faculty faculty = facultyList.get(reviewsList.get(i).getFaculty_id());
            posts.add(new Rating(R.mipmap.ic_launcher, student.getFirst_name()+ " " + student.getLast_name(), faculty.getFirst_name() + " " + faculty.getLast_name(), reviewsList.get(i).getSubject(), reviewsList.get(i).getGrade(), reviewsList.get(i).getUpvotes(), reviewsList.get(i).getDownvotes(), reviewsList.get(i).getRating()));

            posts.add(new PostReview(R.mipmap.ic_launcher, student.getFirst_name()+ " " + student.getLast_name(), faculty.getFirst_name() + " " + faculty.getLast_name(), reviewsList.get(i).getSubject(), reviewsList.get(i).getGrade(), reviewsList.get(i).getUpvotes(), reviewsList.get(i).getDownvotes(), reviewsList.get(i).getReview()));

        }

    }

}
