package com.ferasdaredacao.ferasdaredo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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

public class AulasFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    FirebaseRecyclerAdapter<Aulas, ViewHolderAulas> adapter;
    final Query query = FirebaseDatabase.getInstance()
            .getReference()
            .child("aulas");

    public AulasFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FirebaseRecyclerOptions<Aulas> options = new FirebaseRecyclerOptions.Builder<Aulas>()
                .setQuery(query, Aulas.class)
                .build();
        adapter = new FirebaseRecyclerAdapter<Aulas, ViewHolderAulas>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ViewHolderAulas holder, int position, @NonNull Aulas model) {
                holder.titulo.setText(model.getTitulo());
                GlideApp.with(getContext())
                        .load(model.getUrlImage())
                        .into(holder.imgAula);
            }

            @NonNull
            @Override
            public ViewHolderAulas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.card_aulas, parent, false);
                return new ViewHolderAulas(view);
            }
        };
        view = inflater.inflate(R.layout.fragment_aulas, container, false);
        recyclerView = view.findViewById(R.id.recyclerAulas);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(),
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

    public static AulasFragment newInstance(){return new AulasFragment();}
}
