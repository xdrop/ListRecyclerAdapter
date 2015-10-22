/*
    (c) xdrop - 2015
    For license information see LICENSE
*/

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;


public class PostRecyclerAdapter
        extends ListRecyclerAdapter<Post,PostRecyclerAdapter.ViewHolder> {


    public PostRecyclerAdapter() {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                                      .inflate(R.layout.Postitem, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Post post = mDataSet.get(i);
        /* ... */
        viewHolder.setItem(post);

    }

    public static class ViewHolder extends ListRecyclerAdapter.ViewHolder<Post> {

        public ImageButton downvote;

        public ViewHolder(View v) {
            super(v);
            upvote = (ImageButton) v.findViewById(R.id.btnUpVote);
            upvote.setOnClickListener(this);
            AttachedViews attachedViews = getAttachedViews();
            attachedViews.attachView(R.id.btnUpVote, upvote);
        }


    }
}
