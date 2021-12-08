package com.example.congressounirp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.congressounirp.view.CadastrarAvaliador;
import com.example.congressounirp.view.CadastrarTrabalho;
import com.example.congressounirp.view.ListaTrabalhoApresentacao;
import com.example.congressounirp.view.ListaTrabalhoResumo;

public class MainActivity extends AppCompatActivity {

    Button btnCadastroAvaliador;
    Button btnCadastroTrabalho;
    Button btnListarTrabalhoApress;
    Button btnListarTrabalhoRess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadastroAvaliador = (Button) findViewById(R.id.btnCadastroAvaliador);
        btnCadastroTrabalho = (Button) findViewById(R.id.btnCadastroTrabalho);
        btnListarTrabalhoApress = (Button) findViewById(R.id.btnListarTrabalhoApress);
        btnListarTrabalhoRess = (Button) findViewById(R.id.btnListarTrabalhoRess);


        btnCadastroAvaliador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CadastrarAvaliador.class);
                startActivity(intent);
            }
        });

        btnCadastroTrabalho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CadastrarTrabalho.class);
                startActivity(intent);
            }
        });

        btnListarTrabalhoApress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListaTrabalhoApresentacao.class);
                startActivity(intent);
            }
        });

        btnListarTrabalhoRess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListaTrabalhoResumo.class);
                startActivity(intent);
            }
        });
    }
}