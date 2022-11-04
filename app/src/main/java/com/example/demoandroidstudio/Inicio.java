package com.example.demoandroidstudio;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Inicio extends AppCompatActivity implements View.OnClickListener {

    Button btnVolver, btnAumentar, btnPintar;
    EditText edCantidad, edValor;

    public double precioManzana = 2000;
    public double valorPagar;
    public Integer cantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        cantidad = 0;
        btnVolver = findViewById(R.id.btnVolver);
        btnAumentar = findViewById(R.id.btnAumentar);
        edCantidad = findViewById(R.id.edCantidad);
        edValor = findViewById(R.id.edValor);

        btnAumentar.setOnClickListener(this);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent navegar = new Intent(getApplicationContext(), MainActivity.class);
                Bundle data = new Bundle();
                data.putInt("cantidad", cantidad);
                data.putDouble("valorPagar", valorPagar);
                navegar.putExtras(data);
                navegar.putExtra("precioLeche", precioManzana);
                navegar.addFlags(navegar.FLAG_ACTIVITY_CLEAR_TASK | navegar.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(navegar);
            }
        });
    }

    public void saludar(View h) {
        //enlazamiento
        cantidad = cantidad + 1;
        edCantidad.setText("Cantidad: " + cantidad);
        valorPagar = cantidad * precioManzana;
        edValor.setText("El valor de tu cuenta es: " + valorPagar);
    }

    @Override
    public void onClick(View view) {

    }
}

