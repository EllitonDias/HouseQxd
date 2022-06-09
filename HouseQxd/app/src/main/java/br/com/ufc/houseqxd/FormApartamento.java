package br.com.ufc.houseqxd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormApartamento extends AppCompatActivity {
    private EditText nome, lugar,valor;
    private Button btnSalvar;
    private ApartamentoDAO dao = new ApartamentoDAO();
    private ApartamentoAdapter adapter = new ApartamentoAdapter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_apartamento);


        nome = findViewById(R.id.edt_nome);
        lugar = findViewById(R.id.edt_lugar);
        valor = findViewById(R.id.edt_valor);
        btnSalvar = findViewById(R.id.salvar);


        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nome.getText().toString().equals("") && valor.getText().toString().equals("") && lugar.getText().toString().equals("")){
                    Toast.makeText(FormApartamento.this,"Por favor, preencher todos os campos",Toast.LENGTH_SHORT).show();
                }else if(nome.getText().toString().equals("") || valor.getText().toString().equals("") || lugar.getText().toString().equals("")){
                    if(nome.getText().toString().equals("")){
                        Toast.makeText(FormApartamento.this,"Por favor, preencher o campo Endereço",Toast.LENGTH_SHORT).show();
                    }else if( lugar.getText().toString().equals("")){
                        Toast.makeText(FormApartamento.this,"Por favor, preencher o campo localização",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(FormApartamento.this,"Por favor, preencher todos os campos",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Apartamento ap = creaApartamento();
                    salvarAp(ap);
                }

            }
            private void salvarAp(Apartamento ap) {
                dao.salva(ap);
                adapter.notifyDataSetChanged();
                Intent intent = new Intent(FormApartamento.this, MainActivity.class);
                startActivity(intent);
            }

            private Apartamento creaApartamento() {
                String nome1 = nome.getText().toString();
                String lugar1 = lugar.getText().toString();
                double valor1 = Double.parseDouble(valor.getText().toString());
                return new Apartamento(nome1, lugar1, valor1);
            }
        });
    }
}