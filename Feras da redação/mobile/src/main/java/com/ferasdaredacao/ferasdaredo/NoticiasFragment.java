package com.ferasdaredacao.ferasdaredo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class NoticiasFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    FirebaseRecyclerAdapter<Noticias, ViewHolderNoticias> adapter;
    final Query query = FirebaseDatabase.getInstance()
            .getReference()
            .child("artigos");

    public NoticiasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FirebaseRecyclerOptions<Noticias> options = new FirebaseRecyclerOptions.Builder<Noticias>()
                .setQuery(query, Noticias.class)
                .build();
        adapter = new FirebaseRecyclerAdapter<Noticias, ViewHolderNoticias>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ViewHolderNoticias holder, int position, @NonNull Noticias model) {
                holder.titulo.setText(model.getTitulo());
                GlideApp.with(getContext())
                        .load(model.getUrlImage())
                        .into(holder.imgArtigo);
            }

            @NonNull
            @Override
            public ViewHolderNoticias onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.card_atualidades, parent, false);
                return new ViewHolderNoticias(view);
            }
        };
        view = inflater.inflate(R.layout.fragment_noticias, container, false);
        recyclerView = view.findViewById(R.id.recyclerNews);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    public static NoticiasFragment newInstance() {
        return new NoticiasFragment();
    }
}
