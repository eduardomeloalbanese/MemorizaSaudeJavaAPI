package br.com.fiap.memorizasaude.controller;

import br.com.fiap.memorizasaude.model.MetaSaude;
import br.com.fiap.memorizasaude.service.MetaSaudeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@RequestMapping("/api/metas")
@CrossOrigin
public class MetaSaudeController {

    @Autowired
    private MetaSaudeService metaSaudeService;

    @PostMapping
    public ResponseEntity<MetaSaude> create(@RequestBody MetaSaude metaSaude) {
        MetaSaude metaSalva = metaSaudeService.create(metaSaude);
        return ResponseEntity.status(HttpStatus.CREATED).body(metaSalva);
    }

    @GetMapping
    public ResponseEntity<List<MetaSaude>> getAll() {
        List<MetaSaude> metas = metaSaudeService.getAll();
        return ResponseEntity.ok(metas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetaSaude> getById(@PathVariable Long id) {
        MetaSaude meta = metaSaudeService.getById(id);
        return ResponseEntity.ok(meta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        metaSaudeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/atualizar-progresso")
    public ResponseEntity<MetaSaude> atualizarProgresso(@PathVariable Long id, @RequestParam int progresso) {
        MetaSaude meta = metaSaudeService.atualizarProgresso(id, progresso);
        return ResponseEntity.ok(meta);
    }
}