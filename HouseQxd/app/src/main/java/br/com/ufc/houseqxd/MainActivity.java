package br.com.ufc.houseqxd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements RecyclerApClick {
    private RecyclerView recyclerView;
    private ApartamentoAdapter adapter;
    private ApartamentoDAO dao = new ApartamentoDAO();
    private FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewAp);
        floatingActionButton = findViewById(R.id.add);


        adapter = new ApartamentoAdapter(MainActivity.this, dao.todos(),this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FormApartamento.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void apClick(Apartamento apartamento) {
        Intent intent = new Intent(MainActivity.this, InfoApartamento.class);
        intent.putExtra("apartamento",apartamento);
        startActivity(intent);
    }

    @Override
    public void LgClick(Apartamento apartamento) {
        dao.remover(apartamento);
        adapter.notifyDataSetChanged();
        Toast.makeText(MainActivity.this,"Você apagou o apartamento: " + apartamento.getNome(),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void btnEdit(int i,Apartamento apartamento) {
        Intent intent = new Intent(MainActivity.this, EditarApartamento.class);
        intent.putExtra("id",i);
        intent.putExtra("ap",apartamento);
        startActivity(intent);
    }
}