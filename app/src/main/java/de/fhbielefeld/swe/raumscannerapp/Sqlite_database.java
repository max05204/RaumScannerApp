package de.fhbielefeld.swe.raumscannerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.text.SimpleDateFormat;
import java.util.UUID;
import androidx.annotation.Nullable;

public class Sqlite_database extends SQLiteOpenHelper {


    public Sqlite_database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    // Wird beim starten der App ausgeführt
    public void onCreate(SQLiteDatabase db) {
        // Query String erstellen
        String query_createRoomTable = "CREATE TABLE tbl_Rooms " +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " roomnumber TEXT," +
                " seat_count INTEGER," +
                " table_count INTEGER," +
                " specials TEXT, " +
                " building TEXT, " +
                " section TEXT," +
                " floor TEXT," +
                " room TEXT," +
                " damage_note TEXT, " +
                " alias TEXT); ";

        // Query für das erstellen der DB ausführen
        db.execSQL(query_createRoomTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long writeNewRoom(Room room){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // Einfügen alles Werte in Values
        values.put("roomnumber", room.getRoomnumber());
        values.put("seat_count", room.getSeat_count());
        values.put("table_count", room.getTable_count());
        values.put("specials", room.getSpecials());
        values.put("building", room.getBuilding());
        values.put("section", room.getSection());
        values.put("floor", room.getFloor());
        values.put("room", room.getRoom());
        values.put("damage_note", room.getDamagenote());
        values.put("alias", room.getAlias());

        long newID = db.insert("tbl_rooms", null, values);

        if(newID == -1){
            return -1;
        }
        else {
            // Als Bestätigung das es geklappt hat...
            return newID;
        }

    }

    public void deleteRoom(UUID id){
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DELETE FROM tbl_Rooms WHERE ID = " + id + "");
    }

    public void deleteRoom(String roomnumber){
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DELETE FROM tbl_Rooms WHERE roomnumber = " + roomnumber + "");
    }

    public boolean updateRoomInfo(Room room, UUID id){
        SQLiteDatabase db = this.getWritableDatabase();

        String query_updateRoom = "UPDATE TABLE tbl_Rooms " +
                " SET " +
                "[roomnumber] ='" + room.getRoomnumber() + "'," +
                "[seat_count] =" + room.getSeat_count() + "," +
                "[table_count] =" + room.getTable_count() + "," +
                "[specials] ='" + room.getSpecials() + "'," +
                "[building] ='" + room.getBuilding() + "'," +
                "[section] ='" + room.getSection() + "'," +
                "[floor] ='" + room.getFloor() + "'," +
                "[room] ='" + room.getRoom() + "'," +
                "[damage_note] ='" + room.getDamagenote() + "'," +
                "[alias] ='" + room.getAlias() + "'," +
                " alias TEXT) "+
                "WHERE ID = " + room.getRoomnumber() + ";";

        db.execSQL(query_updateRoom);

        return false;
    }

    public Cursor getAllRooms(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query_getRoomTable = "SELECT * FROM tbl_rooms";
        Cursor table = db.rawQuery(query_getRoomTable, null);
        return table;
    }
}
