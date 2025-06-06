package com.salud.salud.modelo;

import javax.persistence.*;
import org.openxava.annotations.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@View(name="DEFAULT", members =
    "fecha, hora; " +
    "paciente, medico; " +
    "motivo, estado"
)
@Tab(properties = "fecha, hora, paciente.nombres, paciente.apellidos, medico.nombres, medico.apellidos, motivo, estado")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    private Long id;

    @Required
    private LocalDate fecha;

    @Required
    private LocalTime hora;

    @DescriptionsList(descriptionProperties = "nombres, apellidos")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Paciente paciente;

    @DescriptionsList(descriptionProperties = "nombres, apellidos")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Medico medico;

    @Stereotype("TEXT")
    private String motivo;

    @Enumerated(EnumType.STRING)
    private Estado estado = Estado.Programada;

    public enum Estado {
        Programada, Realizada, Cancelada
    }

    // Getters y Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public Medico getMedico() { return medico; }
    public void setMedico(Medico medico) { this.medico = medico; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }
}
