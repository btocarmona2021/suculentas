package com.rac.suculentas.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Categoria {
    private String id;
    private String nombreCategoria;
    private Boolean estado;

}
