package br.com.ic.gyaku.model.federacao;

import br.com.ic.gyaku.model.atleta.Atleta;
import br.com.ic.gyaku.model.equipe.Equipe;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Federacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_federacao")
    private Integer idFederacao;
    @Column(name = "nome_federacao")
    private String nomeFederacao;
    @OneToMany(mappedBy = "federacao")
    List<Atleta> atletas = new ArrayList<>();
    @OneToMany(mappedBy = "federacao")
    List<Equipe> equipes = new ArrayList<>();

    public Federacao() {
    }

    public Federacao(String nomeFederacao) {
        this.nomeFederacao = nomeFederacao;
    }

    public Federacao(FederacaoDTO federacaoDTO) {
        this.nomeFederacao = federacaoDTO.getNomeFederacao();
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

    public void adicionarAtleta(Atleta atleta) {
        this.atletas.add(atleta);
    }

    public void removerAtleta(Atleta atleta) {
        this.atletas.remove(atleta);
    }
    public void adicionarEquipe(Equipe equipe) {
        this.equipes.add(equipe);
    }

    public void removerEquipe(Equipe equipe) {
        this.equipes.remove(equipe);
    }

    @Override
    public String toString() {
        return "Federacao{" +
                "idFederacaop=" + idFederacao +
                ", nomeFederacao='" + nomeFederacao + '\'' +
                '}';
    }
}
