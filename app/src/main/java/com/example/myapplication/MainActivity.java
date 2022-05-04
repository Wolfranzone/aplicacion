package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText et_nombre,et_ato;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_nombre=(EditText) findViewById(R.id.et_nombre);
        et_ato=(EditText) findViewById(R.id.et_ato);

    }
    public void Guardar( View view){
        String nombre=et_nombre.getText().toString();
        String datos=et_ato.getText().toString();
        SharedPreferences preferences=getSharedPreferences("registros", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString(nombre,datos);
        editor.commit();

        Toast.makeText(this,"Registrado",Toast.LENGTH_SHORT).show();
    }
    public void Buscar(View view){
        String nombre=et_nombre.getText().toString();
        SharedPreferences preferences=getSharedPreferences("Registros", Context.MODE_PRIVATE);
        String datos= preferences.getString(nombre,"");
        if (datos.length()==0){
            Toast.makeText(this,"upss,no hay nada",Toast.LENGTH_SHORT).show();
        }else {
            et_ato.setText(datos);
        }
    }
}