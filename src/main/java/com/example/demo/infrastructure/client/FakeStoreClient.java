package com.example.demo.infrastructure.client;

import com.example.demo.application.port.out.ProductoDataPort;


import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.domain.model.Producto;

@Component
public class FakeStoreClient implements ProductoDataPort {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String BASE_URL = "https://fakestoreapi.com/products";

    public List<Producto> obtenerTodos() {
        Producto[] productos = restTemplate.getForObject(BASE_URL, Producto[].class);
        return Arrays.asList(productos);
    }
}
