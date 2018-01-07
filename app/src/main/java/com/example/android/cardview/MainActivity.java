package com.example.android.cardview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity implements MyAdapter.ListItemClickListener {

    private static final int NUM_LIST_ITEMS = Utils.events.length;
    private MyAdapter mAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        mAdapter = new MyAdapter(NUM_LIST_ITEMS, this);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onListItemClicked(int clickedItemIndex) {
        Intent intent = new Intent(this,EventDescriptionActivity.class);
        intent.putExtra("event_number",clickedItemIndex);
        startActivity(intent);
    }
}
