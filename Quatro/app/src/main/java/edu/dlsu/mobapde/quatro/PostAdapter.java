package edu.dlsu.mobapde.quatro;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Norielle on 11/14/2017.
 */

public class PostAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Post> posts;

    public PostAdapter(ArrayList<Post> posts){this.posts = posts;}

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType){
            case 0:
                return new RatingHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_rating, parent, false));
            case 1:
                return new ReviewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_review, parent, false));
        }
        return null;
    }

    @Override
    public int getItemViewType(int position){
        if(posts.get(position) instanceof Rating)
            return 0;
        return 1;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Post curr = posts.get(position);

        switch(holder.getItemViewType()){
            case 0:
                RatingHolder ratingHolder = (RatingHolder) holder;
                ratingHolder.rating.setRating(((Rating) curr).getRating());

                setItems(ratingHolder, curr);

                break;
            case 1:
                ReviewHolder reviewHolder = (ReviewHolder) holder;
                reviewHolder.review.setText(((PostReview) curr).getReview());

                setItems(reviewHolder, curr);

                break;
        }
    }

    public void setItems(PostHolder holder, Post curr){
        holder.userName.setText(curr.getUserName());
        holder.actionTag.setText(curr.getAction());
        holder.profName.setText(curr.getProfName());
        holder.course.setText(curr.getCourse());
        holder.grade.setText(curr.getGrade() + "");
        holder.upVotes.setText(curr.getUpVotes() + "");
        holder.downVotes.setText(curr.getDownVotes() + "");

        holder.itemView.setTag(curr);

        holder.upBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Post p = (Post) view.getTag();
                p.setUpVotes(p.getUpVotes() + 1);
            }
        });

        holder.downBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Post p = (Post) view.getTag();
                p.setUpVotes(p.getDownVotes() + 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public abstract class PostHolder extends RecyclerView.ViewHolder{
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
        }
    }

    public class ReviewHolder extends PostHolder{
        TextView review;

        public ReviewHolder(View itemView){
            super(itemView);

            container = itemView.findViewById(R.id.reviewContainer);

            review = itemView.findViewById(R.id.reviewContent);
        }
    }

    public class RatingHolder extends PostHolder{
        RatingBar rating;

        public RatingHolder(View itemView){
            super(itemView);
            container = itemView.findViewById(R.id.ratingContainer);
            rating = itemView.findViewById(R.id.ratingBar);
        }
    }
}
