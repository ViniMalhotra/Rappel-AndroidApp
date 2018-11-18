package com.example.vini2.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.database.Cursor;
import java.lang.StringBuilder;


public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb, dbView;
    EditText editName, editSurname, editMarks, viniInput;
    Button btnAddData;
    Button btnViewAll;
    TextView dbInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);
        editName = (EditText) findViewById(R.id.editText_name);
        editSurname = (EditText) findViewById(R.id.editText_surname);
        editMarks = (EditText) findViewById(R.id.editText_marks);
        btnAddData = (Button) findViewById(R.id.button_add);
        btnViewAll = (Button) findViewById(R.id.button3);
        //  viniInput = (EditText)findViewById(R.id.) ;
        dbInput = (TextView) findViewById(R.id.dbInput);
        AddData();
       //printDatabase();

      viewAll();


        Intent intent = getIntent();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_sign_up);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                // .setAction("Action", null).show();
            }
        });
    }

    public void AddData() {
        btnAddData.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editName.getText().toString(),
                                editSurname.getText().toString(),
                                editMarks.getText().toString());
                        if (isInserted)
                            Toast.makeText(MainActivity.this, "data inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "data inserted", Toast.LENGTH_LONG).show();
                    }


                }

        );


    }

     public void viewAll() {
         btnViewAll.setOnClickListener(
                 new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         printDatabase();
                     }
                 }
         );
     }
                       /* btnViewAll.setOnClickListener(
                                new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                         /*    Cursor res = myDb.getAllData();
                          if(res.getCount()== 0){
                              showMessage("Error","nothing found");

                              return;
                          }
                          StringBuilder buffer = new StringBuilder();
                          while(res.moveToNext()){
                              buffer.append("Id:");
                              buffer.append(res.getString(0) );
                              buffer.append("\n");
                             // System.out.println(buffer);
                              buffer.append("Name:" );
                              buffer.append(res.getString(1));
                              buffer.append("\n");
                            // System.out.println(buffer);

                              buffer.append("Surname:" +res.getString(2) + "\n");
                              buffer.append("Marks:" +res.getString(3) + "\n\n");
                              showMessage("Data",buffer.toString());

                          }

                          //show all data
                          showMessage("Data",buffer.toString());

                                    }
                                }

                        );
                    }
                }
                    );
      }*/


                    /*  public void showMessage (String title, String Message){
                          AlertDialog.Builder builder = new AlertDialog.Builder(this);
                          builder.setCancelable(true);
                          builder.setTitle(title);
                          builder.setMessage(Message);
                          builder.show();
                      }

                  */

                    public void printDatabase() {

                        String dbString = myDb.databaseToString();
                        dbInput.setText(dbString);

                    }


      }
