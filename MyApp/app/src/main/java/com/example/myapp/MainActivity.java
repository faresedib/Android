package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//R es una clase predefinida a partir de la cual
        //nuestra app carga los recursos necesarios

        TextView mitexto=new TextView(this);//El pasamos el mainActivity
        mitexto.setText("Hola gente");
        setContentView(mitexto);//Vista
    }
}