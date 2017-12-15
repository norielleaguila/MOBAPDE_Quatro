package edu.dlsu.mobapde.quatro;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Norielle on 11/14/2017.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {
    private ArrayList<Post> posts;

    public PostAdapter(ArrayList<Post> posts){this.posts = posts;}

    @Override
    public PostHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_rating, parent, false);

        return new PostHolder(v);
    }

    @Override
    public void onBindViewHolder(final PostHolder holder, final int position) {
        Post curr = posts.get(position);
        holder.userName.setText(curr.getUser_name());
        holder.profName.setText(curr.getProf_name());
        holder.course.setText(curr.getCourse());
        holder.grade.setText(curr.getGrade() + "");
        holder.upVotes.setText(curr.getUpvotes() + "");
        holder.downVotes.setText(curr.getDownvotes() + "");

        holder.rtRating.setRating((float)curr.getRating());
        holder.tvReview.setText(curr.getReview());
        holder.itemView.setTag(curr);

        holder.upBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Post p = posts.get(position);
                p.setUpvotes(p.getUpvotes() + 1);
                holder.upVotes.setText(p.getUpvotes() + "");
                MainActivity.getDb().updateVotes(position, p.getDownvotes(), p.getUpvotes());
            }
        });

        holder.downBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Post p = posts.get(position);
                p.setDownvotes(p.getDownvotes() + 1);
                holder.downVotes.setText(p.getDownvotes() + "");
                MainActivity.getDb().updateVotes(position, p.getDownvotes(), p.getUpvotes());
            }
        });

    }

    public void setItems(PostHolder holder, Post curr){
        holder.userName.setText(curr.getUser_name());
//        holder.actionTag.setText(curr.ge());
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
                p.setUpvotes(p.getDownvotes() + 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class PostHolder extends RecyclerView.ViewHolder{
        protected RelativeLayout container;
        protected TextView userName;
        protected TextView actionTag;
        protected TextView profName;
        protected TextView course;
        protected TextView grade;
        protected TextView upVotes;
        protected TextView downVotes;

        protected ImageButton upBtn;
        protected ImageButton downBtn;

        protected RatingBar rtRating;
        protected TextView tvReview;

        public PostHolder(View itemView) {

            super(itemView);
            userName = itemView.findViewById(R.id.userName);
            actionTag = itemView.findViewById(R.id.actionTag);
            profName = itemView.findViewById(R.id.profName);
            course = itemView.findViewById(R.id.courseTaken);
            grade = itemView.findViewById(R.id.grade);
            upVotes = itemView.findViewById(R.id.upVotes);
            downVotes = itemView.findViewById(R.id.downVotes);
            upBtn = itemView.findViewById(R.id.upBtn);
            downBtn = itemView.findViewById(R.id.downBtn);

            rtRating = itemView.findViewById(R.id.ratingBar);
            tvReview = itemView.findViewById(R.id.reviewContent);
        }
    }
}
