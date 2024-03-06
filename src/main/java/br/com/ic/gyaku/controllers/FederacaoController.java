package br.com.ic.gyaku.controllers;

import br.com.ic.gyaku.model.federacao.Federacao;
import br.com.ic.gyaku.model.federacao.FederacaoDTO;
import br.com.ic.gyaku.services.FederacaoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashSet;

@RestController
@RequestMapping("/federacao")
public class FederacaoController {

    @Autowired
    private FederacaoService federacaoService;

    @GetMapping
    public HashSet<FederacaoDTO> listarFederacoes() {
        return federacaoService.listarFederacoes();
    }

    @GetMapping("nome/{nome}")
    public HashSet<FederacaoDTO> listarFederacoesPorNome(@PathVariable String nome) {
        return federacaoService.listarFederacoesPorNome(nome);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Federacao> salvarFederacao(@RequestBody @Valid FederacaoDTO federacaoDTO) {
        Federacao federacao = federacaoService.salvarFederacao(new Federacao(federacaoDTO));

        return ResponseEntity.created(URI.create("/federacao/" + federacao.getIdFederacao())).body(federacao);
    }


}
