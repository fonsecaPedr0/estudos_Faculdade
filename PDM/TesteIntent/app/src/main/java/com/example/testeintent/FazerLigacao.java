package com.example.testeintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FazerLigacao extends AppCompatActivity
{

    EditText edtLigacao;
    Button btnLigar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fazer_ligacao);

        edtLigacao = (EditText) findViewById(R.id.edtLigacao);
        btnLigar = (Button) findViewById(R.id.btnLigar);

        btnLigar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Uri uri = Uri.parse("tel:" + edtLigacao.getText().toString());
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