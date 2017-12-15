package edu.dlsu.mobapde.quatro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private RecyclerView rvPosts;

    private ArrayList<Post> postsList;

    FirebaseRecyclerAdapter<Post, PostViewHolder> postPostViewHolderFirebaseRecyclerAdapter;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mTextMessage = (TextView) findViewById(R.id.message);
        mTextMessage.setText(R.string.title_home);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        rvPosts = (RecyclerView) findViewById(R.id.homeFeed);

        initList();

        databaseReference = FirebaseDatabase.getInstance().getReference();
        final DatabaseReference postDatabaseReference = databaseReference.child("posts");

        postPostViewHolderFirebaseRecyclerAdapter
                = new FirebaseRecyclerAdapter<Post, PostViewHolder>(Post.class, R.layout.post_rating, PostViewHolder.class, MainActivity.getDb().getDbRefPosts()) {

            @Override
            protected void populateViewHolder(PostViewHolder holder, Post curr, int position) {

                holder.userName.setText(curr.getUser_name());
                holder.profName.setText(curr.getProf_name());
                holder.course.setText(curr.getCourse());
                holder.grade.setText(curr.getGrade() + "");
                holder.upVotes.setText(curr.getUpvotes() + "");
                holder.downVotes.setText(curr.getDownvotes() + "");

                holder.itemView.setTag(curr);

                holder.upBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Post p = (Post) view.getTag();
                        p.setUpvotes(p.getUpvotes() + 1);
                    }
                });

                holder.downBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Post p = (Post) view.getTag();
                        p.setDownvotes(p.getDownvotes() + 1);
                    }
                });

            }
        };

        rvPosts.setAdapter(postPostViewHolderFirebaseRecyclerAdapter);
        rvPosts.setLayoutManager(new LinearLayoutManager(getBaseContext()));
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
                    Intent i2 = new Intent(getBaseContext(), ProfileActivity.class);
                    startActivity(i2);
                    finish();
                    return true;
            }
            return false;
        }

    };

    private void initList() {
        DatabaseHelper db = MainActivity.getDb();

        postsList = db.getAllPosts();

    }
}
