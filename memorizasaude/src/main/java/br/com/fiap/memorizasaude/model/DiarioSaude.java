package br.com.fiap.memorizasaude.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_MEMORIZA_DIARIO_SAUDE")
public class DiarioSaude {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "diario_seq")
    @SequenceGenerator(name = "diario_seq", sequenceName = "SQ_T_DIARIO_SAUDE", allocationSize = 1)
    private Long id;

    private String descriacao;
    private int dataInicio;
    private int dataFim;

    public DiarioSaude () {}

    public DiarioSaude (String descriacao, int dataInicio, int dataFim) {
        this.descriacao = descriacao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescriacao() {
        return descriacao;
    }

    public void setDescriacao(String descriacao) {
        this.descriacao = descriacao;
    }

    public int getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(int dataInicio) {
        this.dataInicio = dataInicio;
    }

    public int getDataFim() {
        return dataFim;
    }

    public void setDataFim(int dataFim) {
        this.dataFim = dataFim;
    }
}