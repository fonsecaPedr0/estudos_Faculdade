package com.example.testeintent;

import static android.provider.CalendarContract.CalendarCache.URI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AcessoInternet extends AppCompatActivity
{

    EditText txtURL;
    Button btnAcessar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acesso_internet);

        txtURL = (EditText) findViewById(R.id.txtURL);
        btnAcessar = (Button) findViewById(R.id.btnAcessar);

        btnAcessar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Uri uri = Uri.parse(txtURL.getText().toString());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onPause()
    {
        super.onPause();
        finish();
    }
}