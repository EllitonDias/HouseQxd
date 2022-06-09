package br.com.ufc.houseqxd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ApartamentoAdapter extends RecyclerView.Adapter<ApartamentoViewHolder> {

    private Context context;
    private ArrayList<Apartamento> apartamentos;
    private RecyclerApClick recyclerApClick;
    private ApartamentoViewHolder apartamentoViewHolder;
    private int position;

    public ApartamentoAdapter(Context context, ArrayList<Apartamento> apartamentos, RecyclerApClick recyclerApClick) {
        this.context = context;
        this.apartamentos = apartamentos;
        this.recyclerApClick = recyclerApClick;
    }

    public ApartamentoAdapter() {

    }


    @NonNull
    @Override
    public ApartamentoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.apartamento_linha, parent, false);
        ApartamentoViewHolder apartamentoViewHolder = new ApartamentoViewHolder(view);
        return apartamentoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ApartamentoViewHolder apartamentoViewHolder, int position) {

        Apartamento ap = apartamentos.get(position);
        int posicao = position;
        apartamentoViewHolder.nome.setText(ap.getNome());
        apartamentoViewHolder.lugar.setText(ap.getLugar());
        apartamentoViewHolder.valor.setText(Double.toString(ap.getValor()));

        apartamentoViewHolder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerApClick.btnEdit(posicao,ap);
            }
        });

        apartamentoViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                recyclerApClick.LgClick(ap);
                return false;
            }
        });
        apartamentoViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
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
