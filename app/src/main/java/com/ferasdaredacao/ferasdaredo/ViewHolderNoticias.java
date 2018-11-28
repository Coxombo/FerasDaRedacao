package com.ferasdaredacao.ferasdaredo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolderNoticias extends RecyclerView.ViewHolder {
    TextView titulo;
    ImageView imgArtigo;

    public ViewHolderNoticias(View itemView) {
        super(itemView);
        titulo = itemView.findViewById(R.id.artigoTitulo);
        imgArtigo = itemView.findViewById(R.id.artigoImage);
    }
}
