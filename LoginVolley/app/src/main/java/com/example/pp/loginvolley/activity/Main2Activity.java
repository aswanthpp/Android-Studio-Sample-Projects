package com.example.pp.loginvolley.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.pp.loginvolley.R;

import java.util.HashMap;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {



    private static final String LOGIN_URL="http://jee00723.esy.es/login-db.php";
    public static final String KEY_USERNAME= "username";
    public static final String KEY_PASSWORD = "password";

    private String uname;
    private String pswd;

    private EditText editTextUsername;
    private EditText editTextPassword;

    private Button buttonhome;
    private Button buttonnext;

    SessionManagement session ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        session = new SessionManagement(getApplicationContext());
        if(session.isLoggedIn()) {
        Toast.makeText(Main2Activity.this,"Already LoggedIn",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Main2Activity.this, HomeActivity.class);
            startActivity(i);
            finish();
        }
        else {


            editTextUsername = (EditText) findViewById(R.id.username);
            editTextPassword = (EditText) findViewById(R.id.password);


            buttonnext = (Button) findViewById(R.id.login);
            buttonnext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    uname = editTextUsername.getText().toString().trim();
                    pswd = editTextPassword.getText().toString().trim();
                    if (uname.isEmpty() || pswd.isEmpty()) {
                        Toast.makeText(Main2Activity.this, "All Fields are Compulsory", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Main2Activity.this, Main2Activity.class);
                        startActivity(i);
                        finish();
                    } else {
                        loginuser();
                    }
                }
            });

            buttonhome = (Button) findViewById(R.id.btn_prevpage);
            buttonhome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Main2Activity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            });
        }

    }


        private void loginuser(){

            StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL,
                    new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(Main2Activity.this, response, Toast.LENGTH_LONG).show();

                   if(response.trim().equals("success")) {
                        Intent i = new Intent(Main2Activity.this, HomeActivity.class);
                       session.createLoginSession(uname);
                        startActivity(i);
                        finish();
                    }


                }
            },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(Main2Activity.this, error.toString(), Toast.LENGTH_LONG).show();
                            Intent i = new Intent(Main2Activity.this, Main2Activity.class);
                            startActivity(i);
                            finish();
                        }
                    }){
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put(KEY_USERNAME, uname);
                    params.put(KEY_PASSWORD, pswd);
                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);
        }
    public void onBackPressed() {

        alertexit();

    }

    public void alertexit() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Main2Activity.this);
        alertDialog.setTitle("Exit App");
        alertDialog.setMessage("Do you want close this App?");
        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialog.show();
    }

}
