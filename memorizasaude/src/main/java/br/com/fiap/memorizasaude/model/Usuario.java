package br.com.fiap.memorizasaude.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "TB_MEMORIZA_USUARIO")
public class Usuario {

    @Id
    private String email;

    private String nome;
    private String ultimoAcesso;
    private int totalAcessos;
    private boolean ativo;
    private int tentativasFalhas;

    public Usuario() {}

    public Usuario (String nome, String email, String ultimoAcesso,  int totalAcessos, boolean ativo, int tentativasFalhas) {
        this.nome = nome;
        this.email = email;
        this.ultimoAcesso = ultimoAcesso;
        this.totalAcessos = totalAcessos;
        this.ativo = ativo;
        this.tentativasFalhas = tentativasFalhas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(String ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

    public int getTotalAcessos() {
        return totalAcessos;
    }

    public void setTotalAcessos(int totalAcessos) {
        this.totalAcessos = totalAcessos;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public int getTentativasFalhas() {
        return tentativasFalhas;
    }

    public void setTentativasFalhas(int tentativasFalhas) {
        this.tentativasFalhas = tentativasFalhas;
    }
}