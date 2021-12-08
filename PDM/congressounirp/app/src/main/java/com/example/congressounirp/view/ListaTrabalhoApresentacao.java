package com.example.congressounirp.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.congressounirp.Model.Trabalho;
import com.example.congressounirp.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListaTrabalhoApresentacao extends AppCompatActivity {

    private ListView lstViewTrabalhosApess;
    private List<Trabalho> lstTrabalhos;
    private ArrayAdapter<Trabalho> arrayAdapterTrabalho;

    private Trabalho trabalhoSelecionado;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_trabalho_apresentacao);

        lstViewTrabalhosApess = (ListView) findViewById(R.id.lstViewTrabalhosApess);
        lstTrabalhos = new ArrayList<Trabalho>();

        inicializarFirebese();

        eventoDataBase();

        lstViewTrabalhosApess.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                trabalhoSelecionado = (Trabalho)adapterView.getItemAtPosition(position);

                Bundle parametro = new Bundle();

                parametro.putString("id", trabalhoSelecionado.getSiglaNumero().toString());
                parametro.putString("categotia", trabalhoSelecionado.getCategoria().toString());
                parametro.putString("instituicao", trabalhoSelecionado.getInstituicao().toString());
                parametro.putString("autor", trabalhoSelecionado.getAutor().toString());
                parametro.putString("orientador", trabalhoSelecionado.getNomeOrientador());
                parametro.putString("titulo", trabalhoSelecionado.getTitulo().toString());
                parametro.putString("codAvalResumo", trabalhoSelecionado.getCodAvaliadorResumo().toString());
                parametro.putString("codAvalApres", trabalhoSelecionado.getCodAvaliadorApres().toString());
                parametro.putDouble("notaResumo", trabalhoSelecionado.getNotaResumo());


                Intent intent = new Intent(ListaTrabalhoApresentacao.this, AvaliacaoTrabalhoApresentacao.class);
                intent.putExtras(parametro);
                startActivity(intent);
                finish();
            }
        });
    }

    private void inicializarFirebese() {
        FirebaseApp.initializeApp(ListaTrabalhoApresentacao.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        //firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();
    }

    private void eventoDataBase(){

        databaseReference.child("Trabalhos2021").addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                lstTrabalhos.clear();
                for(DataSnapshot objSnapShot:snapshot.getChildren()){
                    Trabalho trabalho = objSnapShot.getValue(Trabalho.class);
                    lstTrabalhos.add(trabalho);
                }
                arrayAdapterTrabalho = new ArrayAdapter<Trabalho>(ListaTrabalhoApresentacao.this, android.R.layout.simple_list_item_1, lstTrabalhos);
                lstViewTrabalhosApess.setAdapter(arrayAdapterTrabalho);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}