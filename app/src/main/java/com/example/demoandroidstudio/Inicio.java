package com.example.demoandroidstudio;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class Inicio extends AppCompatActivity {

    TextView txtName;
    Button btnVolver;

    Fragment_Azul fragment_azul;
    Fragment_Rojo fragment_rojo;
    Fragment_Nigga fragment_nigga;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        txtName = findViewById(R.id.txtName);
        btnVolver = findViewById(R.id.btnVolver);

        fragment_azul=new Fragment_Azul();
        fragment_rojo=new Fragment_Rojo();
        fragment_nigga=new Fragment_Nigga();

        getSupportFragmentManager().beginTransaction().add(R.id.Contenedor, fragment_azul).commit();

        Bundle miBundle=this.getIntent().getExtras();

        if (miBundle!=null){
            String nombre=miBundle.getString("nombre");
            txtName.setText("Bienvenido: "+nombre);
        };

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent navegar2 = new Intent(getApplicationContext(), MainActivity.class);
                Bundle data2 = new Bundle();
                navegar2.putExtras(data2);
                navegar2.addFlags(navegar2.FLAG_ACTIVITY_CLEAR_TASK | navegar2.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(navegar2);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.option1:
                Toast.makeText(this, "¿Necesitas ayuda?", Toast.LENGTH_LONG).show();

                break;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        Inflater inflater = new Inflater();
        getMenuInflater().inflate(R.menu.menu_dashboard,menu);

        return super.onCreateOptionsMenu(menu);


    }

    public void onClick(View v){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();

        switch (v.getId()){
            case R.id.btnAzul:
                    transaction.replace(R.id.Contenedor,fragment_azul);
                break;
            case R.id.btnRojo:
                transaction.replace(R.id.Contenedor,fragment_rojo);
                break;
            case R.id.btnNigga:
                transaction.replace(R.id.Contenedor,fragment_nigga);
                break;


        }

        transaction.commit();
    }

}

