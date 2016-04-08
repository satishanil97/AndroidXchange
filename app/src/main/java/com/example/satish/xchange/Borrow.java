package com.example.satish.xchange;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class Borrow extends AppCompatActivity {
    String item_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrow);

        Intent intent = getIntent();

        EditText editText1 = (EditText) findViewById(R.id.et1_borrow);
        String name = editText1.getText().toString().toLowerCase();

        EditText editText2 = (EditText) findViewById(R.id.et2_borrow);
        String item = editText2.getText().toString().toLowerCase();
    }

    public void onRadioButtonClicked_borrow(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.rb1_borrow:
                if (checked) {
                    item_type= "book";
                    return;
                }
                break;

            case R.id.rb2_borrow:
                if (checked) {
                    item_type = "gadget";
                    return;
                }
                break;

            case R.id.rb3_borrow:
                if (checked) {
                    item_type = "stationery";
                    return;
                }
                break;

            case R.id.rb4_borrow:
                if (checked) {
                    item_type = "others";
                    return;
                }
                break;

            default:
                item_type = "invalid";
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_borrow, menu);
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
