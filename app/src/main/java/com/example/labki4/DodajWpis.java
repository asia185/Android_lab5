package com.example.labki4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class DodajWpis extends AppCompatActivity {
    private Integer modyfi_id;

    public void wyslij (View view){
        EditText kolor = (EditText) findViewById(R.id.editKolor);
        EditText wielkosc = (EditText) findViewById (R.id.editWielkosc);
        EditText opis = (EditText) findViewById(R.id.editOpis);
        Spinner gatunek = (Spinner) findViewById(R.id.gatunekSpinner);
        Animal zwierz = new Animal(
                gatunek.getSelectedItem().toString(),
                kolor.getText().toString(),
                Float.valueOf(wielkosc.getText().toString()),
                opis.getText().toString()
        );
        zwierz.setId(this.modyfi_id);
        Intent intencja = new Intent();
        intencja.putExtra("newAnimal", zwierz);
        setResult(RESULT_OK, intencja);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_wpis);
        ArrayAdapter gatunki = new ArrayAdapter(this,  android.R.layout.simple_spinner_dropdown_item,
                new String[] {"Pies", "Kot", "Rybki"});
        Spinner gatunek = (Spinner) findViewById(R.id.gatunekSpinner);
        gatunek.setAdapter(gatunki);

        Bundle extras = getIntent().getExtras();
        try {
            if(extras.getSerializable("element") != null) {
                Animal zwierz = (Animal) extras.getSerializable("element");
                EditText kolor = (EditText) findViewById(R.id.editKolor);
                EditText wielkosc = (EditText) findViewById (R.id.editWielkosc);
                EditText opis = (EditText) findViewById(R.id.editOpis);
                kolor.setText(zwierz.getKolor());
                wielkosc.setText(Float.toString(zwierz.getWielkosc()));
                opis.setText(zwierz.getOpis());
                this.modyfi_id=zwierz.getId();
            }
        }catch(Exception ex) {
            this.modyfi_id=0;
        }
    }
}