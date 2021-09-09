package com.example.calculojuroscomposto;

import static java.lang.Math.pow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    EditText capital;
    EditText iJuros;
    EditText tempo;
    RadioGroup periodo;
    RadioButton ano;
    RadioButton mes;
    Button btnCalcular;
    TextView montante;
    TextView jurosC;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        capital = (EditText) findViewById(R.id.idCapital);
        iJuros = (EditText) findViewById(R.id.idIJuros);
        tempo = (EditText) findViewById(R.id.idTempo);
        periodo = (RadioGroup) findViewById(R.id.idPeriodo);
        ano = (RadioButton) findViewById(R.id.idAno);
        mes = (RadioButton) findViewById(R.id.idMes);
        btnCalcular = (Button) findViewById(R.id.idCalcular);
        montante = (TextView) findViewById(R.id.idMontante);
        jurosC = (TextView) findViewById(R.id.idJurosC);

        btnCalcular.setOnClickListener((v) -> {calcularJurosC();});
    }

    public void calcularJurosC()
    {
        Double aplicado = Double.parseDouble(capital.getText().toString());

        Double indiceJ = Double.parseDouble(iJuros.getText().toString());

        Integer tempoAnoMes = Integer.parseInt(tempo.getText().toString());

        Double valorJ, valorM, valorExponencial;

        valorExponencial = pow((1+indiceJ), tempoAnoMes);

        valorM = aplicado * valorExponencial;

        valorJ = valorM - aplicado;

        //montante.setText(String.valueOf(valorM));
        //jurosC.setText("O valor do Juros e: " + valorJ.floatValue());
        periodo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i)
            {
                int id = radioGroup.findViewById(i).getId();
                switch (id)
                {
                    case R.id.idAno:
                        montante.setText("Após " + tempoAnoMes + " Ano(s) você terá R$: " + valorM.floatValue());
                        jurosC.setText("O valor do Juros e de: " + valorJ.floatValue());
                        break;

                    case R.id.idMes:
                        montante.setText("Após " + tempoAnoMes + " mes(es) você terá R$: " + valorM.floatValue());
                        jurosC.setText("O valor do Juros e de: " + valorJ.floatValue());
                        break;
                }
            }
        });

    }
}