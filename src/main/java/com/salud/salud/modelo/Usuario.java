package com.salud.salud.modelo;

import javax.persistence.*;
import org.openxava.annotations.*;

@Entity
@View(members =
    "username, password, rol;" +
    "medico; paciente"
)
@Tab(properties = "username, rol, medico.nombres, paciente.nombres")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    private Long id;

    @Column(length = 30, unique = true)
    @Required
    private String username;

    @Column(length = 100)
    @Stereotype("PASSWORD")
    @Required
    private String password;

    @Enumerated(EnumType.STRING)
    @Required
    private Rol rol;

    @OneToOne
    @DescriptionsList(descriptionProperties = "nombres, apellidos")
    private Medico medico;

    @OneToOne
    @DescriptionsList(descriptionProperties = "nombres, apellidos")
    private Paciente paciente;

    public enum Rol {
        ADMIN, MEDICO, PACIENTE
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Rol getRol() { return rol; }
    public void setRol(Rol rol) { this.rol = rol; }

    public Medico getMedico() { return medico; }
    public void setMedico(Medico medico) { this.medico = medico; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
}
