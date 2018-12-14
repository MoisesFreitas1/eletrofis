package com.a2stars.eletrofis.Model;

/**
 * Created by Moises on 16/02/2018.
 */

public class Assunto {
    public String Tema;
    public String Conceito;
    public String Trecho;
    public int Imagem1;
    public int Imagem2;

    public Assunto(){
    }

    public String getTema() {
        return Tema;
    }

    public void setTema(String tema) {
        Tema = tema;
    }

    public String getConceito() {
        return Conceito;
    }

    public void setConceito(String conceito) {
        Conceito = conceito;
    }

    public String getTrecho() {
        return Trecho;
    }

    public void setTrecho(String trecho) {
        Trecho = trecho;
    }

    public int getImagem1() {
        return Imagem1;
    }

    public void setImagem1(int imagem1) {
        Imagem1 = imagem1;
    }

    public int getImagem2() {
        return Imagem2;
    }

    public void setImagem2(int imagem2) {
        Imagem2 = imagem2;
    }
}
