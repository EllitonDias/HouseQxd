package br.com.ufc.houseqxd.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import br.com.ufc.houseqxd.model.Apartamento;
import br.com.ufc.houseqxd.R;

public class InfoApartamento extends AppCompatActivity {
    private TextView nome,lugar,valor,numero,qtdC,data,numAp,acess,endOnibus,dsRotas,lf;
    private TextView garagem, mobilia,iluminacao,inclusao,ar,historico;
    private FloatingActionButton btnChat,btnMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_apartamento);
        inicializacaoDosCampos();
        Apartamento apartamento = getApartamento();
        String estado = apartamento.getEstadoAluguel();
        String number = apartamento.getNumeroTelefone();
        confingBtnChat(estado,number);

        confingBtnMap();


    }

    private void confingBtnMap() {
        btnMap = findViewById(R.id.mapa);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InfoApartamento.this, Mapa.class);
                startActivity(intent);
            }
        });
    }

    @NonNull
    private Apartamento getApartamento() {
        //Pegandos os dados do ap
        Apartamento apartamento = (Apartamento) getIntent().getSerializableExtra("apartamento");
        nome.setText(apartamento.getNome());
        lugar.setText(apartamento.getLugar());
        valor.setText(apartamento.getValor());
        numero.setText(apartamento.getNumeroTelefone());
        qtdC.setText(apartamento.getQtdComodo());
        data.setText(apartamento.getData());
        numAp.setText(apartamento.getNumAp());
        acess.setText(apartamento.getAcessibilidade());
        endOnibus.setText(apartamento.getEndRotaOnibus());
        dsRotas.setText(apartamento.getDstRotaOnibus() + "km");
        lf.setText(apartamento.getLocalizacaoFrente());
        garagem.setText(apartamento.getGaragem());
        mobilia.setText(apartamento.getPossuiMobilha());
        iluminacao.setText(apartamento.getIluminacaoPublic());
        inclusao.setText(apartamento.getInclusao());
        ar.setText(apartamento.getPossuiAr());
        historico.setText(apartamento.getHistorico());
        return apartamento;

    }

    private void confingBtnChat(String estado,String number) {
        //Verificando se o ap está disponivel
        if (estado.equals("Indisponivel")){
            btnChat.setEnabled(false);
        }else {
            btnChat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String url = "https://api.whatsapp.com/send?phone=+55" + number;
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
            });

        }


    }

    private void inicializacaoDosCampos() {
        //Inicialização dos campos
        nome = findViewById(R.id.info_nome);
        lugar = findViewById(R.id.info_lugar);
        valor = findViewById(R.id.info_valor);
        numero = findViewById(R.id.info_numero);
        qtdC = findViewById(R.id.info_qtd);
        btnChat = findViewById(R.id.chat);
        data = findViewById(R.id.info_data);
        numAp = findViewById(R.id.info_num_ap);
        acess = findViewById(R.id.info_acess);
        endOnibus = findViewById(R.id.info_end_onibus);
        dsRotas = findViewById(R.id.info_rota);
        lf = findViewById(R.id.info_lf);
        garagem = findViewById(R.id.info_gg);
        mobilia = findViewById(R.id.info_mobilia);
        iluminacao = findViewById(R.id.info_ilum);
        inclusao= findViewById(R.id.info_inclusao);
        ar = findViewById(R.id.info_ar);
        historico = findViewById(R.id.info_hist);

    }
}