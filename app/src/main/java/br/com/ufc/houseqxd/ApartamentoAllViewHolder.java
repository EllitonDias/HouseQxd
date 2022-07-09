package br.com.ufc.houseqxd;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ApartamentoAllViewHolder extends RecyclerView.ViewHolder {

    TextView nomeAll,lugarAll,valorAll,alugadoAll;
    CardView card;
    public ApartamentoAllViewHolder(@NonNull View itemView) {
        super(itemView);
        nomeAll = itemView.findViewById(R.id.all_nome);
        lugarAll = itemView.findViewById(R.id.all_lugar);
        valorAll = itemView.findViewById(R.id.all_valor);
        alugadoAll = itemView.findViewById(R.id.all_aluguel);
        card = itemView.findViewById(R.id.cardView);

    }
}
