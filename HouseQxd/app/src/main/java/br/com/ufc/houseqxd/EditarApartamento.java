package br.com.ufc.houseqxd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EditarApartamento extends AppCompatActivity {
    private TextView nome,lugar,valor;
    private Button btnSalvar;
    private ApartamentoDAO dao = new ApartamentoDAO();
    private ApartamentoAdapter adapter = new ApartamentoAdapter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_apartamento);

        nome = findViewById(R.id.up_nome);
        lugar = findViewById(R.id.up_lugar);
        valor = findViewById(R.id.up_valor);
        btnSalvar = findViewById(R.id.atualizar);
        int posicao = getIntent().getIntExtra("id",0);


        Apartamento apartamento = (Apartamento) getIntent().getSerializableExtra("ap");



            String nomeAp = apartamento.getNome();
            String lugarAp = apartamento.getLugar();
            double valorAp = apartamento.getValor();
            nome.setText(nomeAp);
            lugar.setText(lugarAp);
            valor.setText(Double.toString(valorAp));

            btnSalvar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(EditarApartamento.this, MainActivity.class);

                    String nomeFinal = nome.getText().toString();
                    String lugarFinal = lugar.getText().toString();
                    String valorV = valor.getText().toString();
                    if(nomeFinal.equals("") && lugarFinal.equals("") && valor.getText().toString().equals("")){
                        Toast.makeText(EditarApartamento.this,"Por favor, preencher todos os campos",Toast.LENGTH_SHORT).show();
                    }else if(nomeFinal.equals("") || lugarFinal.equals("") || valorV.equals("")){
                        Toast.makeText(EditarApartamento.this,"Por favor, preencher todos os campos",Toast.LENGTH_SHORT).show();
                    }else{
                        double valorFinal = Double.parseDouble(valorV);
                        apartamento.setNome(nomeFinal);
                        apartamento.setLugar(lugarFinal);
                        apartamento.setValor(valorFinal);
                        dao.editar(posicao,apartamento);
                        Toast.makeText(EditarApartamento.this,"Você editou o apartamento: "+ nomeAp,Toast.LENGTH_LONG).show();
                        adapter.notifyDataSetChanged();
                        startActivity(intent);
                    }
                }
            });

    }
}