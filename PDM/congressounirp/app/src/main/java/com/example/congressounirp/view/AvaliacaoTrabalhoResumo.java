package com.example.congressounirp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.congressounirp.Model.Trabalho;
import com.example.congressounirp.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AvaliacaoTrabalhoResumo extends AppCompatActivity {

    EditText txtIdR;
    EditText txtTituloR;
    EditText edtNotaResumo;
    Button btnSalvarResumo;

    Trabalho trabalho;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao_trabalho_resumo);

        txtIdR = (EditText) findViewById(R.id.txtIdR);
        txtTituloR = (EditText) findViewById(R.id.txtTituloR);
        edtNotaResumo = (EditText) findViewById(R.id.edtNotaResumo);
        btnSalvarResumo = (Button) findViewById(R.id.btnSalvarResumo);

        Intent intent = getIntent();

        if(intent != null){
            Bundle parametro = intent.getExtras();

            if(parametro != null){
                txtIdR.setText(parametro.getString("id"));
                txtTituloR.setText(parametro.getString("titulo"));
                txtTituloR.requestFocus();
            }
            else{
                Toast.makeText(this, "PARAMETRO NULO", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this, "INTENT NULO", Toast.LENGTH_LONG).show();
        }

        btnSalvarResumo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Bundle parametro = intent.getExtras();
                    trabalho = new Trabalho();

                    trabalho.setSiglaNumero(txtIdR.getText().toString());
                    trabalho.setNotaResumo(Double.parseDouble(edtNotaResumo.getText().toString()));
                    trabalho.setCategoria(parametro.getString("categotia"));
                    trabalho.setInstituicao(parametro.getString("instituicao"));
                    trabalho.setAutor(parametro.getString("autor"));
                    trabalho.setNomeOrientador(parametro.getString("orientador"));
                    trabalho.setTitulo(parametro.getString("titulo"));
                    trabalho.setCodAvaliadorApres(parametro.getString("codAvalApres"));
                    trabalho.setCodAvaliadorResumo(parametro.getString("codAvalResumo"));
                    trabalho.setNotaApres(parametro.getDouble("notaApres"));
                    trabalho.setMedia(trabalho.calcMedia().floatValue());

                    if(Double.parseDouble(edtNotaResumo.getText().toString()) >=5 && Double.parseDouble(edtNotaResumo.getText().toString()) <=10 ){
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
        FirebaseApp.initializeApp(AvaliacaoTrabalhoResumo.this);
        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference();
    }


    public  void limpaTela(){
        this.txtIdR.setText("");
        this.txtTituloR.setText("");
    }
}