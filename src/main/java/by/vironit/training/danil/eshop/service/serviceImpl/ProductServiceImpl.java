package by.vironit.training.danil.eshop.service.serviceImpl;

import by.vironit.training.danil.eshop.model.Product;
import by.vironit.training.danil.eshop.repository.ProductRepository;
import by.vironit.training.danil.eshop.service.ProductService;
import by.vironit.training.danil.eshop.service.details.DaoList;
import by.vironit.training.danil.eshop.service.dto.ProductDTO;
import by.vironit.training.danil.eshop.service.dto.converterDTO.ProductConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DaoList daoList;

    @Override
    public List<Product> getAllWithBrandDetails() {
        productRepository.getAllWithBrandDetails();
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Product getById(long id) {
        return daoList.getProductRepository().getOne(id);
    }

    @Override
    @Transactional
    public void updateProduct(ProductDTO product) {
        product.setActive(true);
        daoList.getProductRepository().save(ProductConverter.fromDTO(product));
    }

    @Override
    @Transactional
    public void addNew(ProductDTO product) {
        daoList.getProductRepository().save(ProductConverter.fromDTO(product));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        daoList.getProductRepository().deleteById(id);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }


}


