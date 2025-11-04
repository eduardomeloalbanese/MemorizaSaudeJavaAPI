package br.com.fiap.memorizasaude.controller;

import br.com.fiap.memorizasaude.model.DiarioSaude;
import br.com.fiap.memorizasaude.service.DiarioSaudeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@RequestMapping("/api/diarios")
@CrossOrigin
public class DiarioSaudeController {

    @Autowired
    private DiarioSaudeService diarioSaudeService;

    @PostMapping
    public ResponseEntity<DiarioSaude> create(@RequestBody DiarioSaude diario) {
        DiarioSaude diarioSalvo = diarioSaudeService.create(diario);
        return ResponseEntity.status(HttpStatus.CREATED).body(diarioSalvo);
    }

    @GetMapping
    public ResponseEntity<List<DiarioSaude>> getAll() {
        List<DiarioSaude> diarios = diarioSaudeService.getAll();
        return ResponseEntity.ok(diarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiarioSaude> getById(@PathVariable Long id) {
        DiarioSaude diario = diarioSaudeService.getById(id);
        return ResponseEntity.ok(diario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        diarioSaudeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}