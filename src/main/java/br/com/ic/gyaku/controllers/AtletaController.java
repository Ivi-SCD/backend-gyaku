package br.com.ic.gyaku.controllers;

import br.com.ic.gyaku.model.atleta.Atleta;
import br.com.ic.gyaku.model.atleta.AtletaDTO;
import br.com.ic.gyaku.model.atleta.AtletaDTOResposta;
import br.com.ic.gyaku.services.AtletaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping( "/atleta")
public class AtletaController {

    @Autowired
    private AtletaService atletaService;

    @GetMapping
    public HashSet<AtletaDTOResposta> listarAtletas() {
        return atletaService.listarAtletas();
    }

    @GetMapping("/{id}")
    public AtletaDTOResposta encontrarAtletaPorId(@PathVariable Integer id) {
        return atletaService.encontrarAtletaPorId(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Atleta> salvarAtleta(@RequestBody @Valid AtletaDTO atletaDTO) {
        Atleta atleta = atletaService.salvarAtleta(atletaDTO);

        return ResponseEntity.created(URI.create("/atleta/" + atleta.getIdAtleta())).body(atleta);

    }


}
