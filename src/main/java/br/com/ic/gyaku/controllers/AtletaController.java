package br.com.ic.gyaku.controllers;

import br.com.ic.gyaku.model.atleta.Atleta;
import br.com.ic.gyaku.model.atleta.AtletaDTO;
import br.com.ic.gyaku.repositories.AtletaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping( "/atleta")
public class AtletaController {

    @Autowired
    private AtletaRepository atletaRepository;

    @GetMapping
    public List<Atleta> listarAtletas() {
        return atletaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Atleta encontrarAtletaPorId(@PathVariable Integer id) {
        return atletaRepository.findById(id).get();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Atleta> salvarFederacao(@RequestBody @Valid AtletaDTO atletaDTO) {
        Atleta atleta = atletaRepository.save(new Atleta(atletaDTO));

        return ResponseEntity.created(URI.create("/atleta/" + atleta.getIdAtleta())).body(atleta);

    }


}
