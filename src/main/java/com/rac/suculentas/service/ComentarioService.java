package com.rac.suculentas.service;

import com.rac.suculentas.exception.MyExceptions;
import com.rac.suculentas.model.Comentario;
import com.rac.suculentas.repository.ComentarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService {

    //INSTANCIA DE REPOSITORIO COMENTARIO
    private final ComentarioRepository comentarioRepository;

    public ComentarioService(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    //CREAR COMENTARIO
    @Transactional
    public void crearComentario(Comentario comentario){
        comentarioRepository.save(comentario);
    }

    //MODIFICAR COMENTARIO
    @Transactional(readOnly = true)
    public Comentario buscarComentario (Comentario comentario) throws MyExceptions {
        Optional<Comentario> consulta = comentarioRepository.findById(comentario.getIdComentario());
        if (consulta.isPresent()){
            return consulta.get();
        }else{
            throw new MyExceptions("El comentario es nulo");
        }
    }

    //DESACTIVAR COMENTARIO
    @Transactional
    public void desactivarComentario(Comentario comentario){
    Comentario comentarioEncontrado = comentarioRepository.getOne(comentario.getIdComentario());
    comentarioEncontrado.setEstado(false);
    comentarioRepository.save(comentarioEncontrado);
    }

    //ACTIVAR COMENTARIO
    @Transactional
    public void activarComentario(Comentario comentario){
    Comentario comentarioEncontrado = comentarioRepository.getOne(comentario.getIdComentario());
    comentarioEncontrado.setEstado(true);
    comentarioRepository.save(comentarioEncontrado);
    }

    @Transactional(readOnly = true)
    public List<Comentario> listarcomentario(){
        return comentarioRepository.findAll();
    }

}
