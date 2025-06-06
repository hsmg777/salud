package com.salud.salud.modelo;

import javax.persistence.*;
import org.openxava.annotations.*;

@Entity
@View(name="DEFAULT", members = 
    "nombres, apellidos; " +
    "cedula, especialidad; " +
    "telefono, email; " +
    "estado"
)
@Tab(properties = "nombres, apellidos, cedula, especialidad, telefono, email, estado")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    private Long id;

    @Required
    @Column(length = 50)
    private String nombres;

    @Required
    @Column(length = 50)
    private String apellidos;

    @Required
    @Column(length = 10, unique = true)
    private String cedula;

    @Required
    @Column(length = 100)
    private String especialidad;

    @Column(length = 20)
    private String telefono;

    @Stereotype("EMAIL")
    private String email;

    @Enumerated(EnumType.STRING)
    private Estado estado = Estado.Activo;

    public enum Estado {
        Activo, Inactivo
    }

    // Getters y Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }
    
}
