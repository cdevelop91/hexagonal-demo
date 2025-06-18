package com.example.demo.application.port.out;

import com.example.demo.domain.model.Producto;
import java.util.List;

public interface ProductoDataPort {
    List<Producto> obtenerTodos(); 
    
    List<Producto> obtenerTodos2(); 
    
}
