package br.com.fiap.memorizasaude.controller;

import br.com.fiap.memorizasaude.model.Login;
import br.com.fiap.memorizasaude.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<Login> validarLogin(@RequestBody Login loginRequest) {
        Login login = loginService.validarLogin(loginRequest.getUsuario(), loginRequest.getSenha());
        return ResponseEntity.ok(login);
    }
}