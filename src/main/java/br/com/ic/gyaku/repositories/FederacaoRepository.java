package br.com.ic.gyaku.repositories;

import br.com.ic.gyaku.model.federacao.Federacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FederacaoRepository extends JpaRepository<Federacao, Integer> {
    @Query(value = "SELECT * FROM federacao f WHERE f.nome_federacao LIKE %:nome%", nativeQuery = true)
    List<Federacao> findByNomeFederacao(String nome);
}
