package com.example.testeintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    Button btnIternet;
    Button btnEnviarSMS;
    Button btnLigar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIternet = (Button) findViewById(R.id.btnInternet);
        btnEnviarSMS = (Button) findViewById(R.id.btnEnviarSMS);
        btnLigar = (Button) findViewById(R.id.btnLigar);

        btnIternet.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, AcessoInternet.class);
                startActivity(intent);
            }
        });

        btnEnviarSMS.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, EnviarSms.class);
                startActivity(intent);
            }
        });

        btnLigar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, FazerLigacao.class);
                startActivity(intent);
            }
        });
    }
}