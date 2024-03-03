package br.com.ic.gyaku.services;

import br.com.ic.gyaku.error.exceptions.NullObjectException;
import br.com.ic.gyaku.model.atleta.Atleta;
import br.com.ic.gyaku.model.atleta.AtletaDTO;
import br.com.ic.gyaku.model.atleta.AtletaDTOResposta;
import br.com.ic.gyaku.model.federacao.Federacao;
import br.com.ic.gyaku.repositories.AtletaRepository;
import br.com.ic.gyaku.repositories.FederacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class AtletaService {

    @Autowired
    private AtletaRepository atletaRepository;

    @Autowired
    private FederacaoRepository federacaoRepository;

    @Autowired
    private ModelMapper modelMapper;
    public HashSet<AtletaDTOResposta> listarAtletas() {
        List<Atleta> atletas = atletaRepository.findAll();

        if(atletas.isEmpty()) {
            throw new EntityNotFoundException();
        }

        return new HashSet<>(atletas
                .stream()
                .map(a -> modelMapper.map(a, AtletaDTOResposta.class))
                .toList());
    }

    public Atleta salvarAtleta(AtletaDTO atletaDTO) {
        Federacao federacao = federacaoRepository.findByNome(atletaDTO.federacao());
        if(federacao == null) {
            throw new NullObjectException("Federacao");
        }

        Atleta atleta = new Atleta(atletaDTO);
        atleta.setFederacao(federacao);
        atletaRepository.save(atleta);
        return atleta;
    }

    public AtletaDTOResposta encontrarAtletaPorId(Integer id) {
        Atleta atleta = atletaRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        return new AtletaDTOResposta(atleta);

    }


}
