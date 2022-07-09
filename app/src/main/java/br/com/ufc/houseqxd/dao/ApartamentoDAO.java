package br.com.ufc.houseqxd.dao;

import static com.google.firebase.firestore.DocumentChange.Type.ADDED;
import static com.google.firebase.firestore.DocumentChange.Type.MODIFIED;
import static com.google.firebase.firestore.DocumentChange.Type.REMOVED;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import br.com.ufc.houseqxd.model.Apartamento;
import io.grpc.Context;

public class ApartamentoDAO {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private final static List<Apartamento> apartamentos = new ArrayList<>();

    public void salva(Apartamento apartamento) {
        db.collection("apartamentos")
                .add(apartamento)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                            apartamento.setId(documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
    }

    public void remover(Apartamento apartamento){
            db.collection("apartamentos").document(apartamento.getId()).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });
    }

    public void editar(Apartamento apartamento){
            db.collection("apartamentos").document(apartamento.getId()).set(apartamento).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });;
    }

    public  List<Apartamento> list(){
        db.collection("apartamentos")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            apartamentos.clear();
                            for (QueryDocumentSnapshot doc : task.getResult()) {
                                String id = (String) doc.getId();
                                String nome = (String) doc.getData().get("nome");
                                String lugar = (String) doc.getData().get("lugar");
                                String valor = (String) doc.getData().get("valor");
                                String numero = (String) doc.getData().get("numeroTelefone");
                                String estado = (String) doc.getData().get("estadoAluguel");
                                String qtdcomodo = (String) doc.getData().get("qtdComodo");
                                String numAp = (String) doc.getData().get("numAp");
                                String acessAp = (String) doc.getData().get("acessibilidade");
                                String endOnibusAp = (String) doc.getData().get("endRotaOnibus");
                                String dsRotasAp = (String) doc.getData().get("dstRotaOnibus");
                                String data1 = (String) doc.getData().get("data");
                                String localizacao = (String) doc.getData().get("localizacaoFrente");
                                String garagem = (String) doc.getData().get("garagem");
                                String mobilia = (String) doc.getData().get("possuiMobilha");
                                String iluminacao = (String) doc.getData().get("iluminacaoPublic");
                                String inclusao = (String) doc.getData().get("inclusao");
                                String ar = (String) doc.getData().get("possuiAr");
                                String historico = (String) doc.getData().get("historico");
                                apartamentos.add(new Apartamento(id,nome, lugar, valor, numero, estado, qtdcomodo,
                                        numAp, acessAp, endOnibusAp, dsRotasAp,data1, localizacao, garagem, mobilia, iluminacao,
                                        inclusao, ar, historico));
                            }
                        } else {

                        }
                    }
                });
                return apartamentos;
    }
}

