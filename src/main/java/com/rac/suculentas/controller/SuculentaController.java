package com.rac.suculentas.controller;

import com.rac.suculentas.exception.MyExceptions;
import com.rac.suculentas.model.Categoria;
import com.rac.suculentas.model.Imagen;
import com.rac.suculentas.model.Suculenta;
import com.rac.suculentas.service.CategoriaService;
import com.rac.suculentas.service.ImagenService;
import com.rac.suculentas.service.SuculentaService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/suculenta")
public class SuculentaController {
    //CREAR INSTANCIA DE SUCULENTA
    private final SuculentaService suculentaService;
    private final CategoriaService categoriaService;

    public SuculentaController(SuculentaService suculentaService, CategoriaService categoriaService) {
        this.suculentaService = suculentaService;
        this.categoriaService = categoriaService;

    }

    //CREAR SUCULENTA
    @GetMapping("/registrar")
    public String registrarSuculenta(Suculenta suculenta, ModelMap model) {
        List<Categoria> listaCategoria = categoriaService.listarCategoria();
        model.put("suculenta", suculenta);
        model.put("listaCategoria", listaCategoria);
        return "registrarsuculenta";
    }

    @PostMapping("/registrado")
    public String suculentaRegistrada(Suculenta suculenta, MultipartFile archivo, ModelMap model) throws MyExceptions {
        suculenta.setFechaAlta(new Date());
        suculentaService.crearSuculenta(suculenta, archivo);
        return "registrarsuculenta";
    }

    @GetMapping("/listar")
    public String listarSuculentas(ModelMap model){
        List<Suculenta> listaSuculentas = suculentaService.listarSuculentas();
        model.addAttribute("listaSuculentas",listaSuculentas);
        return "listarsuculentas";
    }

    //EDITAR SUCULENTA
    @GetMapping("/editar/{idSuculenta}")
    public String editarSuculenta(Suculenta suculenta,ModelMap model) throws MyExceptions {
        try {
            Suculenta suculentaEncontrada = suculentaService.buscarSuculenta(suculenta);
            model.put("suculenta",suculentaEncontrada);
        } catch (MyExceptions e) {
            throw new MyExceptions("La suculenta no pudo ser encontrada, ocurrio un error");
        }
        return "registrarSuculenta";
    }
}
