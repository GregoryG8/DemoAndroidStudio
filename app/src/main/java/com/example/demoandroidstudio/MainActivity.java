package com.example.demoandroidstudio;

import static android.widget.Toast.LENGTH_SHORT;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.jar.Attributes;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnEnviar;
    EditText edName, edPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEnviar = findViewById(R.id.btnEnviar);
        edName = findViewById(R.id.edName);
        edPassword = findViewById(R.id.edPassword);






    }

    @Override
    public void onClick(View view) {



    }

    public void paso(View view){
        switch (view.getId()){
            case R.id.btnEnviar:

                Intent navegar = new Intent(getApplicationContext(), Inicio.class);
                Bundle data = new Bundle();
                navegar.putExtras(data);
                navegar.addFlags(navegar.FLAG_ACTIVITY_CLEAR_TASK | navegar.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(navegar);

                String nombre=edName.getText().toString();


                Intent miIntent=new Intent(MainActivity.this, Inicio.class);

                Bundle miBundle=new Bundle();
                miBundle.putString("nombre",edName.getText().toString());

                miIntent.putExtras(miBundle);

                startActivity(miIntent);

                break;
        }

    }

    public void naveMenu(View s){
        Intent naveMenu = new Intent(getApplicationContext(), Inicio.class);
        Bundle dataMenu = new Bundle();
        naveMenu.putExtras(dataMenu);
        naveMenu.addFlags(naveMenu.FLAG_ACTIVITY_CLEAR_TASK | naveMenu.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(naveMenu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.option1:
                Toast.makeText(this, "¿Necesitas ayuda?", Toast.LENGTH_LONG).show();
                naveMenu(null);
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        Inflater inflater = new Inflater();
        getMenuInflater().inflate(R.menu.menu_inicial,menu);

        return super.onCreateOptionsMenu(menu);


    }


}