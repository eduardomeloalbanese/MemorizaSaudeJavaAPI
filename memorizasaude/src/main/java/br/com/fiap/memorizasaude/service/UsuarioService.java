package br.com.fiap.memorizasaude.service;

import br.com.fiap.memorizasaude.model.Usuario;
import br.com.fiap.memorizasaude.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario registrarAcesso(String email, boolean sucesso) {
        Usuario usuario = getById(email);

        if (!usuario.isAtivo()) {
            System.out.println("Usuário inativo! Não é possível registrar acesso.");
            return usuario;
        }

        if (sucesso) {
            usuario.setUltimoAcesso(new Date().toString());
            usuario.setTotalAcessos(usuario.getTotalAcessos() + 1);
            usuario.setTentativasFalhas(0);
        } else {
            usuario.setTentativasFalhas(usuario.getTentativasFalhas() + 1);
            if (usuario.getTentativasFalhas() >= 3) {
                usuario.setAtivo(false);
            }
        }

        return usuarioRepository.save(usuario);
    }

    public Usuario create(Usuario usuario) {
        if (usuarioRepository.existsById(usuario.getEmail())) {
            throw new RuntimeException("Email já cadastrado!");
        }
        return usuarioRepository.save(usuario);
    }

    public Usuario getById(String email) {
        return usuarioRepository.findById(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado: " + email));
    }

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    public void delete(String email) {
        if (!usuarioRepository.existsById(email)) {
            throw new RuntimeException("Usuário não encontrado para deletar: " + email);
        }
        usuarioRepository.deleteById(email);
    }

    public Usuario update(String email, Usuario usuarioAtualizado) {
        Usuario usuarioExistente = getById(email);

        usuarioExistente.setNome(usuarioAtualizado.getNome());
        usuarioExistente.setAtivo(usuarioAtualizado.isAtivo());

        return usuarioRepository.save(usuarioExistente);
    }
}