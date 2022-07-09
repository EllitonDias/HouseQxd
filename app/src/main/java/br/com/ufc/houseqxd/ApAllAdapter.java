package br.com.ufc.houseqxd;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.ufc.houseqxd.model.Apartamento;

public class ApAllAdapter extends RecyclerView.Adapter<ApartamentoAllViewHolder> {
    private Context context;
    private List<Apartamento> apartamentos;
    private RecyclerApClick recyclerApClick;
    private ApartamentoAllViewHolder apartamentoAllViewHolder;

    public ApAllAdapter(Context context, List<Apartamento> apartamentos, RecyclerApClick recyclerApClick) {
        this.context = context;
        this.apartamentos = apartamentos;
        this.recyclerApClick = recyclerApClick;
    }

    @NonNull
    @Override
    public ApartamentoAllViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ap_all, parent, false);
        ApartamentoAllViewHolder apartamentoAllViewHolder = new ApartamentoAllViewHolder(view);
        return apartamentoAllViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ApartamentoAllViewHolder apartamentoAllViewHolder, int position) {

        Apartamento ap = apartamentos.get(position);
        int posicao = position;
        apartamentoAllViewHolder.nomeAll.setText(ap.getNome());
        apartamentoAllViewHolder.lugarAll.setText(ap.getLugar());
        apartamentoAllViewHolder.valorAll.setText(ap.getValor());
        apartamentoAllViewHolder.alugadoAll.setText(ap.getEstadoAluguel());



        if (ap.getEstadoAluguel().equals("Disponivel")){
            apartamentoAllViewHolder.alugadoAll.setTextColor(Color.parseColor("#00DF03"));
        }else if (ap.getEstadoAluguel().equals("Aguardando")){
            apartamentoAllViewHolder.alugadoAll.setTextColor(Color.parseColor("#ECFF00"));
        }else{
            apartamentoAllViewHolder.alugadoAll.setTextColor(Color.parseColor("#FFFFFF"));
            apartamentoAllViewHolder.card.setCardBackgroundColor(Color.parseColor("#713131"));
        }






        apartamentoAllViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerApClick.apClick(ap);
            }
        });
    }

    @Override
    public int getItemCount() {
        return apartamentos.size();
    }
}
