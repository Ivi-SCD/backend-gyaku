package br.com.ic.gyaku.services;

import br.com.ic.gyaku.model.federacao.Federacao;
import br.com.ic.gyaku.model.federacao.FederacaoDTO;
import br.com.ic.gyaku.repositories.FederacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class FederacaoService {

    @Autowired
    private FederacaoRepository federacaoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public HashSet<FederacaoDTO> listarFederacoes() {
        List<Federacao> federacoes = federacaoRepository.findAll();

        if(federacoes.isEmpty()) {
            throw new EntityNotFoundException();
        }

        return new HashSet<>(federacoes
                .stream()
                .map(f -> modelMapper.map(f, FederacaoDTO.class))
                .toList());
    }

    public HashSet<FederacaoDTO> listarFederacoesPorNome(String nome) {
        List<Federacao> federacoes = federacaoRepository.findByNomeFederacao(nome);

        if(federacoes.isEmpty()) {
            throw new EntityNotFoundException();
        }

        return new HashSet<>(federacoes
                .stream()
                .map(f -> modelMapper.map(f, FederacaoDTO.class))
                .toList());
    }

    public Federacao salvarFederacao(Federacao federacao) {
        return federacaoRepository.save(federacao);
    }
}
