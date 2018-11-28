package com.ferasdaredacao.ferasdaredo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolderAulas extends RecyclerView.ViewHolder {
    TextView titulo;
    ImageView imgAula;

    public ViewHolderAulas(View itemView) {
        super(itemView);
        titulo = itemView.findViewById(R.id.aulaTitulo);
        imgAula = itemView.findViewById(R.id.aulaImage);
    }
}
