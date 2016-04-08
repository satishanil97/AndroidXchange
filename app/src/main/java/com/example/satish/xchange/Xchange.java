package com.example.satish.xchange;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Xchange extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xchange);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_xchange, menu);
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


    public void lend(View view)
    {
        Intent intent1 = new Intent(this,Lend.class);
        startActivity(intent1);
    }

    public void borrow(View view)
    {
        Intent intent2 = new Intent(this,Borrow.class);
        startActivity(intent2);
    }

    public void retrieve(View view)
    {
        Intent intent3 = new Intent(this,Retrieve.class);
        startActivity(intent3);
    }

    public void returnB(View view)
    {
        Intent intent4 = new Intent(this,ReturnB.class);
        startActivity(intent4);
    }

   public void lended(View view)
    {
        Intent intent5 = new Intent(this,Lended.class);
        startActivity(intent5);
    }

    public void borrowed(View view)
    {
        Intent intent5 = new Intent(this,Borrowed.class);
        startActivity(intent5);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();  // Always call the superclass

        // Stop method tracing that the activity started during onCreate()
        android.os.Debug.stopMethodTracing();
    }
}
