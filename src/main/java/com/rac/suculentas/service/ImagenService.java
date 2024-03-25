package com.rac.suculentas.service;


import com.rac.suculentas.exception.MyExceptions;
import com.rac.suculentas.model.Imagen;
import com.rac.suculentas.repository.ImagenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ImagenService {
    //CREA INSTANCIA DE IMAGEN REPOSITORIO
    private final ImagenRepository imagenRepository;

    public ImagenService(ImagenRepository imagenRepository) {
        this.imagenRepository = imagenRepository;
    }
   //CREAR IMAGEN
    @Transactional
    public void crearImagen(Imagen imagen) {
        imagenRepository.save(imagen);
    }
    //MODIFICAR IMAGEN
    @Transactional
    public Imagen buscarImagen(Imagen imagen) throws MyExceptions {
        Optional<Imagen> consulta = imagenRepository.findById(imagen.getIdImagen());
        if (consulta.isPresent()) {
            return consulta.get();
        } else {
            throw new MyExceptions("La imagen es nula");
        }
    }

    //DESACTIVAR IMAGEN
    @Transactional
    public void desactivarImagen(Imagen imagen) {
        Imagen imagenEncontrada = imagenRepository.getOne(imagen.getIdImagen());
        imagenEncontrada.setEstado(false);
        imagenRepository.save(imagenEncontrada);

    }

    //  ACTIVAR IMAGEN
   @Transactional
    public void activarImagen(Imagen imagen) {
        Imagen imagenEncontrada = imagenRepository.getOne(imagen.getIdImagen());
        imagenEncontrada.setEstado(true);
        imagenRepository.save(imagenEncontrada);
    }
    //LISTAR IMAGENES
    @Transactional(readOnly = true)
    public List<Imagen> ListarImagen() {
        return imagenRepository.findAll();
    }
}
