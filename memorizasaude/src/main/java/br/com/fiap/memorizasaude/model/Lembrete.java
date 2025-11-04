package br.com.fiap.memorizasaude.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_MEMORIZA_LEMBRETE")
public class Lembrete {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lembrete_seq")
    @SequenceGenerator(name = "lembrete_seq", sequenceName = "SQ_T_LEMBRETE", allocationSize = 1)
    private Long id;

    private String paciente;
    private String especialidade;
    private int dataConsulta;
    private int horaConsulta;
    private boolean confirmado;

    public Lembrete() {}

    public Lembrete (String paciente, String especialidade, int dataConsulta,  int horaConsulta, boolean confirmado) {
        this.paciente = paciente;
        this.especialidade = especialidade;
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
        this.confirmado = confirmado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public int getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(int dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public int getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(int horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }
}