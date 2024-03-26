package com.rac.suculentas.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Suculenta {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    private String idSuculenta;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;

    @ManyToOne
    private Categoria categoria;
    @OneToOne
    private Imagen imagen;
    private Double tamanio;
    private String cuidados;
    private String floracion;
    private Double alturaMax;
    private Boolean disponibilidad;
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;

    @OneToMany
    private List<Comentario> comentario;
    private Boolean estado;
}
