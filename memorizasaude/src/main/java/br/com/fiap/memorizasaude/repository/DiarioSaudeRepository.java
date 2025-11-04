package br.com.fiap.memorizasaude.repository;

import br.com.fiap.memorizasaude.model.DiarioSaude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiarioSaudeRepository extends JpaRepository<DiarioSaude, Long> {
}