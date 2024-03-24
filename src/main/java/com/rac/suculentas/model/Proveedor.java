package com.rac.suculentas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class Proveedor {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name="uuid", strategy = "uuid2" )
    private String idProveedor;
    private String nombreEmpresa;
    private String nombreContacto;
    private String correo;
    private String telefono;
    private String direccion;
    private String sitioWeb;
    private  Suculenta suculenta;

}
