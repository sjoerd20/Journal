package com.example.sjoerd.journal;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ImageView;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

public class EntryAdapter extends ResourceCursorAdapter {

    public EntryAdapter(Context context, Cursor c) {
        super(context, R.layout.entry_row, c);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        // get all views
        TextView title = view.findViewById(R.id.journalTitleTextView);
        TextView timestamp = view.findViewById(R.id.journalTimestampTextView);
        ImageView moodImage = view.findViewById(R.id.journalMoodImageView);

        // set all views
        title.setText(cursor.getString(cursor.getColumnIndex("title")));
        timestamp.setText(cursor.getString(cursor.getColumnIndex("timestamp")));

        Mood mood = Mood.valueOf(cursor.getString(cursor.getColumnIndex("mood")));
        moodImage.setImageResource(mood.getMoodImage());
    }
}