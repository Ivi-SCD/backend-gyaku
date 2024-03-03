package br.com.ic.gyaku.model.atleta;

import br.com.ic.gyaku.model.enums.Faixa;
import br.com.ic.gyaku.model.enums.Modalidade;
import br.com.ic.gyaku.model.federacao.Federacao;
import jakarta.persistence.*;

@Entity
public class Atleta {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_atleta")
    private Integer idAtleta;
    @Column(name = "nome_atleta")
    private String nomeAtleta;
    @Column(name = "faixa_atleta")
    private Faixa faixaAtleta;
    @Column(name = "modalidade_atleta")
    private Modalidade modalidadeAtleta;
    @Column(precision = 1, nullable = false)
    private Double peso;
    @Column(nullable = false)
    private Integer idade;

    @ManyToOne
    @JoinColumn(name = "id_federacao")
    private Federacao federacao;

    public Atleta() {
    }

    public Atleta(String nomeAtleta, Faixa faixaAtleta, Modalidade modalidadeAtleta, Double peso, Integer idade, Federacao federacao) {
        this.nomeAtleta = nomeAtleta;
        this.faixaAtleta = faixaAtleta;
        this.modalidadeAtleta = modalidadeAtleta;
        this.peso = peso;
        this.idade = idade;
        this.federacao = federacao;
    }

    public Atleta(AtletaDTO atletaDTO) {
        this.nomeAtleta = atletaDTO.nomeAtleta();
        this.faixaAtleta = atletaDTO.faixaAtleta();
        this.modalidadeAtleta = atletaDTO.modalidadeAtleta();
        this.peso = atletaDTO.peso();
        this.idade = atletaDTO.idade();
    }

    public Integer getIdAtleta() {
        return idAtleta;
    }

    public void setIdAtleta(Integer idAtleta) {
        this.idAtleta = idAtleta;
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

    public Federacao getFederacao() {
        return federacao;
    }

    public void setFederacao(Federacao federacao) {
        this.federacao = federacao;
    }
}
