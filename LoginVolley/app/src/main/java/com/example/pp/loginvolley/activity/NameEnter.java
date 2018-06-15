package com.example.pp.loginvolley.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pp.loginvolley.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class NameEnter extends AppCompatActivity {
    private Button buttonsubmit;
    private Button buttonback;
    private EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_enter);
        name = (EditText) findViewById(R.id.edit_name);
        buttonsubmit= (Button) findViewById(R.id.btn_submit);
        buttonsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = name.getText().toString();
                Intent i;

                if (n.isEmpty()) {
                    Toast.makeText(NameEnter.this, "Name Can't Be Empty ", Toast.LENGTH_SHORT).show();
                    i = new Intent(NameEnter.this, NameEnter.class);
                    startActivity(i);
                    finish();
                } else if (n.length() > 10) {
                    Toast.makeText(NameEnter.this, "Must be Lessthan 20 ", Toast.LENGTH_SHORT).show();

                } else {

                    try {
                        File myFile = new File("/mysdfile.txt");
                        myFile.createNewFile();
                        FileOutputStream fOut = new FileOutputStream(myFile);
                        OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
                        myOutWriter.append(name.getText());
                        myOutWriter.close();
                        Toast.makeText(NameEnter.this, "File Wrote  ", Toast.LENGTH_SHORT).show();
                        fOut.close();
                        i = new Intent(NameEnter.this, HomeActivity.class);
                        startActivity(i);
                        finish();
                    } catch (Exception e) {
                        Log.e("ERRR", "Could not create file", e);
                        Toast.makeText(NameEnter.this, "ERRR, Could not create file ", Toast.LENGTH_SHORT).show();

                    }
                }// onClick
            }
        });
        buttonback= (Button) findViewById(R.id.btn_back);
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(NameEnter.this,HomeActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(this,HomeActivity.class);
        startActivity(i);
        finish();
    }
}
