package br.com.fiap.memorizasaude.controller;

import br.com.fiap.memorizasaude.model.Consulta;
import br.com.fiap.memorizasaude.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<Consulta> create(@RequestBody Consulta consulta) {
        Consulta consultaSalva = consultaService.create(consulta);
        return ResponseEntity.status(HttpStatus.CREATED).body(consultaSalva);
    }

    @GetMapping
    public ResponseEntity<List<Consulta>> getAll() {
        List<Consulta> consultas = consultaService.getAll();
        return ResponseEntity.ok(consultas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> getById(@PathVariable Long id) {
        Consulta consulta = consultaService.getById(id);
        return ResponseEntity.ok(consulta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consulta> update(@PathVariable Long id, @RequestBody Consulta consulta) {
        Consulta consultaAtualizada = consultaService.update(id, consulta);
        return ResponseEntity.ok(consultaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        consultaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/confirmar-presenca")
    public ResponseEntity<Consulta> confirmarPresenca(@PathVariable Long id) {
        Consulta consulta = consultaService.confirmarPresenca(id);
        return ResponseEntity.ok(consulta);
    }
}