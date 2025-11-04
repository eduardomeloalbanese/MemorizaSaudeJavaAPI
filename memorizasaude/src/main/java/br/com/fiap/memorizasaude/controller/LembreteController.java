package br.com.fiap.memorizasaude.controller;

import br.com.fiap.memorizasaude.model.Lembrete;
import br.com.fiap.memorizasaude.service.LembreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@RequestMapping("/api/lembretes")
@CrossOrigin
public class LembreteController {

    @Autowired
    private LembreteService lembreteService;

    @PostMapping
    public ResponseEntity<Lembrete> create(@RequestBody Lembrete lembrete) {
        Lembrete lembreteSalvo = lembreteService.create(lembrete);
        return ResponseEntity.status(HttpStatus.CREATED).body(lembreteSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Lembrete>> getAll() {
        List<Lembrete> lembretes = lembreteService.getAll();
        return ResponseEntity.ok(lembretes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lembrete> getById(@PathVariable Long id) {
        Lembrete lembrete = lembreteService.getById(id);
        return ResponseEntity.ok(lembrete);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        lembreteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/confirmar-recebimento")
    public ResponseEntity<Lembrete> confirmarRecebimento(@PathVariable Long id) {
        Lembrete lembrete = lembreteService.confirmarRecebimento(id);
        return ResponseEntity.ok(lembrete);
    }
}