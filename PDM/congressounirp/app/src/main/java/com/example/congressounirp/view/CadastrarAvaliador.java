package com.example.congressounirp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.congressounirp.Model.Avaliador;
import com.example.congressounirp.Model.ConnectDataBase;
import com.example.congressounirp.R;
import com.google.firebase.database.DatabaseReference;

public class CadastrarAvaliador extends AppCompatActivity {

    EditText edtCodigoAval;
    EditText edtNomeAval;
    EditText edtEmail;
    EditText edtCurso;
    EditText edtCelular;
    Button btnCadAval;
    Spinner spnAreaAval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_avaliador);

        // linkando componentes JAVA com XML
        edtCodigoAval = (EditText) findViewById(R.id.edtCodigoAval);
        edtNomeAval   = (EditText) findViewById(R.id.edtNomeAval);
        edtEmail      = (EditText) findViewById(R.id.edtEmailAval);
        edtCurso      = (EditText) findViewById(R.id.edtCursoAval);
        edtCelular    = (EditText) findViewById(R.id.edtCelularAval);

        spnAreaAval   = (Spinner) findViewById(R.id.spnAreaAval);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.areaAval,
                android.R.layout.simple_spinner_item);
        spnAreaAval.setAdapter(adapter);

        btnCadAval    = (Button)  findViewById(R.id.btnCadastroAval);


        btnCadAval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Avaliador avaliador = new Avaliador();

                    avaliador.setIdAvaliador(edtCodigoAval.getText().toString());
                    avaliador.setNomeAvaliador(edtNomeAval.getText().toString());
                    avaliador.setEmail(edtEmail.getText().toString());
                    avaliador.setCurso(edtCurso.getText().toString());
                    avaliador.setCelular(edtCelular.getText().toString());

                    avaliador.setArea(spnAreaAval.getSelectedItem().toString());

                    // instanciando um objeto conexao para fazer a conexão com o Banco de Dados
                    ConnectDataBase conexao = new ConnectDataBase();
                    DatabaseReference databaseReference =
                            conexao.connectCloudDataBase(getBaseContext());
                    databaseReference.child("Avaliadores2021").
                            child(avaliador.getIdAvaliador()).setValue(avaliador);
                    limpaTela();
                    Toast.makeText(getBaseContext(), "cadastro sucesso", Toast.LENGTH_LONG).show();
                } catch (Exception ex){
                    Toast.makeText(getBaseContext(), "Erro " + ex, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void limpaTela(){
        this.edtCodigoAval.setText("");
        this.edtNomeAval.setText("");
        this.edtEmail.setText("");
        this.edtCurso.setText("");
        this.edtCelular.setText("");
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.areaAval,
                android.R.layout.simple_spinner_item);
        spnAreaAval.setAdapter(adapter);
    }
}