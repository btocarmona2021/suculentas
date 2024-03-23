package com.rac.suculentas.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
public class Suculenta {
    //MODIFICACION
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    private String id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;
    private Categoria categoria;
    private Double tamanio;
    private String cuidados;
    private String floracion;
    private Double alturaMax;
    private Boolean disponibilidad;
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    private Comentario comentario;
}
