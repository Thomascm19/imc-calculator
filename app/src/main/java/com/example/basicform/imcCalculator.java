package com.example.basicform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class imcCalculator extends AppCompatActivity implements View.OnClickListener {

    private TextView txtInformacion;
    private EditText txtPeso;
    private EditText txtAltura;
    private TextView txtResultado;
    private Button btnCalcular;
    private ImageView imgPersona;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc_calculator);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        String apellido = intent.getStringExtra("apellido");
        String email = intent.getStringExtra("email");

        String mensaje = "Hola " + nombre + " " + apellido;

        txtInformacion =  findViewById(R.id.txtInformacion);
        txtPeso =  findViewById(R.id.txtPeso);
        txtAltura =  findViewById(R.id.txtAltura);
        txtResultado =  findViewById(R.id.txtResultado);
        imgPersona =  findViewById(R.id.imgPersona);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(this);
        txtInformacion.setText(mensaje);
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnCalcular){

        }
    }
}