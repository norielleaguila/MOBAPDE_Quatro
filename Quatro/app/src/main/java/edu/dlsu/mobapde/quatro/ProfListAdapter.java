package edu.dlsu.mobapde.quatro;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Norielle on 11/14/2017.
 */

public class ProfListAdapter extends RecyclerView.Adapter<ProfListAdapter.ProfHolder>{

    ArrayList<Prof> profList;

    public ProfListAdapter(ArrayList<Prof> profList){ this.profList = profList; }

    @Override
    public ProfHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProfHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.prof_card, parent, false));
    }

    @Override
    public void onBindViewHolder(ProfHolder holder, int position) {
        final Prof curr = profList.get(position);

        holder.card_profName.setText(curr.getLast_name() + ", " + curr.getFirst_name());
        holder.card_profDept.setText(curr.getDepartment());
        holder.card_profRating.setRating((float)curr.getRating());
//        holder.card_coursesTaught.setText(curr.getCoursesForDisplay());
        holder.card_avgGrade.setText(curr.getAvg_grade() + "");
        holder.card_numReviews.setText(curr.getNum_reviews() + "");

        holder.itemView.setTag(curr);

        holder.viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mOnItemClickListener != null){
                    mOnItemClickListener.onItemClick(0, curr);
                }
            }
        });

        holder.reviewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mOnItemClickListener != null){
                    mOnItemClickListener.onItemClick(1, curr);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return profList.size();
    }

    public class ProfHolder extends RecyclerView.ViewHolder{
        RelativeLayout profCardContainer;
        TextView viewBtn;
        TextView reviewBtn;
        TextView card_profName;
        TextView card_profDept;
        TextView card_numReviews;
        RatingBar card_profRating;
        TextView card_coursesTaught;
        TextView card_avgGrade;

        ImageView card_profIcon;


        public ProfHolder(View itemView) {
            super(itemView);

            profCardContainer = itemView.findViewById(R.id.profCardContainer);
            viewBtn = itemView.findViewById(R.id.viewBtn);
            reviewBtn = itemView.findViewById(R.id.reviewBtn);
            card_profName = itemView.findViewById(R.id.card_profName);
            card_profDept = itemView.findViewById(R.id.card_profDept);
            card_numReviews = itemView.findViewById(R.id.card_numReviews);
            card_profRating = itemView.findViewById(R.id.card_profRating);
            card_coursesTaught = itemView.findViewById(R.id.card_coursesTaught);
            card_avgGrade = itemView.findViewById(R.id.card_avgGrade);
            card_profIcon = itemView.findViewById(R.id.card_profIcon);

        }
    }

    private OnItemClickListener mOnItemClickListener;

    public void setmOnItemClickListener(OnItemClickListener onItemClickListener){
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        public void onItemClick(int which, Prof prof);
    }

}
