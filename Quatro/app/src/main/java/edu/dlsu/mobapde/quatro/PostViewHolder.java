package edu.dlsu.mobapde.quatro;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Norielle on 12/16/2017.
 */

public class PostViewHolder extends RecyclerView.ViewHolder{
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

    public PostViewHolder(View itemView) {

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
