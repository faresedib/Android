package com.example.intentsactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "Respuesta";
    private EditText mReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mReply = findViewById(R.id.editText_second);
        Intent intent_destino = getIntent();
        String message = intent_destino.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);
    }

    public void returnReply(View view) {
        String respuesta = mReply.getText().toString();
        Intent intent_origen = new Intent(this, MainActivity.class);
        intent_origen.putExtra(EXTRA_REPLY, respuesta);
        setResult(RESULT_OK,intent_origen);
        finish();
    }
}