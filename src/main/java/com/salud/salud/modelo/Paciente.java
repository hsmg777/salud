package com.salud.salud.modelo;

import javax.persistence.*;
import org.openxava.annotations.*;
import java.time.LocalDate;

@Entity
@View(members = 
    "nombres, apellidos; " +
    "cedula, fechaNacimiento; " +
    "telefono, email; " +
    "direccion, estado"
)
public class Paciente {

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

    @Column(length = 20)
    private String telefono;

    @Column(length = 100)
    private String direccion;

    @Stereotype("EMAIL")
    private String email;

    private LocalDate fechaNacimiento;

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

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }
}
