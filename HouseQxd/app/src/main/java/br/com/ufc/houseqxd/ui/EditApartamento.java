package br.com.ufc.houseqxd.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import br.com.ufc.houseqxd.MaskEditUtil;
import br.com.ufc.houseqxd.model.Apartamento;
import br.com.ufc.houseqxd.ApartamentoAdapter;
import br.com.ufc.houseqxd.dao.ApartamentoDAO;
import br.com.ufc.houseqxd.R;

public class EditApartamento extends AppCompatActivity {
    private EditText nome,lugar,valor,numero,qtdC,data,numAp,acess,endOnibus,dsRotas,lf;
    private Button btnSalvar,btnCancelar;
    private RadioButton disp,agurd,indisp,ggsim,ggnao,mobiliaS,mobiliaN,luzSim,luzNao,agua,dois,luz,nao,arSim,arNao;
    private RadioButton alto,medio,baixo;
    private ApartamentoDAO dao = new ApartamentoDAO();
    private ApartamentoAdapter adapter = new ApartamentoAdapter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_apartamento);

        inicializacaoDosCampos();

        int posicao = getIntent().getIntExtra("id",0);
        //Pegando os dados
            Apartamento apartamento = (Apartamento) getIntent().getSerializableExtra("ap");
            String data1 = apartamento.getData();
            String nomeAp = apartamento.getNome();
            String lugarAp = apartamento.getLugar();
            String valorAp = apartamento.getValor();
            String radio = apartamento.getEstadoAluguel();
            String garagem = apartamento.getGaragem();
            String mobilha = apartamento.getPossuiMobilha();
            String numeroTelefone = apartamento.getNumeroTelefone();
            String iluminacao = apartamento.getIluminacaoPublic();
            String inclusao = apartamento.getInclusao();
            String ar = apartamento.getPossuiAr();
            String historico = apartamento.getHistorico();
            String numeroAp = apartamento.getNumAp();
            String qtdAp = apartamento.getQtdComodo();
            nome.setText(nomeAp);
            lugar.setText(lugarAp);
            numero.setText(numeroTelefone);
            valor.setText(valorAp);
            qtdC.setText(qtdAp);
            data.setText(data1);
            numAp.setText(numeroAp);
             acess.setText(apartamento.getAcessibilidade());
             endOnibus.setText(apartamento.getEndRotaOnibus());
            dsRotas.setText(apartamento.getDstRotaOnibus());
            lf.setText(apartamento.getLocalizacaoFrente());


        configBtnSalvar(posicao, apartamento, nomeAp, radio, garagem, mobilha, iluminacao, inclusao, ar, historico);
        configBtnCancelar();

    }

    private void configBtnCancelar() {
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditApartamento.this,ApMain.class);
                startActivity(intent);
            }
        });
    }

    private void configBtnSalvar(int posicao, Apartamento apartamento, String nomeAp, String radio, String garagem,String mobilha, String iluminacao, String inclusao, String ar,String historico) {
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditApartamento.this, ApMain.class);
                String nomeFinal = nome.getText().toString();
                String lugarFinal = lugar.getText().toString();
                String valorV = valor.getText().toString();
                String radioFinal ;
                String numeroF = numero.getText().toString();
                String qtdComodos = qtdC.getText().toString();
                String numAFinal = numAp.getText().toString();
                String acessApart = acess.getText().toString();
                String endOnibusAp = endOnibus.getText().toString();
                String dsRotasAp = dsRotas.getText().toString();
                String localizacaoF = lf.getText().toString();
                //editando radio btn
                radioFinal = getEstado();
                String verificaG = getVerificar();
                String verificaMobilia = getVerificarMobilia();
                String verificaIluminacao = getVerificarIluminacao();
                String verificaInclusao = getVerificarInclusao();
                String verificaAr = getVerificarAr();
                String verificarHistorico = getVerificarHistorico();
                //validando campos
                validandoCampos(intent, nomeFinal, lugarFinal, valorV, radioFinal,verificaG,verificaMobilia,verificaIluminacao,verificaInclusao,verificaAr,verificarHistorico, numeroF, qtdComodos,numAFinal,acessApart,endOnibusAp,dsRotasAp,localizacaoF);
            }

            private void validandoCampos(Intent intent, String nomeFinal, String lugarFinal, String valorV, String radioFinal,String verificaG,String verificaMobilia,String verificaIluminacao,String verificaInclusao, String verificaAr,String verificarHistorico, String numeroF, String qtdComodos,
                                         String numAFinal,String acessApart,String endOnibusAp,String dsRotasAp,String localizacaoF) {
                if(nomeFinal.equals("") && lugarFinal.equals("") && valor.getText().toString().equals("") &&
                        numeroF.equals("") && qtdComodos.equals("")&& acessApart.equals("") && endOnibusAp.equals("")
                        && dsRotasAp.equals("") && localizacaoF.equals("")){
                    Toast.makeText(EditApartamento.this,"Por favor, preencher todos os campos",Toast.LENGTH_SHORT).show();
                }else if(nomeFinal.equals("") || lugarFinal.equals("") || valorV.equals("")|| numeroF.equals("") || qtdComodos.equals("") ||  numAFinal.equals("") || acessApart.equals("")|| endOnibusAp.equals("")||
                        dsRotasAp.equals("") || localizacaoF.equals("")){
                    Toast.makeText(EditApartamento.this,"Por favor, preencher todos os campos",Toast.LENGTH_SHORT).show();
                }else{
                    String dataf = data.getText().toString();
                    apartamento.setNome(nomeFinal);
                    apartamento.setLugar(lugarFinal);
                    apartamento.setValor(valorV);
                    apartamento.setEstadoAluguel(radioFinal);
                    apartamento.setNumeroTelefone(numeroF);
                    apartamento.setQtdComodo(qtdComodos);
                    apartamento.setData(dataf);
                    apartamento.setNumAp(numAFinal);
                    apartamento.setAcessibilidade(acessApart);
                    apartamento.setEndRotaOnibus(endOnibusAp);
                    apartamento.setDstRotaOnibus(dsRotasAp);
                    apartamento.setLocalizacaoFrente(localizacaoF);
                    apartamento.setGaragem(verificaG);
                    apartamento.setIluminacaoPublic(verificaIluminacao);
                    apartamento.setPossuiMobilha(verificaMobilia);
                    apartamento.setPossuiAr(verificaAr);
                    apartamento.setInclusao(verificaInclusao);
                    apartamento.setHistorico(verificarHistorico);

                    dao.editar(apartamento);
                    Toast.makeText(EditApartamento.this,"Você editou o apartamento: "+ nomeAp,Toast.LENGTH_LONG).show();
                    adapter.notifyDataSetChanged();
                    startActivity(intent);
                }
            }
            private String getVerificarHistorico() {
                String historicoF;
                if (alto.isChecked()){
                    historicoF = "Alto";
                }else if (medio.isChecked()){
                    historicoF = "Médio";
                }else if(baixo.isChecked()){
                    historicoF = "Baixo";
                }else{
                    historicoF = historico;
                }
                return historicoF;
            }

            private String getVerificarAr() {
                String arF;
                if (arSim.isChecked()){
                    arF = "Sim";
                }else if (arNao.isChecked()){
                    arF = "Não";
                }else{
                    arF = ar;
                }
                return arF;
            }

            private String getVerificarInclusao() {
                String inclusaoF;
                if (agua.isChecked()){
                    inclusaoF = "Água";
                }else if (luz.isChecked()){
                    inclusaoF = "Luz";
                }else if(luzNao.isChecked()){
                    inclusaoF = "Não";
                }else if (dois.isChecked()){
                    inclusaoF = "Os dois";
                }else{
                    inclusaoF = inclusao;
                }
                return inclusaoF;
            }


            private String getVerificarIluminacao() {
                String luzF;
                if (luzSim.isChecked()){
                    luzF = "Sim";
                }else if (luzNao.isChecked()){
                    luzF = "Não";
                }else{
                    luzF = iluminacao;
                }
                return luzF;
            }

            private String getVerificarMobilia() {
                String mob;
                if (mobiliaS.isChecked()){
                    mob = "Sim";
                }else if (mobiliaN.isChecked()){
                    mob = "Não";
                }else{
                    mob = mobilha;
                }
                return mob;
            }

            private String getVerificar() {
                String garagemF;
                if (ggsim.isChecked()){
                    garagemF = "Sim";
                }else if(ggnao.isChecked()){
                    garagemF = "Não";
                }else{
                    garagemF = garagem;
                }
                return garagemF;
            }


            private String getEstado() {
                String radioFinal;
                if (disp.isChecked()){
                    radioFinal = "Disponivel";
                }else if(agurd.isChecked()){
                    radioFinal = "Aguardando";
                }else if(indisp.isChecked()){
                    radioFinal = "Indisponivel";
                }else{
                    radioFinal = radio;
                }
                return radioFinal;
            }

        });
    }

    private void inicializacaoDosCampos() {
        nome = findViewById(R.id.up_nome);
        lugar = findViewById(R.id.up_lugar);
        valor = findViewById(R.id.up_valor);
        numero = findViewById(R.id.up_numero);
        qtdC = findViewById(R.id.up_qtd);
        data = findViewById(R.id.up_data);
        numAp = findViewById(R.id.up_num_ap);
        TextWatcher mask = MaskEditUtil.mask(numero, "(##)# ####-####");
        numero.addTextChangedListener(mask);
        TextWatcher maskdata = MaskEditUtil.mask(data, "##/##/####");
        data.addTextChangedListener(maskdata);
        disp = findViewById(R.id.up_disponivel);
        agurd = findViewById(R.id.up_aguardando);
        indisp = findViewById(R.id.up_indisponivel);
        acess = findViewById(R.id.up_acess);
        endOnibus = findViewById(R.id.up_end_onibus);
        dsRotas = findViewById(R.id.up_dst_onibus);
        lf = findViewById(R.id.up_sol);
        ggsim = findViewById(R.id.gsim);
        ggnao = findViewById(R.id.gnao);
        mobiliaS = findViewById(R.id.mbsim);
        mobiliaN = findViewById(R.id.mbnao);
        luzSim = findViewById(R.id.ilum_sim);
        luzNao = findViewById(R.id.ilum_nao);
        agua = findViewById(R.id.agua);
        luz = findViewById(R.id.luz);
        dois = findViewById(R.id.os_dois);
        nao = findViewById(R.id.nao);
        arSim = findViewById(R.id.arsim);
        arNao = findViewById(R.id.arnao);
        alto = findViewById(R.id.alto);
        medio = findViewById(R.id.medio);
        baixo = findViewById(R.id.baixo);
        btnSalvar = findViewById(R.id.atualizar);
        btnCancelar = findViewById(R.id.btn_cancelar);
    }
}