package br.com.ufc.houseqxd;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ApartamentoViewHolder extends RecyclerView.ViewHolder {
    TextView nome,lugar,valor;
    Button edit;
    private RecyclerApClick recyclerApClick;

    public ApartamentoViewHolder(@NonNull View itemView) {
        super(itemView);
        nome = itemView.findViewById(R.id.nome);
        lugar = itemView.findViewById(R.id.lugar);
        valor = itemView.findViewById(R.id.valor);
        edit = itemView.findViewById(R.id.btn_edit);

    }
}
