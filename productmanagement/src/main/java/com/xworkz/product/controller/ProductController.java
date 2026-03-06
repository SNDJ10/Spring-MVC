package com.xworkz.product.controller;

import com.xworkz.product.dto.ProductDTO;
import com.xworkz.product.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public String register(ProductDTO dto, Model model) {

        model.addAttribute("message",
                service.validateAndSave(dto));

        return "index";
    }

    @GetMapping("/fetchData")
    public String fetch(Model model) {

        model.addAttribute("products",
                service.getAllProducts());

        return "fetchProducts";
    }

    @GetMapping("/updateRequest")
    public String updateRequest(@RequestParam Integer id,
                                Model model) {

        model.addAttribute("product",
                service.getById(id));

        return "updateProduct";
    }

    @PostMapping("/update")
    public String update(ProductDTO dto, Model model) {

        model.addAttribute("message",
                service.updateProduct(dto));

        return "index";
    }
    @GetMapping("/deleteRequest")
    public String delete(@RequestParam Integer id, Model model) {

        String message = service.deleteProduct(id);

        model.addAttribute("message", message);

        model.addAttribute("products",
                service.getAllProducts());

        return "fetchProducts";
    }
}