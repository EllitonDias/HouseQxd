package br.com.ufc.houseqxd;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.TextView;

public class InfoApartamento extends AppCompatActivity {
    private TextView nome,lugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_apartamento);
        nome = findViewById(R.id.info_nome);
        lugar = findViewById(R.id.info_lugar);

        Apartamento apartamento = (Apartamento) getIntent().getSerializableExtra("apartamento");
        nome.setText(apartamento.getNome());
        lugar.setText(apartamento.getLugar());


    }
}