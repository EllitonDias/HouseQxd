package br.com.ufc.houseqxd.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import br.com.ufc.houseqxd.ApAllAdapter;
import br.com.ufc.houseqxd.R;
import br.com.ufc.houseqxd.RecyclerApClick;
import br.com.ufc.houseqxd.dao.ApartamentoDAO;
import br.com.ufc.houseqxd.model.Apartamento;

public class ApartamentoAll extends AppCompatActivity implements RecyclerApClick {
    private RecyclerView recyclerView;
    private ApAllAdapter adapter;
    private ApartamentoDAO dao = new ApartamentoDAO();
    private Button voltar;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartamento_all);
        inicializacaoRecyclerView();
        inicializacaoDosCampos();
        confingBtnVoltar();
        inicializacaoOuvinte();

    }

    private void confingBtnVoltar() {
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ApartamentoAll.this,ApMain.class);
                startActivity(intent);
            }
        });
    }

    private void inicializacaoRecyclerView() {
        recyclerView = findViewById(R.id.recyclerViewAll);
        adapter = new ApAllAdapter(ApartamentoAll.this, dao.list(),this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ApartamentoAll.this,RecyclerView.VERTICAL,false);
        adapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void inicializacaoDosCampos() {
        voltar = findViewById(R.id.voltar);
    }

    @Override
    public void apClick(Apartamento apartamento) {
        Intent intent = new Intent(ApartamentoAll.this, InfoApartamento.class);
        intent.putExtra("apartamento",apartamento);
        startActivity(intent);
    }

    @Override
    public void LgClick(Apartamento apartamento) {

    }

    @Override
    public void btnEdit(int i, Apartamento apartamento) {

    }
    private void inicializacaoOuvinte(){

    }

}