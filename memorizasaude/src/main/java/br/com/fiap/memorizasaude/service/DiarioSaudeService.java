// Cole em: br/com/fiap/memorizasaude/service/DiarioSaudeService.java

package br.com.fiap.memorizasaude.service;

import br.com.fiap.memorizasaude.model.DiarioSaude;
import br.com.fiap.memorizasaude.repository.DiarioSaudeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // ✅ IMPORTAR
import java.util.List;

@Service
public class DiarioSaudeService {

    @Autowired
    private DiarioSaudeRepository diarioSaudeRepository;

    @Transactional // ✅ ADICIONADO: Garante a estabilidade da escrita
    public DiarioSaude create(DiarioSaude diario) {
        return diarioSaudeRepository.save(diario);
    }

    // ✅ ADICIONADO: MÉTODO UPDATE (PUT)
    @Transactional 
    public DiarioSaude update(Long id, DiarioSaude diarioAtualizado) {
        DiarioSaude diarioExistente = getById(id); // Reusa o getById

        // Atualiza os campos do Model DiarioSaude.java
        diarioExistente.setDescriacao(diarioAtualizado.getDescriacao());
        diarioExistente.setDataInicio(diarioAtualizado.getDataInicio());
        diarioExistente.setDataFim(diarioAtualizado.getDataFim());

        return diarioSaudeRepository.save(diarioExistente);
    }

    public DiarioSaude getById(Long id) {
        return diarioSaudeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Diário não encontrado: " + id));
    }

    public List<DiarioSaude> getAll() {
        return diarioSaudeRepository.findAll();
    }

    @Transactional // ✅ ADICIONADO: Garante que a exclusão seja segura
    public void delete(Long id) {
        if (!diarioSaudeRepository.existsById(id)) {
            throw new RuntimeException("Diário não encontrado para deletar: " + id);
        }
        diarioSaudeRepository.deleteById(id);
    }
}