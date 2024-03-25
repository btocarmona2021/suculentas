package com.rac.suculentas.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class Imagen {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idImagen;
    private String mime;
    private String nombre;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] contenido;
    private Boolean estado;
}
