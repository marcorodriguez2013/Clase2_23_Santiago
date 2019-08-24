package com.example.clase2_23_santiago;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    TextView texto;
    Button btn_este;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        String edad = intent.getStringExtra("edad");
        btn_este = findViewById(R.id.btn_este);
        texto = findViewById(R.id.textto_modificado);
        texto.setText(nombre);
    btn_este.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.putExtra("respuesta","cambie el texto");
            setResult(RESULT_OK,intent);
            finish();
        }
    });


    }
}
