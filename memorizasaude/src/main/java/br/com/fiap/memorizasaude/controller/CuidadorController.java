package br.com.fiap.memorizasaude.controller;

import br.com.fiap.memorizasaude.model.Cuidador;
import br.com.fiap.memorizasaude.service.CuidadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cuidadores")
public class CuidadorController {

    @Autowired
    private CuidadorService cuidadorService;

    @PostMapping
    public ResponseEntity<Cuidador> create(@RequestBody Cuidador cuidador) {
        Cuidador cuidadorSalvo = cuidadorService.create(cuidador);
        return ResponseEntity.status(HttpStatus.CREATED).body(cuidadorSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Cuidador>> getAll() {
        List<Cuidador> cuidadores = cuidadorService.getAll();
        return ResponseEntity.ok(cuidadores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuidador> getById(@PathVariable Long id) {
        Cuidador cuidador = cuidadorService.getById(id);
        return ResponseEntity.ok(cuidador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cuidadorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}