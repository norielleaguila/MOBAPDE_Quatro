package edu.dlsu.mobapde.quatro;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class NavigationActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private RecyclerView rv;
    private ArrayList<Post> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mTextMessage = (TextView) findViewById(R.id.message);
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
                    mTextMessage.setText(R.string.title_prof_list);
                    return true;
                case R.id.navigation_me:
                    mTextMessage.setText(R.string.title_me);
                    return true;
            }
            return false;
        }

    };

    private void initList(){
        posts = new ArrayList<>();

        posts.add(new Rating(R.mipmap.ic_launcher, "Jasper Pillejera", "Remedios de Dios Bulos", "ST-STAT", 3.0, 53, 2, 3.0f));
        posts.add(new Review(R.mipmap.ic_launcher, "Jasper Pillejera", "Remedios de Dios Bulos", "OPERSYS", 3.0, 41, 8,
                "Nwala ko notes ko sa class nya pero ok lg kasi kumpleto slides"));
        posts.add(new Rating(R.mipmap.ic_launcher, "Jasper Pillejera", "Remedios de Dios Bulos", "ST-STAT", 3.0, 53, 2, 3.0f));
        posts.add(new Rating(R.mipmap.ic_launcher, "Jasper Pillejera", "Remedios de Dios Bulos", "ST-STAT", 3.0, 53, 2, 3.0f));
    }

}
