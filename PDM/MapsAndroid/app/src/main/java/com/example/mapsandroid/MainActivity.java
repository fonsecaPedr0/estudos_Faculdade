package com.example.mapsandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner spnCity;

    RadioGroup grupo;
    RadioButton rbSP;
    RadioButton rbRJ;
    RadioButton rbMG;

    Button btnMapa;

    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grupo = (RadioGroup) findViewById(R.id.rgEstado);
        spnCity = (Spinner) findViewById(R.id.spnCidades);
        rbSP = (RadioButton) findViewById(R.id.rbSP);
        rbRJ = (RadioButton) findViewById(R.id.rbRJ);
        rbMG = (RadioButton) findViewById(R.id.rbMG);
        btnMapa = (Button) findViewById(R.id.btnMapa);

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item);

        grupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId)
            {
                int id = grupo.findViewById(checkedId).getId();
                switch (id)
                {
                    case R.id.rbSP:
                        arrayAdapter = ArrayAdapter.createFromResource(MainActivity.this,
                                R.array.saopaulo, android.R.layout.simple_spinner_item);
                        break;
                    case R.id.rbMG:
                        arrayAdapter = ArrayAdapter.createFromResource(MainActivity.this,
                                R.array.minas, android.R.layout.simple_spinner_item);
                        break;
                    case R.id.rbRJ:
                        arrayAdapter = ArrayAdapter.createFromResource(MainActivity.this,
                                R.array.rio, android.R.layout.simple_spinner_item);
                        break;
                }

                spnCity.setAdapter(arrayAdapter);
            }
        });

        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String nsvNome = spnCity.getSelectedItem().toString();
                nsvNome = "geo:0,0?q=" + nsvNome;
                Uri uri = Uri.parse(nsvNome);
                Intent it = new Intent(Intent.ACTION_VIEW,  uri);
                startActivity(it);
            }
        });

    }
}