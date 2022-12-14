package com.benjy.ecommerce.controller;

import com.benjy.ecommerce.model.Producto;
import com.benjy.ecommerce.model.Usuario;
import com.benjy.ecommerce.service.ProductoService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final Logger LOGGER= LoggerFactory.getLogger(ProductoController.class);
    @Autowired
    private ProductoService productoService;
    @GetMapping("")
    public String show(Model model){
        model.addAttribute("productos",productoService.findAll());
        return "productos/show";
    }
    @GetMapping("/create")
    public  String create(){
        return "productos/create";
    }

    @PostMapping("/save")
    public String save(Producto producto){
        LOGGER.info("Este es el objeto producto {}",producto);

        Usuario u=new Usuario(1L,"","","","","","","",null,null);
        producto.setUsuario(u);
        productoService.save(producto);
        return "redirect:/productos";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id,Model model){
        Producto producto=new Producto();
        Optional<Producto>optionalProducto=productoService.get(id);
        producto=optionalProducto.get();

        LOGGER.info("Producto buscado: {}",producto);
        model.addAttribute("producto",producto);
        return "productos/edit";
    }
    @PostMapping("/update")
    public String update(Producto producto){
        productoService.update(producto);
        return "redirect:/productos";
    }





}
