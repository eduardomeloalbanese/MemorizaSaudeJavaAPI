package br.com.fiap.memorizasaude.controller;

import br.com.fiap.memorizasaude.model.Usuario;
import br.com.fiap.memorizasaude.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        Usuario usuarioSalvo = usuarioService.create(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
        List<Usuario> usuarios = usuarioService.getAll();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Usuario> getById(@PathVariable String email) {
        Usuario usuario = usuarioService.getById(email);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{email}")
    public ResponseEntity<Usuario> update(@PathVariable String email, @RequestBody Usuario usuario) {
        Usuario usuarioAtualizado = usuarioService.update(email, usuario);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> delete(@PathVariable String email) {
        usuarioService.delete(email);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{email}/registrar-acesso")
    public ResponseEntity<Usuario> registrarAcesso(@PathVariable String email, @RequestParam boolean sucesso) {
        Usuario usuario = usuarioService.registrarAcesso(email, sucesso);
        return ResponseEntity.ok(usuario);
    }
}