package br.com.ic.gyaku.model.atleta;

import br.com.ic.gyaku.model.enums.Faixa;
import br.com.ic.gyaku.model.enums.Modalidade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtletaDTO (
        @NotBlank(message = "Informe seu nome")
        String nomeAtleta,
        @NotNull(message = "Informe sua faixa")
        Faixa faixaAtleta,
        @NotNull(message = "Informe sua modalidade")
        Modalidade modalidadeAtleta,
        @NotNull(message = "Informe seu peso")
        Double peso,
        @NotNull(message= "Informe sua idade")
        Integer idade) {
}
