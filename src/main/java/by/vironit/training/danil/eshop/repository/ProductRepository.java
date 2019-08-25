package by.vironit.training.danil.eshop.repository;

import by.vironit.training.danil.eshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select prod from Product prod " +
            "join fetch prod.brand " )
    List<Product> getAllWithBrandDetails();
}
