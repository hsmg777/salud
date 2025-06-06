package com.salud.salud.modelo;

import javax.persistence.*;
import java.time.LocalDate;
import org.openxava.annotations.*;

@Entity
@View(members =
    "paciente, medico, fecha;" +
    "motivoConsulta, diagnostico, tratamiento"
)
@Tab(properties = "fecha, paciente.nombres, paciente.apellidos, medico.nombres, motivoConsulta")
public class HistorialClinico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @DescriptionsList(descriptionProperties = "nombres, apellidos")
    private Paciente paciente;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @DescriptionsList(descriptionProperties = "nombres, apellidos")
    private Medico medico;

    @Required
    private LocalDate fecha;

    @TextArea
    private String motivoConsulta;

    @TextArea
    private String diagnostico;

    @TextArea
    private String tratamiento;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public Medico getMedico() { return medico; }
    public void setMedico(Medico medico) { this.medico = medico; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public String getMotivoConsulta() { return motivoConsulta; }
    public void setMotivoConsulta(String motivoConsulta) { this.motivoConsulta = motivoConsulta; }

    public String getDiagnostico() { return diagnostico; }
    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }

    public String getTratamiento() { return tratamiento; }
    public void setTratamiento(String tratamiento) { this.tratamiento = tratamiento; }
}
