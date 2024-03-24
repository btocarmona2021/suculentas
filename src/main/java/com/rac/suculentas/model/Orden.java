package com.rac.suculentas.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Orden {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idOrden;
    @Temporal(TemporalType.DATE)
    private Date fechaOrden;

    @OneToMany
    private List<Suculenta> listaSuculentas;
    @OneToOne
    private Usuario usuario;

    @OneToOne
    private Proveedor proveedor;
    private  Double precioFinal;
}
