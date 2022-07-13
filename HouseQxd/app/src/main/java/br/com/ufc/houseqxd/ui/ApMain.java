package br.com.ufc.houseqxd.ui;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import br.com.ufc.houseqxd.ApAllAdapter;
import br.com.ufc.houseqxd.ApartamentoAdapter;
import br.com.ufc.houseqxd.R;
import br.com.ufc.houseqxd.RecyclerApClick;
import br.com.ufc.houseqxd.dao.ApartamentoDAO;
import br.com.ufc.houseqxd.model.Apartamento;

public class ApMain extends AppCompatActivity implements RecyclerApClick {
    private static final int NOTIFICATION_REQUEST_CODE = 0;
    private RecyclerView recyclerView;
    private ApartamentoAdapter adapter;
    private ApartamentoDAO dao = new ApartamentoDAO();
    private FloatingActionButton floatingActionButton, btnIr;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ap_my);
        inicializacaoDosCampos();
        confingRecyclerView();
        confingBtnAdd();
        confingBtnAllAp();

    }




    private void confingBtnAllAp() {
        btnIr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ApMain.this, ApartamentoAll.class);
                startActivity(intent);
            }
        });
    }

    private void confingBtnAdd() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ApMain.this, FormApartamento.class);
                startActivity(intent);
            }
        });
    }

    private void confingRecyclerView() {
        adapter = new ApartamentoAdapter(ApMain.this, dao.list(),this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ApMain.this,RecyclerView.VERTICAL,false);
        adapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void inicializacaoDosCampos() {
        recyclerView = findViewById(R.id.recyclerViewAp);
        floatingActionButton = findViewById(R.id.add);
        btnIr = findViewById(R.id.ir);
    }

    @Override
    public void apClick(Apartamento apartamento) {
        Intent intent = new Intent(ApMain.this, InfoApartamento.class);
        intent.putExtra("apartamento",apartamento);
        startActivity(intent);
    }

    @Override
    public void LgClick(Apartamento apartamento) {
        dao.remover(apartamento);
        adapter.notifyDataSetChanged();
        Toast.makeText(ApMain.this,"Você apagou o apartamento: " + apartamento.getNome(),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void btnEdit(int i,Apartamento apartamento) {
        Intent intent = new Intent(ApMain.this, EditApartamento.class);
        intent.putExtra("id",i);
        intent.putExtra("ap",apartamento);
        startActivity(intent);
    }

}