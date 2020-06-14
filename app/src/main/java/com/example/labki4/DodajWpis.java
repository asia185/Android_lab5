package com.example.labki4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DodajWpis extends AppCompatActivity {

    public void wyslij(View wiew){
        EditText kontrolka = (EditText)findViewById(R.id.editTextTextPersonName);
        String pole = kontrolka.getText().toString();
        Intent intencja = new Intent();
        intencja.putExtra("wpis",pole);
        setResult(RESULT_OK, intencja);
        finish();;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_wpis);
    }
}