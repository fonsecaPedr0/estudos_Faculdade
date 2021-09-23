package com.example.testeintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnviarSms extends AppCompatActivity
{

    SmsManager objSMSManager;

    Button btnEnviar;
    EditText txtMensagem;
    EditText txtNrCell;

    String smsPara;
    String smsMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_sms);

        txtNrCell = (EditText) findViewById(R.id.txtNrCell);
        txtMensagem = (EditText) findViewById(R.id.txtMensagem);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                smsPara = txtNrCell.getText().toString();
                smsMensagem = txtMensagem.getText().toString();

                try
                {
                    objSMSManager = SmsManager.getDefault();
                    objSMSManager.sendTextMessage(smsPara, null, smsMensagem, null, null);
                    Toast.makeText(getApplicationContext(), "SMS Enviado...", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(), "Erro ao Enviar SMS..." + e, Toast.LENGTH_LONG).show();
                }
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