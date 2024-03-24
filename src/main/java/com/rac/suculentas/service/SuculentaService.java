package com.rac.suculentas.service;

import com.rac.suculentas.exception.MyExceptions;
import com.rac.suculentas.model.Suculenta;
import com.rac.suculentas.repository.SuculentaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SuculentaService {
    //CREAR INSTANCIA DE SUCULENTA REPOSITORIO
    private final SuculentaRepository suculentaRepository;

    public SuculentaService(SuculentaRepository suculentaRepository) {
        this.suculentaRepository = suculentaRepository;
    }

    //CREAR SUCULENTA
    @Transactional
    public void crearSuculenta(Suculenta suculenta) {
        suculentaRepository.save(suculenta);
    }

    //MODIFICAR SUCULENTA
    @Transactional
    public Suculenta buscarSuculenta(Suculenta suculenta) throws MyExceptions {
        Optional<Suculenta> consulta = suculentaRepository.findById(suculenta.getIdSuculenta());
        if (consulta.isPresent()) {
            return consulta.get();
        } else {
            throw new MyExceptions("La suculenta no se encuentra o es nula");
        }
    }

    //DESACTIVAR SUCULENTA
    @Transactional
    public void desactivarSuculenta(Suculenta suculenta){
        Suculenta suculentaEncontrada = suculentaRepository.getOne(suculenta.getIdSuculenta());
        suculentaEncontrada.setEstado(false);
        suculentaRepository.save(suculenta);
    }

    //ACTIVAR SUCULENTA
    @Transactional
    public void activarSuculenta(Suculenta suculenta){
        Suculenta suculentaEncontrada = suculentaRepository.getOne(suculenta.getIdSuculenta());
        suculentaEncontrada.setEstado(true);
        suculentaRepository.save(suculenta);
    }

    //LISTAR SUCULENTAS
    @Transactional(readOnly = true)
    public List<Suculenta> listarSuculentas(){
        return suculentaRepository.findAll();
    }

}
