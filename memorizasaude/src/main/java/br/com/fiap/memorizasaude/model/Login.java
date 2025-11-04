package br.com.fiap.memorizasaude.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_MEMORIZA_LOGIN")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "login_seq")
    @SequenceGenerator(name = "login_seq", sequenceName = "SQ_T_LOGIN", allocationSize = 1)
    private Long id;

    private String senha;
    private int dataAcesso;
    private String usuario;

    public Login () {}

    public Login (String senha, int dataAcesso,  String usuario) {
        this.senha = senha;
        this.dataAcesso = dataAcesso;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getDataAcesso() {
        return dataAcesso;
    }

    public void setDataAcesso(int dataAcesso) {
        this.dataAcesso = dataAcesso;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}