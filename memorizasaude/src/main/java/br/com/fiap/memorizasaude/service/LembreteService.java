package br.com.fiap.memorizasaude.service;

import br.com.fiap.memorizasaude.model.Lembrete;
import br.com.fiap.memorizasaude.repository.LembreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LembreteService {

    @Autowired
    private LembreteRepository lembreteRepository;

    public Lembrete confirmarRecebimento(Long id) {
        Lembrete lembrete = getById(id);

        if (lembrete.isConfirmado()) {
            throw new RuntimeException("Lembrete já havia sido confirmado.");
        }

        lembrete.setConfirmado(true);
        return lembreteRepository.save(lembrete);
    }

    public Lembrete create(Lembrete lembrete) {
        return lembreteRepository.save(lembrete);
    }

    public Lembrete getById(Long id) {
        return lembreteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lembrete não encontrado: " + id));
    }

    public List<Lembrete> getAll() {
        return lembreteRepository.findAll();
    }

    public void delete(Long id) {
        if (!lembreteRepository.existsById(id)) {
            throw new RuntimeException("Lembrete não encontrado para deletar: " + id);
        }
        lembreteRepository.deleteById(id);
    }
}