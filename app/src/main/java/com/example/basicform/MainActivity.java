package com.example.basicform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ib.custom.toast.CustomToastView;

import java.util.List;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btnEnviar;
    private EditText txtNombre;
    private EditText txtApellido;
    private EditText txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEnviar = findViewById(R.id.btnEnviar);
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtEmail = findViewById(R.id.txtEmail);
        btnEnviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnEnviar){
         String nombre = txtNombre.getText().toString();
         String apellido = txtApellido.getText().toString();
         String email = txtEmail.getText().toString();

             if(nombre.isEmpty()){
                 CustomToastView.makeErrorToast(this,"Error al ingresar el nombre", R.layout.custom_toast).show();
                 return;
             }
            if(apellido.isEmpty()){
                CustomToastView.makeErrorToast(this,"Error al ingresar el apellido", R.layout.custom_toast).show();
                return;
            }
            if(!isValidEmail(email)){
                CustomToastView.makeErrorToast(this,"Error al ingresar el email", R.layout.custom_toast).show();
                return;
            }
            Intent myIntent = new Intent(this, imcCalculator.class);
            myIntent.putExtra("nombre", nombre);
            myIntent.putExtra("apellido", apellido);
            myIntent.putExtra("email", email);
            startActivity(myIntent);
        }
    }

    private boolean isValidEmail(String email) {
       Pattern pattern = Patterns.EMAIL_ADDRESS;
       return pattern.matcher(email).matches();
    }
}