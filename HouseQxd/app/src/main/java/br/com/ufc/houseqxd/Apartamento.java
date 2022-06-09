package br.com.ufc.houseqxd;

import java.io.Serializable;

public class Apartamento implements Serializable {
    private String nome;
    private String lugar;
    private int qtdComodo;
    private String historico;
    private String iluminacaoPublic;
    private int dstRotaOnibus;
    private String endRotaOnibus;
    private double valor;
    private String inclusao;
    private String possuiAr;
    private String possuiMobilha;
    private String estadoAluguel;
    private String data;
    private String localizacaoFrente;
    private String garagem;
    private int numeroTelefone;
    private String acessibilidade;
    private int numAp;

    public Apartamento(String nome, String lugar,double valor) {
        this.nome = nome;
        this.lugar = lugar;
        this.valor = valor;
    }

    public Apartamento() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getQtdComodo() {
        return qtdComodo;
    }

    public void setQtdComodo(int qtdComodo) {
        this.qtdComodo = qtdComodo;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getIluminacaoPublic() {
        return iluminacaoPublic;
    }

    public void setIluminacaoPublic(String iluminacaoPublic) {
        this.iluminacaoPublic = iluminacaoPublic;
    }

    public int getDstRotaOnibus() {
        return dstRotaOnibus;
    }

    public void setDstRotaOnibus(int dstRotaOnibus) {
        this.dstRotaOnibus = dstRotaOnibus;
    }

    public String getEndRotaOnibus() {
        return endRotaOnibus;
    }

    public void setEndRotaOnibus(String endRotaOnibus) {
        this.endRotaOnibus = endRotaOnibus;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getInclusao() {
        return inclusao;
    }

    public void setInclusao(String inclusao) {
        this.inclusao = inclusao;
    }

    public String getPossuiAr() {
        return possuiAr;
    }

    public void setPossuiAr(String possuiAr) {
        this.possuiAr = possuiAr;
    }

    public String getPossuiMobilha() {
        return possuiMobilha;
    }

    public void setPossuiMobilha(String possuiMobilha) {
        this.possuiMobilha = possuiMobilha;
    }

    public String getEstadoAluguel() {
        return estadoAluguel;
    }

    public void setEstadoAluguel(String estadoAluguel) {
        this.estadoAluguel = estadoAluguel;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocalizacaoFrente() {
        return localizacaoFrente;
    }

    public void setLocalizacaoFrente(String localizacaoFrente) {
        this.localizacaoFrente = localizacaoFrente;
    }

    public String getGaragem() {
        return garagem;
    }

    public void setGaragem(String garagem) {
        this.garagem = garagem;
    }

    public int getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(int numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getAcessibilidade() {
        return acessibilidade;
    }

    public void setAcessibilidade(String acessibilidade) {
        this.acessibilidade = acessibilidade;
    }

    public int getNumAp() {
        return numAp;
    }

    public void setNumAp(int numAp) {
        this.numAp = numAp;
    }
}
