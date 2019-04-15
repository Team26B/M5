package com.example.tejasvedantham.spacetrader.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "SpaceTrader.db";
    private static final int DATABASE_VERSION = 1;

    private static final String GAME_TABLE_NAME = "Game";

    private static final String GAME_COLUMN_ID = "_id";
    private static final String GAME_COLUMN_NAME = "game";

    private final String query1 = "CREATE TABLE " + GAME_TABLE_NAME + "(" +
            GAME_COLUMN_ID + " INTEGER PRIMARY KEY," +
            GAME_COLUMN_NAME + " TEXT);";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    public boolean insertGame(Game game) throws IOException {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        byte[] toAdd = toByteArray(game);
        cv.put(GAME_COLUMN_NAME, toAdd);
        db.insert(GAME_TABLE_NAME, null, cv);

        return true;
    }

    public void updateGame(Integer id, Game newGame) throws IOException {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        byte[] toUpdate = toByteArray(newGame);
        cv.put(GAME_COLUMN_NAME, toUpdate);
        db.update(GAME_TABLE_NAME, cv, GAME_COLUMN_ID + " = ? ", new String[]{Integer.toString(id)});

    }

    public Cursor getGameFromDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + GAME_TABLE_NAME, null);
    }

    private static byte[] toByteArray(Game game) throws IOException {
        byte[] bytes;

        try (ByteArrayOutputStream bos = new ByteArrayOutputStream(); ObjectOutput out = new ObjectOutputStream(bos)) {
            out.writeObject(game);
            out.flush();
            bytes = bos.toByteArray();
        }

        return bytes;
    }
}
