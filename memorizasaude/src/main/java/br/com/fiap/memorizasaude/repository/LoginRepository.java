package br.com.fiap.memorizasaude.repository;

import br.com.fiap.memorizasaude.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
    Login findByUsuarioAndSenha(String usuario, String senha);
}