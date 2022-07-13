package br.com.ufc.houseqxd.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.Manifest;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

import br.com.ufc.houseqxd.MaskEditUtil;
import br.com.ufc.houseqxd.MinhaLocalizacaoListener;
import br.com.ufc.houseqxd.model.Apartamento;
import br.com.ufc.houseqxd.ApartamentoAdapter;
import br.com.ufc.houseqxd.dao.ApartamentoDAO;
import br.com.ufc.houseqxd.R;

public class FormApartamento extends AppCompatActivity {
    private EditText nome, lugar,valor,numero,qtdCmd,numApt,acess,endOnibus,dsRotas,lf;
    private Button btnSalvar,btnCancelar,coordenada;
    private RadioButton disp,aguard,ggsim,ggnao,mobiliaS,mobiliaN,luzSim,luzNao,agua,luz,dois,arSim,arNao;
    private RadioButton alto,medio,baixo;
    private ApartamentoDAO dao = new ApartamentoDAO();
    private ApartamentoAdapter adapter = new ApartamentoAdapter();
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_apartamento);


        inicializacaoDosCampos();
        confingBtnSalvar();
        confingBtnCancelar();

    }

    private void confingBtnCancelar() {
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(FormApartamento.this, ApMain.class);
                startActivity(intent);
            }
        });
    }

    private void confingBtnSalvar() {
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Pegando os dados do edit text
                String nomeF = nome.getText().toString();
                String valorF = valor.getText().toString();
                String lugarF = lugar.getText().toString();
                String numeroF = numero.getText().toString();
                String qtdF = qtdCmd.getText().toString();
                String numAp = numApt.getText().toString();
                String acessApart = acess.getText().toString();
                String endOnibusAp = endOnibus.getText().toString();
                String dsRotasAp = dsRotas.getText().toString();
                String localizacaoF = lf.getText().toString();

                ValidandoCampos(nomeF, valorF, lugarF, numeroF, qtdF, numAp,acessApart,endOnibusAp,dsRotasAp,localizacaoF);

            }

            private void ValidandoCampos(String nomeF, String valorF, String lugarF, String numeroF, String qtdF,
                                         String numAp,String acessApart,String endOnibusAp,String dsRotasAp,String localizacaoF) {
                if(nomeF.equals("") && valorF.equals("") && lugarF.equals("") && numeroF.equals("")
                        && qtdF.equals("") && numAp.equals("")&& acessApart.equals("") && endOnibusAp.equals("")
                        && dsRotasAp.equals("") && localizacaoF.equals("")){

                    Toast.makeText(FormApartamento.this,"Por favor, preencher todos os campos",Toast.LENGTH_SHORT).show();
                }else if(nomeF.equals("") || valorF.equals("") || lugarF.equals("") ||
                        numeroF.equals("")|| qtdF.equals("")|| numAp.equals("") || acessApart.equals("")|| endOnibusAp.equals("")||
                        dsRotasAp.equals("") || localizacaoF.equals("")){
                        Toast.makeText(FormApartamento.this,"Por favor, preencher todos os campos",Toast.LENGTH_SHORT).show();
                }else {
                    Apartamento ap = creaApartamento();
                    salvarAp(ap);
                }
            }

            private void salvarAp(Apartamento ap) {
                dao.salva(ap);
                adapter.notifyDataSetChanged();
                Intent intent = new Intent(FormApartamento.this, ApMain.class);
                startActivity(intent);
            }

            private Apartamento creaApartamento() {
                //Creando apartamento
                String id = "";
                String radio = getEstado();
                String verificaG = getVerificar();
                String verificaMobilia = getVerificarMobilia();
                String verificaIluminacao = getVerificarIluminacao();
                String verificaInclusao = getVerificarInclusao();
                String verificaAr = getVerificarAr();
                String verificarHistorico = getVerificarHistorico();
                String nome1 = nome.getText().toString();
                String lugar1 = lugar.getText().toString();
                String valor1 = valor.getText().toString();
                String estado = radio;
                String numero1 = numero.getText().toString();
                String qtdcomodo1 = qtdCmd.getText().toString();
                String numAp = numApt.getText().toString();
                String acessAp = acess.getText().toString();
                String endOnibusAp = endOnibus.getText().toString();
                String dsRotasAp = dsRotas.getText().toString();
                String data1 = "";
                String localizacaoF = lf.getText().toString();
                String garagemF = verificaG;
                String mobiliaF = verificaMobilia;
                String iluminacao = verificaIluminacao;
                String inclusao = verificaInclusao;
                String ar = verificaAr;
                String historico = verificarHistorico;
                return new Apartamento(id,nome1, lugar1, valor1, numero1, estado, qtdcomodo1,
                        numAp,acessAp,endOnibusAp,dsRotasAp,data1,localizacaoF,garagemF,mobiliaF,iluminacao,inclusao,ar,historico);
            }
            //Verificação dos radios
            private String getVerificarHistorico() {
                String historico;
                if (alto.isChecked()){
                    historico = "Alto";
                }else if (medio.isChecked()){
                    historico = "Médio";
                }else{
                    historico = "Baixo";
                }
                return historico;
            }

            private String getVerificarAr() {
                String ar;
                if (arSim.isChecked()){
                    ar = "Sim";
                }else if (arNao.isChecked()){
                    ar = "Não";
                }else{
                    ar = "Não";
                }
                return ar;
            }

            private String getVerificarInclusao() {
                String inclusao;
                if (agua.isChecked()){
                    inclusao = "Água";
                }else if (luz.isChecked()){
                    inclusao = "Luz";
                }else if(dois.isChecked()){
                    inclusao = "Os dois";
                }
                else{
                    inclusao = "Não";
                }
                return inclusao;
            }


            private String getVerificarIluminacao() {
                String luz;
                if (luzSim.isChecked()){
                    luz = "Sim";
                }else if (luzNao.isChecked()){
                    luz = "Não";
                }else{
                    luz = "Não";
                }
                return luz;
            }

            private String getVerificarMobilia() {
                String mobilia;
                if (mobiliaS.isChecked()){
                    mobilia = "Sim";
                }else if (mobiliaN.isChecked()){
                    mobilia = "Não";
                }else{
                    mobilia = "Não";
                }
                return mobilia;
            }

            private String getVerificar() {
                String garagem;
                if (ggsim.isChecked()){
                    garagem = "Sim";
                }else if(ggnao.isChecked()){
                    garagem = "Não";
                }else{
                    garagem = "Não";
                }
                return garagem;
            }

            @NonNull
            private String getEstado() {
                String radio;
                if (disp.isChecked()){
                    radio = "Disponivel";
                }else if (aguard.isChecked()){
                    radio = "Aguardando";
                }else{
                    radio = "Disponivel";
                }
                return radio;
            }
        });
    }

    private void inicializacaoDosCampos() {
        //Inicialização dos campos
        nome = findViewById(R.id.edt_nome);
        lugar = findViewById(R.id.edt_lugar);
        valor = findViewById(R.id.edt_valor);
        btnSalvar = findViewById(R.id.salvar);
        btnCancelar = findViewById(R.id.cancelar);
        disp = findViewById(R.id.disponivel);
        aguard = findViewById(R.id.aguardando);
        numero = findViewById(R.id.edt_numero);
        qtdCmd = findViewById(R.id.edt_qtd);
        numApt = findViewById(R.id.edt_numApt);
        acess = findViewById(R.id.edt_acess);
        endOnibus = findViewById(R.id.edt_end_onibus);
        dsRotas = findViewById(R.id.edt_dst_onibus);
        lf = findViewById(R.id.edt_sol);
        ggsim = findViewById(R.id.gsim);
        ggnao = findViewById(R.id.gnao);
        mobiliaS = findViewById(R.id.mbsim);
        mobiliaN = findViewById(R.id.mbnao);
        luzSim = findViewById(R.id.ilum_sim);
        luzNao = findViewById(R.id.ilum_nao);
        agua = findViewById(R.id.agua);
        dois = findViewById(R.id.os_dois);
        luz = findViewById(R.id.luz);
        arSim = findViewById(R.id.arsim);
        arNao = findViewById(R.id.arnao);
        alto = findViewById(R.id.alto);
        medio = findViewById(R.id.medio);
        baixo = findViewById(R.id.baixo);




        TextWatcher mask = MaskEditUtil.mask(numero, "(##)# ####-####");
        numero.addTextChangedListener(mask);
    }

}