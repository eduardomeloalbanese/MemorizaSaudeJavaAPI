package br.com.fiap.memorizasaude.repository;

import br.com.fiap.memorizasaude.model.Cuidador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuidadorRepository extends JpaRepository<Cuidador, Long> {
}