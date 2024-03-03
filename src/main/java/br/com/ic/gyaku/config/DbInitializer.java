package br.com.ic.gyaku.config;

import br.com.ic.gyaku.model.atleta.AtletaDTO;
import br.com.ic.gyaku.model.enums.Faixa;
import br.com.ic.gyaku.model.enums.Modalidade;
import br.com.ic.gyaku.model.federacao.Federacao;
import br.com.ic.gyaku.model.federacao.FederacaoDTO;
import br.com.ic.gyaku.services.AtletaService;
import br.com.ic.gyaku.services.FederacaoService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DbInitializer {

    @Autowired
    private FederacaoService federacaoService;

    @Autowired
    private AtletaService atletaService;

    @PostConstruct
    public void init() {
        FederacaoDTO federacaoDTO1 = new FederacaoDTO("UKIPE");
        FederacaoDTO federacaoDTO2 = new FederacaoDTO("UKIPA");
        FederacaoDTO federacaoDTO3 = new FederacaoDTO("UKIPI");

        AtletaDTO atletaDTO1 = new AtletaDTO("Clara Sensei", Faixa.PRETA, Modalidade.KUMITE, 72.0, 18, "UKIPE");
        AtletaDTO atletaDTO2 = new AtletaDTO("Montanha do Plug", Faixa.ROXA, Modalidade.KATA_KUMITE, 140.0, 20, "UKIPA");
        AtletaDTO atletaDTO3 = new AtletaDTO("Coelhao Sem Vergonha", Faixa.BRANCA, Modalidade.KUMITE, 93.0, 20, "UKIPI");

        federacaoService.salvarFederacao(new Federacao(federacaoDTO1));
        federacaoService.salvarFederacao(new Federacao(federacaoDTO2));
        federacaoService.salvarFederacao(new Federacao(federacaoDTO3));

        atletaService.salvarAtleta(atletaDTO1);
        atletaService.salvarAtleta(atletaDTO2);
        atletaService.salvarAtleta(atletaDTO3);

    }
}
