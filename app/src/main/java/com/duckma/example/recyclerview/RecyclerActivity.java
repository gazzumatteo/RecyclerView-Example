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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        //If you are sure that the size of the RecyclerView won't be changing,
        // you can add the following line to improve performance
        mRecyclerView.setHasFixedSize(true);

        initializeData();

        // set the adapter to the Recycler View
        BuddyAdapter adapter = new BuddyAdapter(mBuddies);
        mRecyclerView.setAdapter(adapter);

        //Set the layout manager
        /**
         * for the linear layout vertical or horizontal check this:
         * https://developer.android.com/reference/android/support/v7/widget/LinearLayoutManager.html#LinearLayoutManager(android.content.Context, android.util.AttributeSet, int, int)
         *
         */
        int flag = getIntent().getExtras().getInt(EXTRA_FLAG);
        switch (flag) {
            case FLAG_VERTICAL:

                LinearLayoutManager llmv = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
                mRecyclerView.setLayoutManager(llmv);
                break;
            case FLAG_HORIZONTAL:
                LinearLayoutManager llmh = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
                mRecyclerView.setLayoutManager(llmh);
                break;
            case FLAG_GRID:
                GridLayoutManager glm = new GridLayoutManager(this, 2);
                mRecyclerView.setLayoutManager(glm);
                break;
            case FLAG_STAGGERED_GRID:
                StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                mRecyclerView.setLayoutManager(sglm);
                break;


        }


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
