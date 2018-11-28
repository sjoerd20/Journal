package com.example.sjoerd.journal;

import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.sql.Timestamp;

public class InputActivity extends AppCompatActivity {

    private Mood moodSelected = Mood.HAPPY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
    }

    public void addEntry(View v) {
        EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());

        // save all user input
        EditText titleText = findViewById(R.id.editTitleText);
        EditText entryText = findViewById(R.id.editEntryText);

        String title = titleText.getText().toString();
        String content = entryText.getText().toString();

        // get current timestamp
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        // instantiate new entry
        JournalEntry entry = new JournalEntry(title, content, moodSelected, timestamp);

        db.insert(entry);

        this.finish();
    }

    public void happyMood(View v) {
        moodSelected = Mood.HAPPY;
    }
    public void inLoveMood(View v) {
        moodSelected = Mood.INLOVE;
    }
    public void angryMood(View v) {
        moodSelected = Mood.ANGRY;
    }
    public void sadMood(View v) {
        moodSelected = Mood.SAD;
    }


}
