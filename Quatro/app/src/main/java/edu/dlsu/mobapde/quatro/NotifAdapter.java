package edu.dlsu.mobapde.quatro;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class NotifAdapter extends RecyclerView.Adapter<NotifAdapter.NotifHolder> {

    private ArrayList<Notif> notifs;
    private View v;

    public NotifAdapter(ArrayList<Notif> notifs){this.notifs = notifs;}

    @Override
    public NotifHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_notif, parent, false);

            return new NotifHolder(v);
    }

    @Override
    public void onBindViewHolder(final NotifHolder holder, final int position){
        Notif curr = notifs.get(position);

        holder.user.setText(curr.getUser());
        holder.action.setText(curr.getAction());
        holder.post.setText(curr.getPost());

        holder.post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Notif n = notifs.get(position);
                n.setRead(true);

                // intent go to your individual post that got upvoted/downvoted
                Intent i = new Intent();
            }
        });
    }

    @Override
    public int getItemCount() {
        return notifs.size();
    }

    public class NotifHolder extends RecyclerView.ViewHolder{

        TextView user;
        TextView action;
        TextView post;
        TextView tag;

        public NotifHolder(View view){
            super(view);

            user = view.findViewById(R.id.notif_user);
            action = view.findViewById(R.id.notif_action);
            post = view.findViewById(R.id.notif_post);
            tag = view.findViewById(R.id.notif_read);

        }

    }
}
