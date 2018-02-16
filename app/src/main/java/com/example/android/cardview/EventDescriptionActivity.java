package com.example.android.cardview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.widget.ImageView;
import static com.example.android.cardview.R.id.toolbar;

/**
 * Created by RimjhimBhadani on 07-01-2018.
 */

public class EventDescriptionActivity extends AppCompatActivity {

    ImageView eventDescriptionBackground;
    Toolbar toolbar;
    int eventNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_description);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        eventDescriptionBackground = (ImageView) findViewById(R.id.event_description_background);
        setSupportActionBar(toolbar);
        eventNumber = getIntent().getIntExtra("event_number",0);
        setUpParticularEvent(eventNumber);
    }

    public void setUpParticularEvent(int event){
        toolbar.setTitle(Utils.events[event]);
        eventDescriptionBackground.setImageResource(Utils.colors[event]);
    }
}
