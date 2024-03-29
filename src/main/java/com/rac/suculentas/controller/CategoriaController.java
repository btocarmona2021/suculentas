package com.rac.suculentas.controller;

import com.rac.suculentas.exception.MyExceptions;
import com.rac.suculentas.model.Categoria;
import com.rac.suculentas.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    //REGISTRAR CATEGORIA DE SUCULENTA
    @GetMapping("/registrar")
    public String registrarCategoria(Categoria categoria, ModelMap model) {
        model.put("categoria",categoria);
        return "registrarcategoria";
    }
    @PostMapping("/registrado")
    public String categoriaRegistrada(Categoria categoria, MultipartFile ImagenCategoria, ModelMap model) {
        categoriaService.crearCategoria(categoria,ImagenCategoria);
        return "redirect:listar";
    }

    //LISTAR CATEGORIAS
    @RequestMapping("/listar")
    public String listarCategoria(ModelMap model){
        List<Categoria> listaCategoria = categoriaService.listarCategoria();
        model.addAttribute("listacategorias",listaCategoria);
        return "listarcategorias";
    }

    //EDITAR CATEGORIA
    @GetMapping("/editar/{idCategoria}")
    public String editar(Categoria categoria, ModelMap model) throws MyExceptions {
        try {
            model.put("categoria",categoriaService.buscaCategoria(categoria));
        } catch (MyExceptions e) {
            model.put("error",e.getMessage());
            throw new MyExceptions("No se encontro la categoria");
        };
        return "registrarcategoria";
    }
    //EDITAR CATEGORIA
    @GetMapping("/activar/{idCategoria}")
    public String activar(Categoria categoria, ModelMap model){
        categoriaService.activarCategoria(categoria);
        return "redirect:/categoria/listar";
    }
    //EDITAR CATEGORIA
    @GetMapping("/desactivar/{idCategoria}")
    public String desactivar(Categoria categoria, ModelMap model){
        categoriaService.desactivarCategoria(categoria);
        return "redirect:/categoria/listar";
    }


}
