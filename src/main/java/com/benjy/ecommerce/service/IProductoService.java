package com.benjy.ecommerce.service;

import com.benjy.ecommerce.model.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {
    public Producto save(Producto producto);
    public Optional<Producto> get(Long id);
    public void update(Producto producto);
    public void delete(Long id);
    public List<Producto> findAll();
}
