package com.rac.suculentas.service;

import com.rac.suculentas.exception.MyExceptions;
import com.rac.suculentas.model.Categoria;
import com.rac.suculentas.repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    //CREAMOS INSTANCIA DE CATEGORIA REPOSITORIO
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    //CREAR CATEGORIA
    @Transactional
    public void crearCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    //MODIFICAR CATEGORIA
    @Transactional(readOnly = true)
    public Categoria buscaCategoria(Categoria categoria) throws MyExceptions {
        Optional<Categoria> consulta = categoriaRepository.findById(categoria.getNombreCategoria());
        if (consulta.isPresent()) {
        return consulta.get();
        }else {
            throw new MyExceptions("La categoria se encuentra nula");
        }
    }

    //DESACTIVAR CATEGORIA
    @Transactional
    public void desactivarCategoria(Categoria categoria){
        Categoria categoriaEncontrada = categoriaRepository.getOne(categoria.getIdCategoria());
        categoriaEncontrada.setEstado(false);
        categoriaRepository.save(categoriaEncontrada);
    }

    //ACTIVAR CATEGORIA
    @Transactional
    public void activarCategoria(Categoria categoria){
        Categoria categoriaEncontrada = categoriaRepository.getOne(categoria.getIdCategoria());
        categoriaEncontrada.setEstado(true);
        categoriaRepository.save(categoriaEncontrada);
    }

    //LISTAR CATEGORIAS
    @Transactional(readOnly = true)
    public List<Categoria> listarCategoria(){
        return categoriaRepository.findAll();
    }





}
