package com.example.satish.xchange;

import android.app.AlertDialog;
import android.app.LoaderManager;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

public class Lended extends AppCompatActivity  {
    private static final String TAG = Lended.class.getSimpleName();
    private DatabaseHelp XDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lended);

        ArrayList<DataObject> dataList = new ArrayList<DataObject>();
        // Create the adapter to convert the array to views
        LendedAdapter adapter = new LendedAdapter(this, dataList);

       Cursor res = XDB.getAllLended();

        if(res.getCount() == 0)
        {
            showMessage("Error" , "No Data Found\n");
            return;
        }


        while(res.moveToNext())
        {
            if(res.getString(0) == "")
                continue;

            if(res.getString(1) == "")
                continue;

            if(res.getString(2) == null)
                continue;

            DataObject data = new DataObject(res.getString(0) , res.getString(1) , res.getString(2));
            adapter.add(data);
        }

        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.lv1_lended);
        listView.setAdapter(adapter);
    }



    public void showMessage(String title , String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lended, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
