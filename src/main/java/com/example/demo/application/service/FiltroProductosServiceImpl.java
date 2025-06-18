package com.example.demo.application.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.application.port.in.FiltroProductosService;
import com.example.demo.domain.model.Producto;
import com.example.demo.infrastructure.client.FakeStoreClient;
import com.example.demo.application.port.out.ProductoDataPort;

@Service
public class FiltroProductosServiceImpl implements FiltroProductosService {

	private final ProductoDataPort productoDataPort;

	public FiltroProductosServiceImpl(ProductoDataPort productoDataPort) {
	    this.productoDataPort = productoDataPort;
	}

    @Override
    public List<Producto> obtenerProductosFiltrados(Double maxPrecio, String ordenarPor, String excluirCategoria) {
        List<Producto> productos = productoDataPort.obtenerTodos();

        return productos.stream()
                .filter(p -> maxPrecio == null || p.getPrice() <= maxPrecio)
                .filter(p -> excluirCategoria == null || !p.getCategory().equalsIgnoreCase(excluirCategoria))
                .sorted((p1, p2) -> {
                    if ("rating".equalsIgnoreCase(ordenarPor)) {
                        return Double.compare(
                                p2.getRating().getRate() != null ? p2.getRating().getRate() : 0,
                                p1.getRating().getRate() != null ? p1.getRating().getRate() : 0);
                    }
                    return 0;
                })
                .collect(Collectors.toList());
    }
}
