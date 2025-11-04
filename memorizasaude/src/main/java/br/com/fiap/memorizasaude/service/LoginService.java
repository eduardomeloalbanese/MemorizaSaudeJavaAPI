package br.com.fiap.memorizasaude.service;

import br.com.fiap.memorizasaude.model.Login;
import br.com.fiap.memorizasaude.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public Login validarLogin(String usuario, String senha) {
        Login login = loginRepository.findByUsuarioAndSenha(usuario, senha);

        if (login == null) {
            throw new RuntimeException("Usuário ou senha inválidos");
        }

        return login;
    }
}