package br.com.fiap.memorizasaude.service;

import br.com.fiap.memorizasaude.model.DiarioSaude;
import br.com.fiap.memorizasaude.repository.DiarioSaudeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DiarioSaudeService {

    @Autowired
    private DiarioSaudeRepository diarioSaudeRepository;

    public DiarioSaude create(DiarioSaude diario) {
        return diarioSaudeRepository.save(diario);
    }

    public DiarioSaude getById(Long id) {
        return diarioSaudeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Diário não encontrado: " + id));
    }

    public List<DiarioSaude> getAll() {
        return diarioSaudeRepository.findAll();
    }

    public void delete(Long id) {
        if (!diarioSaudeRepository.existsById(id)) {
            throw new RuntimeException("Diário não encontrado para deletar: " + id);
        }
        diarioSaudeRepository.deleteById(id);
    }
}