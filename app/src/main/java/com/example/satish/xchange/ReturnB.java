package com.example.satish.xchange;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class ReturnB extends AppCompatActivity {

    String item_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return_b);

        Intent intent = getIntent();

        EditText editText1 = (EditText) findViewById(R.id.et1_return);
        String name = editText1.getText().toString().toLowerCase();

        EditText editText2 = (EditText) findViewById(R.id.et2_return);
        String item = editText2.getText().toString().toLowerCase();
    }

    public void onRadioButtonClick_returnB(View view)
    {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.rb1_return:
                if (checked) {
                    item_type= "book";
                    return;
                }
                break;

            case R.id.rb2_return:
                if (checked) {
                    item_type = "gadget";
                    return;
                }
                break;

            case R.id.rb3_return:
                if (checked) {
                    item_type = "stationery";
                    return;
                }
                break;

            case R.id.rb4_return:
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
        getMenuInflater().inflate(R.menu.menu_return_b, menu);
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
