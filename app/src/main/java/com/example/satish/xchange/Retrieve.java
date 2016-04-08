package com.example.satish.xchange;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Retrieve extends AppCompatActivity {

    String item_type;
    DatabaseHelp Xchange_DB;
    Button button_retrieve;

    EditText editText1;
    EditText editText2;

    String name;
    String item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);

        Intent intent = getIntent();

        Xchange_DB = new DatabaseHelp(this);

        editText1 = (EditText) findViewById(R.id.et1_retrieve);

        editText2 = (EditText) findViewById(R.id.et2_retrieve);


        button_retrieve = (Button) findViewById(R.id.retrieve_button);

        Delete();
    }

    public void onRadioButtonClicked_retrieve(View view)
    {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.rb1_retrieve:
                if (checked) {
                    item_type= "book";
                    return;
                }
                break;

            case R.id.rb2_retrieve:
                if (checked) {
                    item_type = "gadget";
                    return;
                }
                break;

            case R.id.rb3_retrieve:
                if (checked) {
                    item_type = "stationery";
                    return;
                }
                break;

            case R.id.rb4_retrieve:
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

    public void Delete()
    {
        button_retrieve.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isDeleted = false;

                        name = editText1.getText().toString();
                        item = editText2.getText().toString().toLowerCase();
                        if(name.equalsIgnoreCase(""))
                            Toast.makeText(Retrieve.this, "name field is empty", Toast.LENGTH_LONG).show();

                        else if(name.equalsIgnoreCase(""))
                            Toast.makeText(Retrieve.this, "item field is empty", Toast.LENGTH_LONG).show();

                        else if(item_type == null)
                            Toast.makeText(Retrieve.this, "type field is empty", Toast.LENGTH_LONG).show();

                        else
                            isDeleted = Xchange_DB.DeleteLended(name, item, item_type);

                        if (isDeleted == true)
                            Toast.makeText(Retrieve.this, "Item Retrieved", Toast.LENGTH_LONG).show();

                        else
                            Toast.makeText(Retrieve.this, "Entry Not Found", Toast.LENGTH_LONG).show();
                    }
                }

        );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_retrieve, menu);
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
