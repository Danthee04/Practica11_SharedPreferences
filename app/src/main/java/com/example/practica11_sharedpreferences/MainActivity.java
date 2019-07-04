package com.example.practica11_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;

import android.content.ContentProvider;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.txt_email);

        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        et1.setText(preferencias.getString("mail", ""));
    }

    //Metodo para el boton GUARDAR
    public void Guardar(View view){
        SharedPreferences preferenciasCom = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor Obj_editor = preferenciasCom.edit();
        Obj_editor.putString("mail", et1.getText().toString());
        Obj_editor.commit();
        finish();
    }
}
