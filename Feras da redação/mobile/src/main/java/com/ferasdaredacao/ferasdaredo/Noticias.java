package com.ferasdaredacao.ferasdaredo;

public class Noticias {
    private String artId;
    private String titulo;
    private String urlImage;

    public Noticias(String artId, String titulo, String urlImage) {
        this.artId = artId;
        this.titulo = titulo;
        this.urlImage = urlImage;
    }

    public Noticias() {
    }

    public String getArtId() {
        return artId;
    }

    public void setArtId(String artId) {
        this.artId = artId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
