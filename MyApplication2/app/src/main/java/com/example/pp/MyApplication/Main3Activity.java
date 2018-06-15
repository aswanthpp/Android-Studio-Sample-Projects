package com.example.pp.MyApplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pp.myapplication.R;

public class Main3Activity extends AppCompatActivity {
    private Button buttonview;
    private TextView name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        name = (TextView) findViewById(R.id.display);
        Intent i= getIntent();
        String n =i.getExtras().getString("name");
        name.setText(n);


        buttonview= (Button) findViewById(R.id.btn_prevpage);
        buttonview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Main3Activity.this, MainActivity.class) ;
                startActivity(i);
                finish();
            }
        });

        buttonview= (Button) findViewById(R.id.btn_close);
        buttonview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
