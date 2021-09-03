package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class alertActivity extends AppCompatActivity {

    TextView textoAlerta;
    Button btnAceptar,btnCancelar;
    boolean isAcepted;
    Intent intencioDeResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
        textoAlerta = findViewById(R.id.textoAlerta);

        btnAceptar = findViewById(R.id.btnAceptar);
        btnCancelar = findViewById(R.id.btnCancelar);
        intencioDeResultado = new Intent();

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAcepted=true;
                intencioDeResultado.putExtra("isAcepted",isAcepted);
                setResult(20,intencioDeResultado);
                finish();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAcepted=false;
                intencioDeResultado.putExtra("isAcepted",isAcepted);
                setResult(20,intencioDeResultado);
                finish();
            }
        });

        Bundle mochila =getIntent().getExtras();
        String nombreUsuarioExtraido=mochila.getString("nombreUsuario");
        textoAlerta.setText("FELICIDADES "+nombreUsuarioExtraido+", HAZ GANADO 900 GEMAS, DECEAS ACEPTARLAS?");
    }
}