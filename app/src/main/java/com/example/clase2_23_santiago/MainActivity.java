package com.example.clase2_23_santiago;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CALL = 1;

    Button btn_segundo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_segundo = findViewById(R.id.btn_segundo);
        btn_segundo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                //Uri url = Uri.parse("tel:959394959");
               // Intent intent = new Intent(Intent.ACTION_DIAL,url);
                intent.putExtra("nombre","santiago");
                intent.putExtra("edad",20);
                startActivity(intent);
                //MarcarTelefono();
                //setResult(RESULT_OK,intent);
                //finish();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                MarcarTelefono();
            } else {

            }
        }

    }

    public void MarcarTelefono() {
       if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, REQUEST_CALL);
        } else {
            /*Uri uri = Uri.parse("tel:959394959");
            Intent intent = new Intent(Intent.ACTION_CALL, uri);
            startActivity(intent);*/
        }

    }
}
