package com.danielvelastegui.deberpetagram;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.danielvelastegui.deberpetagram.javamail.JavaMailAPI;
import com.google.android.material.textfield.TextInputLayout;




public class Contact extends AppCompatActivity {

    private Toolbar contactToolbar;
    private Button btnEnviar;
    private TextInputLayout txtNombre;
    private TextInputLayout txtEmail;
    private TextInputLayout txtMensaje;
    private String nombre;
    private String email;
    private String mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        contactToolbar = findViewById(R.id.contactToolbar);
        setSupportActionBar(contactToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnEnviar = findViewById(R.id.btnEnviar);
        txtNombre = findViewById(R.id.txtNombre);
        txtEmail = findViewById(R.id.txtEmail);
        txtMensaje = findViewById(R.id.txtMensaje);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre = txtNombre.getEditText().getText().toString().trim();
                email = txtEmail.getEditText().getText().toString().trim();
                mensaje = txtMensaje.getEditText().getText().toString().trim();

                boolean entradaValida = validarNombre() && validarEmail() && validarMensaje();
                if(entradaValida){
                    sendMail();
                    //Toast.makeText(Contact.this, "Mensaje Enviado", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void sendMail() {
        JavaMailAPI javaMailAPI = new JavaMailAPI(this, email, nombre, mensaje);

        javaMailAPI.execute();
    }

    private boolean validarEmail(){

        boolean correoValido = email.matches("[A-za-z-_0-9.]+[@][a-z]+[.][a-z]+");

        if(email.isEmpty()){
            txtEmail.setError(getResources().getString(R.string.error));
            return false;
        }else if(!correoValido) {
            txtEmail.setError(getResources().getString(R.string.emailInvalido));
            return false;
        }else{
            txtEmail.setError(null);
            return true;
        }
    }

    private boolean validarNombre(){
        if(nombre.isEmpty()){
            txtNombre.setError(getResources().getString(R.string.error));
            return false;
        }else{
            txtNombre.setError(null);
            return true;
        }
    }

    private boolean validarMensaje(){
        if(mensaje.isEmpty()){
            txtMensaje.setError(getResources().getString(R.string.error));
            return false;
        }else{
            txtMensaje.setError(null);
            return true;
        }
    }
}