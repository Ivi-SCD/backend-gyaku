package br.com.ic.gyaku.model.atleta;

import br.com.ic.gyaku.model.enums.Faixa;
import br.com.ic.gyaku.model.enums.Modalidade;

public class AtletaDTOResposta {

    String nomeAtleta;
    Faixa faixaAtleta;
    Modalidade modalidadeAtleta;
    Double peso;
    Integer idade;
    String federacao;

    public AtletaDTOResposta() {
    }

    public AtletaDTOResposta(Atleta atleta) {
        this.nomeAtleta = atleta.getNomeAtleta();
        this.faixaAtleta = atleta.getFaixaAtleta();
        this.modalidadeAtleta = atleta.getModalidadeAtleta();
        this.peso = atleta.getPeso();
        this.idade = atleta.getIdade();
        this.federacao = atleta.getFederacao().getNomeFederacao();
    }

    public AtletaDTOResposta(String nomeAtleta, Faixa faixaAtleta, Modalidade modalidadeAtleta, Double peso, Integer idade, String federacao) {
        this.nomeAtleta = nomeAtleta;
        this.faixaAtleta = faixaAtleta;
        this.modalidadeAtleta = modalidadeAtleta;
        this.peso = peso;
        this.idade = idade;
        this.federacao = federacao;
    }

    public String getNomeAtleta() {
        return nomeAtleta;
    }

    public void setNomeAtleta(String nomeAtleta) {
        this.nomeAtleta = nomeAtleta;
    }

    public Faixa getFaixaAtleta() {
        return faixaAtleta;
    }

    public void setFaixaAtleta(Faixa faixaAtleta) {
        this.faixaAtleta = faixaAtleta;
    }

    public Modalidade getModalidadeAtleta() {
        return modalidadeAtleta;
    }

    public void setModalidadeAtleta(Modalidade modalidadeAtleta) {
        this.modalidadeAtleta = modalidadeAtleta;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getFederacao() {
        return federacao;
    }

    public void setFederacao(String federacao) {
        this.federacao = federacao;
    }
}
