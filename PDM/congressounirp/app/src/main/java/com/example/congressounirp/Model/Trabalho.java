package com.example.congressounirp.Model;

import android.text.Editable;

public class Trabalho {

    private String siglaNumero; //id
    private String categoria;
    private String instituicao;
    private String autor;
    private String nomeOrientador;
    private String titulo;
    private String codAvaliadorResumo;
    private double notaResumo;
    private String codAvaliadorApres;
    private double notaApres;
    private double notaPostes;
    private double media;

    public Trabalho(){
        siglaNumero = null;
        categoria = null;
        instituicao = null;
        autor = null;
        nomeOrientador = null;
        titulo = null;
        codAvaliadorResumo = null;
        notaResumo = 0;
        codAvaliadorApres = null;
        notaApres = 0;
        notaPostes = 0;
        media = 0;
    }

    public String getSiglaNumero() {
        return siglaNumero;
    }

    public void setSiglaNumero(String siglaNumero) {
        this.siglaNumero = siglaNumero;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNomeOrientador() {
        return nomeOrientador;
    }

    public void setNomeOrientador(String nomeOrientador) {
        this.nomeOrientador = nomeOrientador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCodAvaliadorResumo() {
        return codAvaliadorResumo;
    }

    public void setCodAvaliadorResumo(String codAvaliadorResumo) {
        this.codAvaliadorResumo = codAvaliadorResumo;
    }

    public double getNotaResumo() {
        return notaResumo;
    }

    public void setNotaResumo(double notaResumo) {
        this.notaResumo = notaResumo;
    }

    public String getCodAvaliadorApres() {
        return codAvaliadorApres;
    }

    public void setCodAvaliadorApres(String codAvaliadorApres) {
        this.codAvaliadorApres = codAvaliadorApres;
    }

    public double getNotaApres() {
        return notaApres;
    }

    public void setNotaApres(double notaApres) {
        this.notaApres = notaApres;
    }

    public double getNotaPostes() {
        return notaPostes;
    }

    public void setNotaPostes(double notaPostes) {
        this.notaPostes = notaPostes;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    @Override
    public String toString() {
        return "Identificador = " + siglaNumero + "\n" +
                "Categoria = " + categoria + "\n" +
                "Instituicao = " + instituicao + "\n" +
                "Autor = " + autor + "\n" +
                "Nome Orientador = " + nomeOrientador + "\n" +
                "Titulo = " + titulo + "\n" +
                "CodAvaliadorResumo = " + codAvaliadorResumo + "\n" +
                "Nota Resumo = " + notaResumo + "\n" +
                "CodAvaliadorApres = " + codAvaliadorApres + "\n" +
                "NotaApres = " + notaApres + "\n" +
                "NotaPostes = " + notaPostes + "\n" +
                "Media = " + media;

    }

    public Double calcMedia(){
        return media = (notaApres + notaResumo + notaPostes)/3;
    }

}
