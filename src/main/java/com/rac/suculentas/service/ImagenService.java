package com.rac.suculentas.service;

import com.rac.suculentas.exception.MyExceptions;
import com.rac.suculentas.model.Imagen;
import com.rac.suculentas.repository.ImagenRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.Optional;

@Service
public class ImagenService {
    private final ImagenRepository imagenRepository;


    public ImagenService(ImagenService imagenService){ this.imagenRepository= ImagenRepository;}

    @Transactional
    public void crearImagen(Imagen imagen){imagenRepository.save(imagen); }
    @Transactional
    public  Imagen buscarImagen(Imagen imagen) throws MyExceptions{
        Optional<Imagen>consulta =ImagenRepository.FindbyId(imagen.setIdImagen());
        if (imagen.isPresent()){
            return consulta.get();
        }else {
            throw new MyExceptions("La imagen es nula");
        }
    }

@Transactional
public void desactivarImagen(Imagen imagen){
    Imagen imagenEncontrada=imagenRepository.getOne(imagen.getIdImagen());
    imagenEncontrada.setEstado(false);
    imagenRepository.save(imagenEncontrada);

}
@Transactional
public void activarImagen(Imagen imagen){
        Imagen imagenEncontrada=imagenRepository.getOne(imagen.getIdImagen());
}
@Transactional(readOnly=true)
public List <Imagen> ListarImagen(){return imagenRepository.findAll()}

}
