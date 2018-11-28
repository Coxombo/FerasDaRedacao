package com.ferasdaredacao.ferasdaredo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;

public class PerfilFragment extends Fragment {
    FirebaseAuth auth;
    ImageView imageView;
    TextView txtEmail, txtNome;
    Button buttonSair, buttonDeletar;
    View view;
    public PerfilFragment newInstance() {
        return new PerfilFragment();  }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perfil, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        imageView = view.findViewById(R.id.perfilImage);
        txtNome = view.findViewById(R.id.perfilName);
        txtEmail = view.findViewById(R.id.perfilEmail);
        buttonSair = view.findViewById(R.id.btPerfilSair);
        buttonDeletar = view.findViewById(R.id.btPerfilDeletar);
        txtNome.setText(user.getDisplayName());
        txtEmail.setText(user.getEmail());
        GlideApp.with(getContext())
                .load(user.getPhotoUrl())
                .circleCrop()
                .into(imageView);
        buttonSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AuthUI.getInstance()
                        .signOut(getContext())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            public void onComplete(@NonNull Task<Void> task) {
                                startActivity(new Intent(
                                        getContext(), LoginRegisterActivity.class
                                ));
                            }
                        });
            }
        });
        buttonDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AuthUI.getInstance()
                        .delete(getContext())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                startActivity(new Intent(
                                        getContext(), LoginRegisterActivity.class
                                ));
                            }
                        });
            }
        });
    }
}
