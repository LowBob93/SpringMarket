package ru.gb.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.market.models.Product;
import ru.gb.market.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);

    }
    public Product save(Product product){
        return productRepository.save(product);
    }
    public List<Product>findPriceBetween(int minPrice, int maxPrice){
        return productRepository.findByPriceBetween(minPrice,maxPrice);
    }

    public List<Product> findByTitle(String title){
        return productRepository.findByTitle(title);
    }
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
    public List<Product> findWithParams(Integer min,Integer max){
        if (min == null && max ==null){
            return productRepository.findAll();}
        else if (min == null && max !=null){
            return  productRepository.findByPriceBefore(max);}
        else if (min != null && max==null ){
            return productRepository.findByPriceAfter(min);}
        else {
            return  productRepository.findByPriceBetween(min,max);
            }
        }
    }


