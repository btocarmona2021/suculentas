package com.rac.suculentas.controller;

import com.rac.suculentas.exception.MyExceptions;
import com.rac.suculentas.model.Imagen;
import com.rac.suculentas.service.ImagenService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/imagen")
public class recuperaImagen {
    private final ImagenService imagenService;

    public recuperaImagen(ImagenService imagenService) {
        this.imagenService = imagenService;
    }

    @GetMapping("/carga/{idImagen}")
    public ResponseEntity<byte[]> devuelveImagen(Imagen imagen) {
        Imagen imagenRecuperada = null;
        try {
            imagenRecuperada = imagenService.buscarImagen(imagen);
            byte[] image = imagenRecuperada.getContenido();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            return new ResponseEntity<>(image, headers, HttpStatus.OK);
        } catch (MyExceptions e) {
            throw new RuntimeException(e);
        }
    }

}
