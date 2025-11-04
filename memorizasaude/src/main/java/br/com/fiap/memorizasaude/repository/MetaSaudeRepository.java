package br.com.fiap.memorizasaude.repository;

import br.com.fiap.memorizasaude.model.MetaSaude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaSaudeRepository extends JpaRepository<MetaSaude, Long> {
}