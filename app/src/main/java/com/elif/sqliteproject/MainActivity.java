package com.elif.sqliteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            SQLiteDatabase database=this.openOrCreateDatabase("painters",MODE_PRIVATE,null);
            database.execSQL("CREATE TABLE IF NOT EXISTS painters(name VARCHAR,picture VARCHAR)");
            //database.execSQL("INSERT INTO painters (name,picture) VALUES('Leonardo Da Vinci', 'Mona Lisa')");
            database.execSQL("INSERT INTO painters (name,picture) VALUES('Johannes Vermeer', 'İnci Küpeli Kız')");
            Cursor cursor = database.rawQuery("SELECT * FROM painters",null);

            int nameIx =cursor.getColumnIndex("name");
            int pictureIx=cursor.getColumnIndex("picture");
            while (cursor.moveToNext())
            {
                System.out.println("Name : "+cursor.getString(nameIx));
                System.out.println("Picture : "+cursor.getString(pictureIx));
            }cursor.close();
        } catch (Exception e){
            e.printStackTrace();
        }



    }
}