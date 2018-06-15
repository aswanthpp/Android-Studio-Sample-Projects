package com.example.pp.loginvolley.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pp.loginvolley.R;

public class HomeActivity extends AppCompatActivity {
    SessionManagement session;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        session = new SessionManagement(getApplicationContext());

        FloatingActionButton logout = (FloatingActionButton) findViewById(R.id.btn_logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this,"Logged Out", Toast.LENGTH_SHORT).show();
                session.logoutUser();
                Intent i = new Intent(HomeActivity.this, Main2Activity.class);
                startActivity(i);
                finish();
            }
        });


        FloatingActionButton add= (FloatingActionButton) findViewById(R.id.btn_add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HomeActivity.this,NameEnter.class);
                startActivity(i);
                finish();
            }
        });
        String n=session.getName();
        n="Hi Aswanth";
        TextView username= (TextView) findViewById(R.id.view_uname);
        username.setText(n);









//        FloatingActionButton delete = (FloatingActionButton) findViewById(R.id.btn_delete);
//        delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

    }

}
