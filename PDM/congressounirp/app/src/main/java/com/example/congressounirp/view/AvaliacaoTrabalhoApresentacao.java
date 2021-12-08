package com.example.congressounirp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.congressounirp.Model.ConnectDataBase;
import com.example.congressounirp.Model.Trabalho;
import com.example.congressounirp.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AvaliacaoTrabalhoApresentacao extends AppCompatActivity {

    EditText txtTitulo;
    EditText txtId;
    EditText edtNotaApress;
    Button btnSalvarApress;

    Trabalho trabalho;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao_trabalho_apresentacao);

        txtTitulo = (EditText) findViewById(R.id.txtTitulo);
        txtId = (EditText) findViewById(R.id.txtId);
        edtNotaApress = (EditText) findViewById(R.id.edtNotaApress);
        btnSalvarApress = (Button) findViewById(R.id.btnSalvarApress);

        Intent intent = getIntent();

        if(intent != null){
            Bundle parametro = intent.getExtras();

            if(parametro != null){
                txtId.setText(parametro.getString("id"));
                txtTitulo.setText(parametro.getString("titulo"));
                txtTitulo.requestFocus();
            }
            else{
                Toast.makeText(this, "PARAMETRO NULO", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this, "INTENT NULO", Toast.LENGTH_LONG).show();
        }

        btnSalvarApress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Bundle parametro = intent.getExtras();
                    trabalho = new Trabalho();

                    trabalho.setSiglaNumero(txtId.getText().toString());
                    trabalho.setNotaApres(Double.parseDouble(edtNotaApress.getText().toString()));
                    trabalho.setCategoria(parametro.getString("categotia"));
                    trabalho.setInstituicao(parametro.getString("instituicao"));
                    trabalho.setAutor(parametro.getString("autor"));
                    trabalho.setNomeOrientador(parametro.getString("orientador"));
                    trabalho.setTitulo(parametro.getString("titulo"));
                    trabalho.setCodAvaliadorApres(parametro.getString("codAvalApres"));
                    trabalho.setCodAvaliadorResumo(parametro.getString("codAvalResumo"));
                    trabalho.setNotaResumo(parametro.getDouble("notaResumo"));
                    trabalho.setMedia(trabalho.calcMedia());

                    if(Double.parseDouble(edtNotaApress.getText().toString()) >= 5 && Double.parseDouble(edtNotaApress.getText().toString()) <= 10){
                        inicializarFirebase();
                        databaseReference.child("Trabalhos2021").child(trabalho.getSiglaNumero()).setValue(trabalho);
                        Toast.makeText(getBaseContext(), "cadastro sucesso", Toast.LENGTH_LONG).show();
                        limpaTela();
                        finish();
                    }else{
                        throw new Exception("Valor da nota deve ser entre 5 e 10");
                    }

                } catch (Exception ex){
                    Toast.makeText(getBaseContext(), "Erro " + ex, Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    private void inicializarFirebase(){
        FirebaseApp.initializeApp(AvaliacaoTrabalhoApresentacao.this);
        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference();
    }


    public  void limpaTela(){
        this.txtId.setText("");
        this.txtTitulo.setText("");
    }
}