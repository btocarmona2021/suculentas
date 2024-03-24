package com.rac.suculentas.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
@Data
public class Suculenta {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    private String id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;
//
//    @ManyToOne
//    private Categoria categoria;
    /*private Imagen imagen;*/
    private Double tamanio;
    private String cuidados;
    private String floracion;
    private Double alturaMax;
    private Boolean disponibilidad;
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @ManyToOne
    private Comentario comentario;
}
