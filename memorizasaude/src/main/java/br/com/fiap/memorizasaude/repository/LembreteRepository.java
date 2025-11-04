package br.com.fiap.memorizasaude.repository;

import br.com.fiap.memorizasaude.model.Lembrete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LembreteRepository extends JpaRepository<Lembrete, Long> {
}