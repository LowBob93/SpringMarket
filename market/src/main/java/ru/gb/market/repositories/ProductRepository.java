package ru.gb.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.gb.market.models.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    // @Query("select p from Product p where p.price <= :maxPrice and p.price >= :minPrice")
    // List<Product> findAllByPriceAfterAndTitleContains(int minPrice, String s);
    List<Product> findByPriceBetween(int minPrice,int maxPrice);
    List<Product> findByTitle(String title);
    List<Product> findByPriceBefore(int max);
    List<Product> findByPriceAfter(int min);


}
