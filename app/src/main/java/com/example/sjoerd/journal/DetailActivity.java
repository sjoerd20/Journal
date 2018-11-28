package com.example.sjoerd.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        TextView title = findViewById(R.id.titleJournalTextView);
        TextView timestamp = findViewById(R.id.timestampJournalTextView);
        TextView entryText = findViewById(R.id.entryJournalTextView);
        ImageView moodImage = findViewById(R.id.moodJournalImageView);
//
//        // set all views
//        title.setText(retrievedEntry.getTitle());
//        timestamp.setText(retrievedEntry.getTimestamp().toString());
//        entryText.setText(retrievedEntry.getContent());
//        Mood mood = retrievedEntry.getMood();
//        moodImage.setImageResource(mood.getMoodImage());
    }
}
