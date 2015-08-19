package com.duckma.example.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {
    public static final String EXTRA_FLAG = "type";
    public static final int FLAG_VERTICAL = 1;
    public static final int FLAG_HORIZONTAL = 2;
    public static final int FLAG_GRID = 3;
    public static final int FLAG_STAGGERED_GRID = 4;


    private ArrayList<Buddy> mBuddies;
    RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        initializeData();

        // set the adapter to the Recycler View
        mAdapter = new BuddyAdapter(mBuddies);
        mRecyclerView.setAdapter(mAdapter);

        // use a linear layout manager or other LayoutManager
        /**
         * for the LinearLayoutManager vertical or horizontal check this:
         * https://developer.android.com/reference/android/support/v7/widget/LinearLayoutManager.html#LinearLayoutManager(android.content.Context, android.util.AttributeSet, int, int)
         *
         */
        int flag = getIntent().getExtras().getInt(EXTRA_FLAG);
        switch (flag) {
            case FLAG_VERTICAL:
                mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
                break;
            case FLAG_HORIZONTAL:
                mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
                break;
            case FLAG_GRID:
                mLayoutManager = new GridLayoutManager(this, 2);
                break;
            case FLAG_STAGGERED_GRID:
                mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                break;
            default:
                mLayoutManager = new LinearLayoutManager(this);
                break;
        }
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    /**
     * This method creates an ArrayList that Buddy objects
     */
    private void initializeData() {
        mBuddies = new ArrayList<>();
        mBuddies.add(new Buddy("Mario", "Rossi", R.drawable.buddy1));
        mBuddies.add(new Buddy("Carlo", "Bianchi", R.drawable.buddy2));
        mBuddies.add(new Buddy("Giuseppe", "Verdi", R.drawable.buddy3));
        mBuddies.add(new Buddy("Mario", "Bianchi", R.drawable.buddy4));
        mBuddies.add(new Buddy("Carlo", "Verdi", R.drawable.buddy1));
        mBuddies.add(new Buddy("Giuseppe", "Rossi", R.drawable.buddy3));
    }
}
