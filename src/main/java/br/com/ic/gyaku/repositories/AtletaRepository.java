package br.com.ic.gyaku.repositories;

import br.com.ic.gyaku.model.atleta.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtletaRepository extends JpaRepository<Atleta, Integer> {
}
