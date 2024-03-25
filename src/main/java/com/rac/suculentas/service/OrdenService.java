package com.rac.suculentas.service;

import com.rac.suculentas.exception.MyExceptions;
import com.rac.suculentas.model.Orden;
import com.rac.suculentas.repository.OrdenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenService {
    //INSTANCIA DE REPOSITORIO DE ORDEN
    private final OrdenRepository ordenRepository;

    public OrdenService(OrdenRepository ordenRepository) {
        this.ordenRepository = ordenRepository;
    }

    //CREAR ORDEN
    @Transactional
    public void crearOrden(Orden orden){
        ordenRepository.save(orden);
    }

    //MODIFICAR ORDEN
    @Transactional(readOnly = true)
    public Orden buscarOrden(Orden orden) throws MyExceptions {
        Optional<Orden> consulta = ordenRepository.findById(orden.getIdOrden());
        if (consulta.isPresent()){
            return consulta.get();
        }else {
            throw new MyExceptions("La orden no se encontró o es nula");
        }
    }

    //DESACTIVAR ORDEN
    @Transactional
    public void desacttivarOrden(Orden orden){
        Orden ordenEncontrada = ordenRepository.getOne(orden.getIdOrden());
        ordenEncontrada.setEstado(false);
        ordenRepository.save(ordenEncontrada);
    }

    //ACTIVAR ORDEN
    @Transactional
    public void activarOrden(Orden orden){
        Orden ordenEncontrada = ordenRepository.getOne(orden.getIdOrden());
        ordenEncontrada.setEstado(true);
        ordenRepository.save(ordenEncontrada);
    }

    //LISTAR ORDENES
    @Transactional(readOnly = true)
    public List<Orden> listarOrdenes(){
        return ordenRepository.findAll();
    }
}
