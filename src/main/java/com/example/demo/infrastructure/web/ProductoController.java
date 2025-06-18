package com.example.demo.infrastructure.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.application.port.in.FiltroProductosService;
import com.example.demo.domain.model.Producto;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final FiltroProductosService filtroProductosService;

    public ProductoController(FiltroProductosService filtroProductosService) {
        this.filtroProductosService = filtroProductosService;
    }

    @GetMapping("/filtrados")
    public List<Producto> getFiltrados(
            @RequestParam(required = false) Double maxPrecio,
            @RequestParam(required = false) String ordenarPor,
            @RequestParam(required = false) String excluirCategoria
    ) {
        return filtroProductosService.obtenerProductosFiltrados(maxPrecio, ordenarPor, excluirCategoria);
    }
}
