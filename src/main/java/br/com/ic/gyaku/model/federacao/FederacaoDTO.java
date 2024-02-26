package br.com.ic.gyaku.model.federacao;

import jakarta.validation.constraints.NotBlank;

public class FederacaoDTO {

    @NotBlank
    private String nomeFederacao;

    public FederacaoDTO() {

    }
    public FederacaoDTO(String nomeFederacao) {
        this.nomeFederacao = nomeFederacao;
    }

    public String getNomeFederacao() {
        return nomeFederacao;
    }

    public void setNomeFederacao(String nomeFederacao) {
        this.nomeFederacao = nomeFederacao;
    }

}
