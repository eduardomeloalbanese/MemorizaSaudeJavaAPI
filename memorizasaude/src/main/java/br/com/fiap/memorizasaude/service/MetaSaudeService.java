package br.com.fiap.memorizasaude.service;

import br.com.fiap.memorizasaude.model.MetaSaude;
import br.com.fiap.memorizasaude.repository.MetaSaudeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MetaSaudeService {

    @Autowired
    private MetaSaudeRepository metaSaudeRepository;

    public MetaSaude atualizarProgresso(Long id, int novoProgresso) {
        MetaSaude meta = getById(id);

        if (novoProgresso < 0) {
            throw new RuntimeException("O progresso não pode ser negativo.");
        }

        meta.setProgressoAtual(novoProgresso);
        return metaSaudeRepository.save(meta);
    }

    public MetaSaude create(MetaSaude metaSaude) {
        return metaSaudeRepository.save(metaSaude);
    }

    public MetaSaude getById(Long id) {
        return metaSaudeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Meta não encontrada: " + id));
    }

    public List<MetaSaude> getAll() {
        return metaSaudeRepository.findAll();
    }

    public void delete(Long id) {
        if (!metaSaudeRepository.existsById(id)) {
            throw new RuntimeException("Meta não encontrada para deletar: " + id);
        }
        metaSaudeRepository.deleteById(id);
    }
}