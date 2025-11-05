// Cole em: br/com/fiap/memorizasaude/service/CuidadorService.java

package br.com.fiap.memorizasaude.service;

import br.com.fiap.memorizasaude.model.Cuidador;
import br.com.fiap.memorizasaude.repository.CuidadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // ✅ IMPORTAR
import java.util.List;

@Service
public class CuidadorService {

    @Autowired
    private CuidadorRepository cuidadorRepository;

    @Transactional // ✅ ADICIONADO: Garante estabilidade na escrita
    public Cuidador create(Cuidador cuidador) {
        return cuidadorRepository.save(cuidador);
    }

    public Cuidador getById(Long id) {
        return cuidadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuidador não encontrado: " + id));
    }

    // ✅ NOVO MÉTODO: UPDATE (PUT)
    @Transactional
    public Cuidador update(Long id, Cuidador cuidadorAtualizado) {
        Cuidador cuidadorExistente = getById(id);

        // Atualiza os campos do Model Cuidador.java
        cuidadorExistente.setNome(cuidadorAtualizado.getNome());
        cuidadorExistente.setSexo(cuidadorAtualizado.getSexo());
        cuidadorExistente.setTelefone(cuidadorAtualizado.getTelefone());

        return cuidadorRepository.save(cuidadorExistente);
    }

    public List<Cuidador> getAll() {
        return cuidadorRepository.findAll();
    }

    @Transactional // ✅ ADICIONADO: Garante que a exclusão seja segura
    public void delete(Long id) {
        if (!cuidadorRepository.existsById(id)) {
            throw new RuntimeException("Cuidador não encontrado para deletar: " + id);
        }
        cuidadorRepository.deleteById(id);
    }
}