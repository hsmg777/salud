package com.salud.salud.modelo;

import java.util.*;
import javax.persistence.*;
import org.openxava.annotations.*;

@Entity
@View(members =
    "nombre, fecha, tamanio"
)
public class Backup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    private Long id;

    @Column(length=100)
    @Required
    @ReadOnly
    private String nombre;

    @Stereotype("DATETIME")
    @Required
    @ReadOnly
    private Date fecha;

    @Column
    @ReadOnly
    private long tamanio; // en bytes

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public long getTamanio() {
        return tamanio;
    }

    public void setTamanio(long tamanio) {
        this.tamanio = tamanio;
    }
}
