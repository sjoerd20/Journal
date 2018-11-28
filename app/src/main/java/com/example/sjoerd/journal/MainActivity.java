package com.example.sjoerd.journal;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set OnItemLongClickListener
        ListView listViewEntry = findViewById(R.id.entryListView);
        listViewEntry.setOnItemLongClickListener(new OnItemLongClickListener());

        updateData();
    }

    // update listview
    @Override
    public void onResume() {
        super.onResume();
        updateData();
    }

    public void updateData() {
        EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());
        Cursor cursor = db.selectAll();

        ListView listViewEntry = findViewById(R.id.entryListView);
        EntryAdapter entryAdapter = new EntryAdapter(getApplicationContext(), cursor);
        listViewEntry.setAdapter(entryAdapter);
    }


    public void floatingActionButtonClicked(View v) {
        Intent intent = new Intent(MainActivity.this, InputActivity.class);
        startActivity(intent);
    }

    private class OnItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            // TODO implement listener
        }
    }

    private class OnItemLongClickListener implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
            Cursor cursor = (Cursor) adapterView.getItemAtPosition(i);
            long id = cursor.getLong(cursor.getColumnIndex("_id"));
            EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());
            db.deleteEntry(id);
            updateData();
            return true;
        }
    }
}
