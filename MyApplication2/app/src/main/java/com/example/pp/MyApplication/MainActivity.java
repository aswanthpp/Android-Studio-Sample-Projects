package com.example.pp.MyApplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pp.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private Button buttonhome;
    private EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        name = (EditText) findViewById(R.id.name);




        buttonhome= (Button) findViewById(R.id.btn_nxtpage);
        buttonhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n= name.getText().toString();
                Intent i= new Intent(MainActivity.this, Main3Activity.class) ;
                i.putExtra("name", n);
                startActivity(i);
                finish();
            }
        });

    }

}
