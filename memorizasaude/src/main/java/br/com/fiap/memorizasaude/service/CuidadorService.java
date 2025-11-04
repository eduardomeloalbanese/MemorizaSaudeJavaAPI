package br.com.fiap.memorizasaude.service;

import br.com.fiap.memorizasaude.model.Cuidador;
import br.com.fiap.memorizasaude.repository.CuidadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CuidadorService {

    @Autowired
    private CuidadorRepository cuidadorRepository;

    public Cuidador create(Cuidador cuidador) {
        return cuidadorRepository.save(cuidador);
    }

    public Cuidador getById(Long id) {
        return cuidadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuidador não encontrado: " + id));
    }

    public List<Cuidador> getAll() {
        return cuidadorRepository.findAll();
    }

    public void delete(Long id) {
        if (!cuidadorRepository.existsById(id)) {
            throw new RuntimeException("Cuidador não encontrado para deletar: " + id);
        }
        cuidadorRepository.deleteById(id);
    }
}