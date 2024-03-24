package com.rac.suculentas.model;

import com.rac.suculentas.enumerated.Rol;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idUsuario;
    private String nombreCompleto;
    @OneToOne
    private Imagen imagen;
    private String direccion;
    private String correo;
    private String password;
    private String direccionEnvio;
    private String telefono;
    private Rol rol;

    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    private Boolean estado;
}