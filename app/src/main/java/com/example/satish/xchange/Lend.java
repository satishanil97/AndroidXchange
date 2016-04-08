package com.example.satish.xchange;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Lend extends AppCompatActivity {

    DatabaseHelp Xchange_DB;

    EditText editText1;
    EditText editText2;

    String name;
    String item;
    String item_type;

    Button button_lend;
    Button show_button;
    Button update_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lend);

        Xchange_DB = new DatabaseHelp(this);

        Intent intent = getIntent();

        editText1 = (EditText) findViewById(R.id.et1_lend);

        editText2 = (EditText) findViewById(R.id.et2_lend);

        button_lend = (Button) findViewById(R.id.lend_button);
        show_button = (Button) findViewById(R.id.show_button);
        update_button = (Button) findViewById(R.id.update_button);

        AddData();
        viewAll();
        UpdateData();

    }


    public  void UpdateData()
    {
        update_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        name = editText1.getText().toString();
                        item = editText2.getText().toString().toLowerCase();

                     boolean isUpdate = Xchange_DB.updateData(name , item , item_type);

                        if(isUpdate == true)
                            Toast.makeText(Lend.this, "Entry Updated", Toast.LENGTH_LONG).show();

                        else
                            Toast.makeText(Lend.this, "Data not Updated", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void AddData()
    {
        button_lend.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = false;
                        name = editText1.getText().toString();
                        item = editText2.getText().toString().toLowerCase();

                        if(name.equalsIgnoreCase("")) {
                            Toast.makeText(Lend.this, "name field is empty", Toast.LENGTH_LONG).show();
                            return;
                        }

                        else if(name.equalsIgnoreCase("")) {
                            Toast.makeText(Lend.this, "item field is empty", Toast.LENGTH_LONG).show();
                            return;
                        }

                        else if(item_type == null) {
                            Toast.makeText(Lend.this, "type field is empty", Toast.LENGTH_LONG).show();
                            return;
                        }

                        else
                            isInserted = Xchange_DB.insertData(name, item, item_type);

                        if (isInserted == true)
                            Toast.makeText(Lend.this, "Item Successfully Lended", Toast.LENGTH_LONG).show();

                        else
                            Toast.makeText(Lend.this, "Lending Unsuccessful", Toast.LENGTH_LONG).show();
                    }
                }

        );
    }


    public void viewAll()
    {
        show_button.setOnClickListener(
                new  View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Cursor res = Xchange_DB.getAllLended();

                        if(res.getCount() == 0)
                        {
                            showMessage("Error" , "No Data Found\n");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();

                        while(res.moveToNext())
                        {
                            if(res.getString(0) == "")
                                continue;

                            if(res.getString(1) == "")
                                continue;

                            if(res.getString(2) == null)
                                continue;

                            buffer.append("Name : " + res.getString(0) + "\n");
                            buffer.append("Item : " + res.getString(1) + "\n");
                            buffer.append("Type : " + res.getString(2) + "\n\n");
                        }
                        //Show all data
                        showMessage("Data" , buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title , String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void onRadioButtonClicked_lend(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.rb1_lend:
                if (checked) {
                     item_type= "book";
                     return;
                }
                break;

            case R.id.rb2_lend:
                if (checked) {
                    item_type = "gadget";
                    return;
                }
                break;

            case R.id.rb3_lend:
                if (checked) {
                    item_type = "stationery";
                    return;
                }
                break;

            case R.id.rb4_lend:
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
        getMenuInflater().inflate(R.menu.menu_lend, menu);
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

