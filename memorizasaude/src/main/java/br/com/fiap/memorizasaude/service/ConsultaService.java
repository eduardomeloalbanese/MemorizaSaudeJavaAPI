package br.com.fiap.memorizasaude.service;

import br.com.fiap.memorizasaude.model.Consulta;
import br.com.fiap.memorizasaude.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public Consulta confirmarPresenca(Long id) {
        Consulta consulta = getById(id);

        if (!consulta.isAgendada()) {
            throw new RuntimeException("Não há consulta agendada para confirmar.");
        }

        consulta.setCompareceu(true);
        return consultaRepository.save(consulta);
    }

    public Consulta create(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public Consulta getById(Long id) {
        return consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada: " + id));
    }

    public List<Consulta> getAll() {
        return consultaRepository.findAll();
    }

    public void delete(Long id) {
        if (!consultaRepository.existsById(id)) {
            throw new RuntimeException("Consulta não encontrada para deletar: " + id);
        }
        consultaRepository.deleteById(id);
    }

    public Consulta update(Long id, Consulta consultaAtualizada) {
        Consulta consultaExistente = getById(id);

        consultaExistente.setAgendada(consultaAtualizada.isAgendada());
        consultaExistente.setHora(consultaAtualizada.getHora());
        consultaExistente.setCompareceu(consultaAtualizada.isCompareceu());
        consultaExistente.setEspecialidade(consultaAtualizada.getEspecialidade());

        return consultaRepository.save(consultaExistente);
    }
}