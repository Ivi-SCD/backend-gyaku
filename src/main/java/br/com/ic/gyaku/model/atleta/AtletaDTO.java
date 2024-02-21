package br.com.ic.gyaku.model.atleta;

import br.com.ic.gyaku.model.enums.Faixa;
import br.com.ic.gyaku.model.enums.Modalidade;

public record AtletaDTO (String nomeAtleta, Faixa faixaAtleta, Modalidade modalidadeAtleta, Double peso, Integer idade) {
}
