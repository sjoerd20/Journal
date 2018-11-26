package com.example.sjoerd.journal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class EntryDatabase extends SQLiteOpenHelper {

    private static EntryDatabase instance;

    public static EntryDatabase getInstance(Context context) {
        if (instance == null) {
            instance = new EntryDatabase(context, "myEntries", null, 1);
        }
        return instance;
    }

    // constructor
    private EntryDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table myEntries (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                "title TEXT, content TEXT, mood TEXT, " +
                                "timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP);");

        // add some sample to database
        sqLiteDatabase.execSQL("INSERT INTO myEntries (title, content, mood) VALUES " +
                                "(day_one, Blablabla, happy), " +
                                "(day_two, Blablabla, sad)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + "myEntries");
        onCreate(sqLiteDatabase);
    }
}
