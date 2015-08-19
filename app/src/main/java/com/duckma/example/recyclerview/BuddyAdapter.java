package com.duckma.example.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Copyright © 2015 DuckMa S.r.l. - http://duckma.com
 * <p/>
 * Created by Matteo Gazzurelli on 19/08/15.
 */
public class BuddyAdapter extends RecyclerView.Adapter<BuddyAdapter.BuddyViewHolder> {
    List<Buddy> mBuddies;

    BuddyAdapter(List<Buddy> buddies) {
        mBuddies = buddies;
    }

    @Override
    public int getItemCount() {
        return mBuddies.size();
    }

    @Override
    public BuddyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.buddy, viewGroup, false);
        BuddyViewHolder bvh = new BuddyViewHolder(v);
        return bvh;
    }

    @Override
    public void onBindViewHolder(BuddyViewHolder buddyViewHolder, int i) {
        buddyViewHolder.buddyName.setText(mBuddies.get(i).name);
        buddyViewHolder.buddySurname.setText(mBuddies.get(i).surname);
        buddyViewHolder.buddyIcon.setImageResource(mBuddies.get(i).icon);
    }

    public static class BuddyViewHolder extends RecyclerView.ViewHolder {
        TextView buddyName;
        TextView buddySurname;
        ImageView buddyIcon;

        BuddyViewHolder(View itemView) {
            super(itemView);
            buddyName = (TextView) itemView.findViewById(R.id.tvBuddyName);
            buddySurname = (TextView) itemView.findViewById(R.id.tvBuddySurname);
            buddyIcon = (ImageView) itemView.findViewById(R.id.ivBuddyIcon);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
