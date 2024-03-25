package com.rac.suculentas.service;


import com.rac.suculentas.exception.MyExceptions;
import com.rac.suculentas.model.Imagen;
import com.rac.suculentas.repository.ImagenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public Imagen crearImagen(MultipartFile archivo) throws MyExceptions {
        if (archivo != null) {
            Imagen imagen = new Imagen();
            try {
                imagen.setNombre(archivo.getOriginalFilename());
                imagen.setMime(archivo.getContentType());
                imagen.setContenido(archivo.getBytes());
                imagenRepository.save(imagen);
                return imagen;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            throw new MyExceptions("No se encontró ninguna imagen , intente nuevamente");
        }
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
