package com.rac.suculentas.service;

import com.rac.suculentas.exception.MyExceptions;
import com.rac.suculentas.model.Usuario;
import com.rac.suculentas.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    //CREAR INSTANCA DE USUARIO CONTROLADOR
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //CREAR USUARIO
    @Transactional
    public void crearUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    //MODIFICAR USUARIO
    @Transactional
    public Usuario buscarUsuario(Usuario usuario) throws MyExceptions {
        Optional<Usuario> consulta = usuarioRepository.findById(usuario.getIdUsuario());
        if (consulta.isPresent()){
            return consulta.get();
        }else{
            throw new MyExceptions("El usuario esta vacio o nulo");
        }
    }

    //DESACTIVAR USUARIO
    @Transactional
    public void desactivarUsuario(Usuario usuario){
        Usuario usuarioEncontrado = usuarioRepository.getOne(usuario.getIdUsuario());
        usuarioEncontrado.setEstado(false);
        usuarioRepository.save(usuarioEncontrado);
    }
    //ACTIVAR USUARIO
    @Transactional
    public void activarUsuario(Usuario usuario){
        Usuario usuarioEncontrado = usuarioRepository.getOne(usuario.getIdUsuario());
        usuarioEncontrado.setEstado(true);
        usuarioRepository.save(usuarioEncontrado);
    }

    //LISTAR USUARIO
    @Transactional(readOnly = true)
    public List<Usuario> listarUsuario(Usuario usuario){
        return usuarioRepository.findAll();
    }
}
