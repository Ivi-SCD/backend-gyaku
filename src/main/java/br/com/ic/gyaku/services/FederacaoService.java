package br.com.ic.gyaku.services;

import br.com.ic.gyaku.model.federacao.Federacao;
import br.com.ic.gyaku.model.federacao.FederacaoDTO;
import br.com.ic.gyaku.repositories.FederacaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FederacaoService {

    @Autowired
    private FederacaoRepository federacaoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<FederacaoDTO> listarFederacoes() {
        List<Federacao> federacoes = federacaoRepository.findAll();

        return federacoes
                .stream()
                .map(f -> modelMapper.map(f, FederacaoDTO.class))
                .toList();
    }

    public List<FederacaoDTO> listarFederacoesPorNome(String nome) {
        List<Federacao> federacoes = federacaoRepository.findByNomeFederacao(nome);

        return federacoes
                .stream()
                .map(f -> modelMapper.map(f, FederacaoDTO.class))
                .toList();
    }

    public Federacao salvarFederacao(Federacao federacao) {
        return federacaoRepository.save(federacao);
    }
}
