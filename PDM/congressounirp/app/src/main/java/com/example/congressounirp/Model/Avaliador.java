package com.example.congressounirp.Model;

public class Avaliador {

    private String idAvaliador;
    private String nomeAvaliador;
    private String email;
    private String curso;
    private String area;
    private String celular;

    public Avaliador(){
        idAvaliador = null;
        nomeAvaliador = null;
        email = null;
        curso = null;
        area = null;
        celular = null;
    }

    public String getIdAvaliador() {
        return idAvaliador;
    }

    public void setIdAvaliador(String idAvaliador) {
        this.idAvaliador = idAvaliador;
    }

    public String getNomeAvaliador() {
        return nomeAvaliador;
    }

    public void setNomeAvaliador(String nomeAvaliador) {
        this.nomeAvaliador = nomeAvaliador;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Avaliador:\n  " +
                "idAvaliador: " + idAvaliador + "\n" +
                "NomeAvaliador: " + nomeAvaliador + "\n" +
                "Email: " + email + "\n" +
                "Curso:'" + curso + "\n" +
                "Area: " + area + "\n" +
                "Celular: " + celular + "\n" ;
    }
}
