package by.vironit.training.danil.eshop.service;

import by.vironit.training.danil.eshop.model.Product;
import by.vironit.training.danil.eshop.service.dto.ProductDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    @Transactional(readOnly = true)
   Product getById(long id);

    @Transactional
    void updateProduct(ProductDTO product);

    @Transactional
    void addNew(ProductDTO product);

    @Transactional
    void delete(Long id);

    List<Product> getAll();

    List<Product> getAllWithBrandDetails();
}