package br.com.ic.gyaku.controller;

import br.com.ic.gyaku.model.federacao.Federacao;
import br.com.ic.gyaku.model.federacao.FederacaoDTO;
import br.com.ic.gyaku.repositories.FederacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/federacao")
public class FederacaoController {

    @Autowired
    private FederacaoRepository federacaoRepository;

    @GetMapping
    public List<Federacao> listarFederacoes() {
        return federacaoRepository.findAll();
    }

    @GetMapping("nome/{nome}")
    public List<Federacao> listarFederacoesPorNome(@PathVariable String nome) {
        return federacaoRepository.findByNomeFederacao(nome);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Federacao> salvarFederacao(@RequestBody FederacaoDTO federacaoDTO) {
        Federacao federacao = federacaoRepository.save(new Federacao(federacaoDTO));

        return ResponseEntity.created(URI.create("/federacao/" + federacao.getIdFederacao())).body(federacao);
    }


}
