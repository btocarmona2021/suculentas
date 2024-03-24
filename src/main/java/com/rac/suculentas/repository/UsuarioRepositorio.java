package com.rac.suculentas.repository;

import com.rac.suculentas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {
}
