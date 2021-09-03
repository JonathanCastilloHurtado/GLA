package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView mTextView;
    ImageButton mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView= findViewById(R.id.miTexto);
        mButton= findViewById(R.id.miBoton);
        mButton.setBackgroundResource(R.drawable.boton_normal);
      mButton.setOnClickListener(this);
    }
// codigo resultado 20 = a si aceptaron las 900 gemas o no
    @Override
    public void onClick(View view) {

        String nombreUsuario = "JOHN";
        mTextView.setText("HOLA YA TENEMOS UNA Variable de TextView FUNCIONANDO!");
        mButton.setBackground(null);
        mButton.setBackgroundResource(R.drawable.boton_pulsado);
        Intent intencionCambioPantalla = new Intent(this, alertActivity.class);
        intencionCambioPantalla.putExtra("nombreUsuario",nombreUsuario);
        startActivityForResult(intencionCambioPantalla,1234);
        //finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==20)
        {
            boolean isAcepted= data.getExtras().getBoolean("isAcepted");

            if (isAcepted){
                mTextView.setText("TUS GEMAS HAN SDO ENVIADAS A TU BAUL");
            }
            else {
                mTextView.setText("LAS GEMAS SE HAN PERDIDO");
            }
        }
    }
}