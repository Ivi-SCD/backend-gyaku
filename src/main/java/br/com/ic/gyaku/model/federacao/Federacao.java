package br.com.ic.gyaku.model.federacao;

import jakarta.persistence.*;

@Entity
public class Federacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_federacao")
    private Integer idFederacao;
    @Column(name = "nome_federacao")
    private String nomeFederacao;

    public Federacao() {
    }

    public Federacao(String nomeFederacao) {
        this.nomeFederacao = nomeFederacao;
    }

    public Federacao(FederacaoDTO federacaoDTO) {
        this.nomeFederacao = federacaoDTO.nomeFederacao();
    }

    public Integer getIdFederacao() {
        return idFederacao;
    }

    public void setIdFederacao(Integer idFederacao) {
        this.idFederacao = idFederacao;
    }

    public String getNomeFederacao() {
        return nomeFederacao;
    }

    public void setNomeFederacao(String nomeFederacao) {
        this.nomeFederacao = nomeFederacao;
    }

    @Override
    public String toString() {
        return "Federacao{" +
                "idFederacaop=" + idFederacao +
                ", nomeFederacao='" + nomeFederacao + '\'' +
                '}';
    }
}
