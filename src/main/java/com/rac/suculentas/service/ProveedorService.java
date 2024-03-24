package com.rac.suculentas.service;

import com.rac.suculentas.exception.MyExceptions;
import com.rac.suculentas.model.Proveedor;
import com.rac.suculentas.repository.ProveedorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {

        //CREAMOS INSTANCIA DE PROVEEDOR REPOSITORIO
    private final ProveedorRepository proveedorRepository;

    public ProveedorService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    //CREAR PROVEEDOR
    @Transactional
    public void crearProveedor(Proveedor proveedor){
        proveedorRepository.save(proveedor);
    }

    //MODIFICAR PROVEEDOR
    @Transactional(readOnly = true)
    public Proveedor buscarProveedor(Proveedor proveedor) throws MyExceptions {
        Optional<Proveedor> consulta = proveedorRepository.findById(proveedor.getIdProveedor());
        if (consulta.isPresent()){
            return consulta.get();
        }else{
            throw new MyExceptions("No se encontro proveedor o es nulo");
        }
    }

    //DESACTIVAR PROVEEDOR
    @Transactional
    public void desactivarProveedor(Proveedor proveedor){
        Proveedor proveedorEncontrado = proveedorRepository.getOne(proveedor.getIdProveedor());
        proveedorEncontrado.setEstado(false);
        proveedorRepository.save(proveedorEncontrado);
    }

    //ACTIVAR PROVEEDOR
    @Transactional
    public void activarProveedor(Proveedor proveedor){
        Proveedor proveedorEncontrado = proveedorRepository.getOne(proveedor.getIdProveedor());
        proveedorEncontrado.setEstado(true);
        proveedorRepository.save(proveedorEncontrado);
    }

    //LISTAR PROVEEDORES
    public List<Proveedor> listarProvedores(){
        return proveedorRepository.findAll();
    }

}
