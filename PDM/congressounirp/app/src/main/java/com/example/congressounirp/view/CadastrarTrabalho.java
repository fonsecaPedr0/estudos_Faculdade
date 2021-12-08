package com.example.congressounirp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.congressounirp.Model.ConnectDataBase;
import com.example.congressounirp.Model.Trabalho;
import com.example.congressounirp.R;
import com.google.firebase.database.DatabaseReference;

public class CadastrarTrabalho extends AppCompatActivity {

    EditText edtSiglaNo;
    EditText edtTitulo;
    EditText edtAutor;
    EditText edtOrientador;
    EditText edtInstituicao;
    EditText edtCodAvalResumo;
    EditText edtCodAvalApres;

    RadioGroup rgArea;
    RadioButton rbBA;
    RadioButton rbE;
    RadioButton rbH;
    RadioButton rbS;

    Spinner spnCategoria;

    Button btnCadTrab;

    String sigla;
    int count = 0;
    int countBA = 1, countE = 1, countH = 1, countS =1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_trabalho);

        //edtSiglaNo = (EditText) findViewById(R.id.edtSiglaNo);
        edtTitulo = (EditText) findViewById(R.id.edtTitulo);
        edtAutor = (EditText) findViewById(R.id.edtAutor);
        edtOrientador = (EditText) findViewById(R.id.edtOrientador);
        edtInstituicao = (EditText)  findViewById(R.id.edtInstituicao);
        edtCodAvalResumo = (EditText) findViewById(R.id.edtCodAvalResumo);
        edtCodAvalApres = (EditText) findViewById(R.id.edtCodAvalApres);

        rgArea = (RadioGroup) findViewById(R.id.rgArea);
        rbBA = (RadioButton) findViewById(R.id.rbBA);
        rbE = (RadioButton) findViewById(R.id.rbE);
        rbH = (RadioButton) findViewById(R.id.rbH);
        rbS = (RadioButton) findViewById(R.id.rbS);

        spnCategoria = (Spinner) findViewById(R.id.spnCategoria);
        //spnAreaTrabalho = (Spinner) findViewById(R.id.spnAreaTrabalho);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.categoria,
                android.R.layout.simple_spinner_item);
        spnCategoria.setAdapter(adapter);

        btnCadTrab = (Button) findViewById(R.id.btnCadTrab);

        rgArea.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                int id = rgArea.findViewById(checkedId).getId();

                switch (id)
                {
                    case R.id.rbBA:
                        sigla = "BA";
                        count = countBA;
                        break;
                    case R.id.rbE:
                        sigla = "E";
                        count = countE;
                        break;
                    case R.id.rbH:
                        sigla = "H";
                        count = countH;
                        break;
                    case R.id.rbS:
                        sigla = "S";
                        count = countS;
                        break;
                }
            }
        });


        btnCadTrab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Trabalho trabalho = new Trabalho();

                    trabalho.setSiglaNumero(sigla + count);
                    trabalho.setCategoria(spnCategoria.getSelectedItem().toString());
                    trabalho.setInstituicao(edtInstituicao.getText().toString());
                    trabalho.setAutor(edtAutor.getText().toString());
                    trabalho.setNomeOrientador(edtOrientador.getText().toString());
                    trabalho.setTitulo(edtTitulo.getText().toString());
                    trabalho.setCodAvaliadorResumo(edtCodAvalResumo.getText().toString());
                    trabalho.setCodAvaliadorApres(edtCodAvalApres.getText().toString());

                    contador();

                    // instanciando um objeto conexao para fazer a conexão com o Banco de Dados
                    ConnectDataBase conexao = new ConnectDataBase();
                    DatabaseReference databaseReference =
                            conexao.connectCloudDataBase(getBaseContext());
                    databaseReference.child("Trabalhos2021").
                            child(trabalho.getSiglaNumero()).setValue(trabalho);
                    limpaTela();
                    Toast.makeText(getBaseContext(), "cadastro sucesso", Toast.LENGTH_LONG).show();
                } catch (Exception ex){
                    Toast.makeText(getBaseContext(), "Erro " + ex, Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    public void limpaTela(){
         this.edtTitulo.setText("");
         this.edtAutor.setText("");
         this.edtOrientador.setText("");
         this.edtInstituicao.setText("");
         this.edtCodAvalResumo.setText("");
         this.edtCodAvalApres.setText("");

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.categoria,
                android.R.layout.simple_spinner_item);
         this.spnCategoria.setAdapter(adapter);
    }

    public void contador(){
        if(sigla.equalsIgnoreCase("BA")){
            countBA++;
        }else if(sigla.equalsIgnoreCase("E")){
            countE++;
        }else if(sigla.equalsIgnoreCase("H")){
            countH++;
        }else if(sigla.equalsIgnoreCase("S")){
            countS++;
        }
    }

}