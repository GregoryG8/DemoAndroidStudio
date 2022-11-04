package com.example.demoandroidstudio;

import static android.widget.Toast.LENGTH_SHORT;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLogin;
    EditText edName, edPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Enlazamiento
        btnLogin = findViewById(R.id.btnLogin);
        edName = findViewById(R.id.edName);
        edPassword = findViewById(R.id.edPassword);
        Toast.makeText(this, "Hola create", Toast.LENGTH_LONG).show();


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navegar = new Intent(getApplicationContext(), Inicio.class);
                Bundle data = new Bundle();
                navegar.putExtras(data);
                navegar.addFlags(navegar.FLAG_ACTIVITY_CLEAR_TASK | navegar.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(navegar);
            }
        });


    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        //Toast.makeText(this, "Hola resume", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Toast.makeText(this, "Hola pause", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {

    }
}