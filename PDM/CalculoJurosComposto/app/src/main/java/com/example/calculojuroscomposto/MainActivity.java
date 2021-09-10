package com.example.calculojuroscomposto;

import static java.lang.Math.pow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.autofill.AutofillValue;
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

    String tempoJ;


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

        periodo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i)
            {
                int id = radioGroup.findViewById(i).getId();
                switch (id)
                {
                    case R.id.idMes:
                        tempoJ = "mes(es)";
                        break;

                    case R.id.idAno:
                        tempoJ = "ano(s)";
                        break;
                }
            }
        });

        btnCalcular.setOnClickListener((v) -> {calcularJurosC();});

    }

    public void calcularJurosC()
    {
        try {

            Double aplicado = Double.parseDouble(capital.getText().toString());

            Double indiceJ = Double.parseDouble(iJuros.getText().toString());

            Integer tempoAnoMes = Integer.parseInt(tempo.getText().toString());

            Double valorJ, valorM, valorExponencial;

            indiceJ = indiceJ/100;

            valorExponencial = pow((1+indiceJ), tempoAnoMes);

            valorM = aplicado * valorExponencial;

            valorJ = valorM - aplicado;

            montante.setText("Após " + tempoAnoMes + " " + tempoJ + " você terá R$: " + valorM.floatValue());
            jurosC.setText("O juros será de R$: " + valorJ.floatValue());

        }
        catch (Exception exception)
        {
           montante.setText("Informe os valores em todos os campos");
           montante.setTextColor(Color.RED);
        }

    }


}