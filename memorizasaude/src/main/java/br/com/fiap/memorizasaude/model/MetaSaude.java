package br.com.fiap.memorizasaude.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_MEMORIZA_META_SAUDE")
public class MetaSaude {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "meta_seq")
    @SequenceGenerator(name = "meta_seq", sequenceName = "SQ_T_META_SAUDE", allocationSize = 1)
    private Long id;

    private String metaSaude;
    private String descricao;
    private String tipoMeta;
    private int valorMeta;
    private int progressoAtual;

    public MetaSaude () {}

    public MetaSaude (String metaSaude, String descricao, String tipoMeta, int valorMeta, int progressoAtual) {
        this.metaSaude = metaSaude;
        this.descricao = descricao;
        this.tipoMeta = tipoMeta;
        this.valorMeta = valorMeta;
        this.progressoAtual = progressoAtual;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMetaSaude() {
        return metaSaude;
    }
    public void setMetaSaude(String metaSaude) {
        this.metaSaude = metaSaude;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getTipoMeta() {
        return tipoMeta;
    }
    public void setTipoMeta(String tipoMeta) {
        this.tipoMeta = tipoMeta;
    }
    public int getValorMeta() {
        return valorMeta;
    }
    public void setValorMeta(int valorMeta) {
        this.valorMeta = valorMeta;
    }
    public int getProgressoAtual() {
        return progressoAtual;
    }
    public void setProgressoAtual(int progressoAtual) {
        this.progressoAtual = progressoAtual;
    }
}