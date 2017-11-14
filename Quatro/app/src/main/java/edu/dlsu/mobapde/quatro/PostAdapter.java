package edu.dlsu.mobapde.quatro;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Norielle on 11/14/2017.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {

    @Override
    public PostHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(PostHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PostHolder extends RecyclerView.ViewHolder{

        public PostHolder(View itemView) {
            super(itemView);
        }
    }
}
