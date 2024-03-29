package com.rac.suculentas.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Data
public class Proveedor {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name="uuid", strategy = "uuid2" )
    private String idProveedor;
    private String nombreEmpresa;
    private String Contacto;
    private String correo;
    private String telefono;
    private String direccion;
    private String sitioWeb;
    @OneToMany
    private List<Orden> orden;

    @OneToOne
    private Imagen imagen;
    private Boolean estado;

}
