package com.example.sjoerd.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        JournalEntry retrievedEntry = (JournalEntry) intent.getSerializableExtra("entry");

        // get all views
        TextView title = findViewById(R.id.titleDetail);
        TextView timestamp = findViewById(R.id.timestampDetail);
        TextView entryText = findViewById(R.id.entryDetail);
        ImageView moodImage = findViewById(R.id.moodDetail);

        // set all views
        try {
//            title.setText(retrievedEntry.getTitle());
//            timestamp.setText(retrievedEntry.getTimestamp().toString());
//            entryText.setText(retrievedEntry.getContent());
//            Mood mood = retrievedEntry.getMood();
//            moodImage.setImageResource(mood.getMoodImage());

            title.setText("Hello");
            timestamp.setText("2018:12:12 12:51:03:422");
            entryText.setText("Hello");
            Mood mood = Mood.HAPPY;
            moodImage.setImageResource(mood.getMoodImage());
        }
        catch (Exception e) {
            Log.e("error", "could not load content");
        }
    }
}
