package br.com.ufc.houseqxd.model;

import java.io.Serializable;

public class Apartamento implements Serializable {
    private String id;
    private String latitude;
    private String longitude;
    private String nome;
    private String lugar;
    private String qtdComodo;
    private String historico;
    private String iluminacaoPublic;
    private String dstRotaOnibus;
    private String endRotaOnibus;
    private String valor;
    private String inclusao;
    private String possuiAr;
    private String possuiMobilha;
    private String estadoAluguel;
    private String data;
    private String localizacaoFrente;
    private String garagem;
    private String numeroTelefone;
    private String acessibilidade;
    private String numAp;

    public Apartamento(String id, String nome, String lugar,String valor,String numeroTelefone,String estadoAluguel,
                       String qtdComodo,String numAp,String acessibilidade,
                       String endRotaOnibus,String dstRotaOnibus,String data,
                       String localizacaoFrente,String garagem,String possuiMobilha,String iluminacaoPublic,
                       String inclusao,String possuiAr,String historico) {
        this.id = id;
        this.nome = nome;
        this.lugar = lugar;
        this.valor = valor;
        this.estadoAluguel = estadoAluguel;
        this.numeroTelefone = numeroTelefone;
        this.qtdComodo = qtdComodo;
        this.numAp = numAp;
        this.acessibilidade = acessibilidade;
        this.endRotaOnibus = endRotaOnibus;
        this.dstRotaOnibus = dstRotaOnibus;
        this.data = data;
        this.localizacaoFrente = localizacaoFrente;
        this.garagem = garagem;
        this.possuiMobilha = possuiMobilha;
        this.iluminacaoPublic = iluminacaoPublic;
        this.inclusao = inclusao;
        this.possuiAr = possuiAr;
        this.historico = historico;

    }


    public Apartamento() {

    }

    public String getId() {
        return id;
    }

    public void setId(String identificador) {
        this.id = identificador;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
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

    public String getQtdComodo() {
        return qtdComodo;
    }

    public void setQtdComodo(String qtdComodo) {
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

    public String getDstRotaOnibus() {
        return dstRotaOnibus;
    }

    public void setDstRotaOnibus(String dstRotaOnibus) {
        this.dstRotaOnibus = dstRotaOnibus;
    }

    public String getEndRotaOnibus() {
        return endRotaOnibus;
    }

    public void setEndRotaOnibus(String endRotaOnibus) {
        this.endRotaOnibus = endRotaOnibus;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
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

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getAcessibilidade() {
        return acessibilidade;
    }

    public void setAcessibilidade(String acessibilidade) {
        this.acessibilidade = acessibilidade;
    }

    public String getNumAp() {
        return numAp;
    }

    public void setNumAp(String numAp) {
        this.numAp = numAp;
    }
}
