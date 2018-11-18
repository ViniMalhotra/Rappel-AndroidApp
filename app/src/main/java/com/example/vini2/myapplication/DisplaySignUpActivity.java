package com.example.vini2.myapplication;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplaySignUpActivity extends AppCompatActivity {
         public static final String EXTRA_MESS = "com.example.vini2.myapplication";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_sign_up);

      //  TextView textView = new TextView(this);
       // textView.setTextSize(40);
       // textView.setText(message);
         ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_sign_up);
      //  layout.addView(textView);

    }
    public void showSubmit(View view) {
        Intent intent1 = new Intent(this, ItemListActivity.class);
        startActivity(intent1);
    }
    }


