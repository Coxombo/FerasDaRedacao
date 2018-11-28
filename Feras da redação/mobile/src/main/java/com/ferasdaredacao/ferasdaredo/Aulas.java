package com.ferasdaredacao.ferasdaredo;

public class Aulas {
    private String aulaId;
    private String titulo;
    private String urlImage;

    public Aulas() {
    }

    public Aulas(String aulaId, String titulo, String urlImage) {
        this.aulaId = aulaId;
        this.titulo = titulo;
        this.urlImage = urlImage;
    }

    public String getAulaId() {
        return aulaId;
    }

    public void setAulaId(String aulaId) {
        this.aulaId = aulaId;
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
