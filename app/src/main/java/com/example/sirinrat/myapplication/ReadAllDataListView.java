package com.example.sirinrat.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class ReadAllDataListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_all_data_list_view);
        createListView();

    }   // Main Method

    private void createListView() {

        SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase(MyOpenHelper.DATABASE_NAME,
                MODE_PRIVATE, null);
        Cursor objCursor = objSqLiteDatabase.rawQuery("SELECT * FROM todoTABLE", null);
        objCursor.moveToFirst();
        String[] dateStrings = new String[objCursor.getCount()];
        String[] todoStrings = new String[objCursor.getCount()];
        for (int i=0; i<objCursor.getCount();i++) {
            dateStrings[i] = objCursor.getString(objCursor.getColumnIndex(ManageTABLE.DATABASE_Date));
            todoStrings[i] = objCursor.getString(objCursor.getColumnIndex(ManageTABLE.DATABASE_ToDo));
            objCursor.moveToNext();
        }   // for
        objCursor.close();

        ToDoAdapter objToDoAdapter = new ToDoAdapter(ReadAllDataListView.this, dateStrings, todoStrings);
        ListView objListView = (ListView) findViewById(R.id.listView2);
        objListView.setAdapter(objToDoAdapter);

    }   // createListView

    public void clickBackToDo(View view) {
        finish();
    }

}   // Main Class
