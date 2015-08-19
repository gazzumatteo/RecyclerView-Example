package com.duckma.example.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent = new Intent(this, RecyclerActivity.class);

        findViewById(R.id.btn_horizontal_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(RecyclerActivity.EXTRA_FLAG, RecyclerActivity.FLAG_HORIZONTAL);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_vertical_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(RecyclerActivity.EXTRA_FLAG, RecyclerActivity.FLAG_VERTICAL);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_grid_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(RecyclerActivity.EXTRA_FLAG, RecyclerActivity.FLAG_GRID);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_staggered_grid_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(RecyclerActivity.EXTRA_FLAG, RecyclerActivity.FLAG_STAGGERED_GRID);
                startActivity(intent);
            }
        });

    }
}
