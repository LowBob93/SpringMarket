package ru.gb.market.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.market.DTO.ProductDto;
import ru.gb.market.models.Product;
import ru.gb.market.services.ProductService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;


    @GetMapping("/products")
    public List<ProductDto> findAll(@RequestParam(required = false)int min,
                                    @RequestParam(required = false)int max) {
        List<Product> products =productService.findWithParams(min,max);
        List<ProductDto> productDto = new ArrayList<>();
        for (Product p: products) {
            productDto.add(new ProductDto(p));
        }
        return productDto;
    }


    @GetMapping("/products/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return new ProductDto(productService.findById(id).get());
    }

    @PostMapping("products")
    public ProductDto save(@RequestBody Product product) {
        return new ProductDto(productService.save(product));
    }

    @GetMapping("products/delete/{id}")
    public void  deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }


   /* @GetMapping("/products/price")
    public List<Product> findByPrice(@RequestParam(name = "min") int minPrice,
                                     @RequestParam(name = "max") int maxPrice) {
        return productService.findPriceBetween(minPrice, maxPrice);
    } */

}