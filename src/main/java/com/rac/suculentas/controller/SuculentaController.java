package com.rac.suculentas.controller;

import com.rac.suculentas.model.Suculenta;
import com.rac.suculentas.service.SuculentaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/suculenta")
public class SuculentaController {
    //CREAR INSTANCIA DE SUCULENTA
    private final SuculentaService suculentaService;

    public SuculentaController(SuculentaService suculentaService) {
        this.suculentaService = suculentaService;
    }

    @GetMapping("/registrar")
    public String registrarSuculenta(Suculenta suculenta, ModelMap model){
        model.put("suculenta",suculenta);
        return "registrarsuculenta";
    }
}
