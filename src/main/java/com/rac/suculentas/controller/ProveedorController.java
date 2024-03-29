package com.rac.suculentas.controller;

import com.rac.suculentas.exception.MyExceptions;
import com.rac.suculentas.model.Proveedor;
import com.rac.suculentas.service.ProveedorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {

    private ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    //CREAR PROVEEDOR
    @GetMapping("/registrar")
    public String registrarProveedor(Proveedor proveedor , ModelMap model){
        model.put("proveedor",proveedor);
        return "registrarproveedor";
    }

    @PostMapping("/registrado")
    public String proveedorRegistrado(Proveedor proveedor, MultipartFile imagenProveedor) throws MyExceptions {
        try {
            proveedorService.crearProveedor(proveedor,imagenProveedor);
        } catch (MyExceptions e) {
            throw new MyExceptions("Error al guardar el proveedor");
        }
        return "listarproveedor";
    }
}
