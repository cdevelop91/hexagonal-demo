package com.example.demo.application.port.in;


import java.util.List;

import com.example.demo.domain.model.Producto;

public interface FiltroProductosService {
    List<Producto> obtenerProductosFiltrados(Double maxPrecio, String ordenarPor, String excluirCategoria);
}
