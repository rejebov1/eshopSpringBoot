package by.vironit.training.danil.eshop.service.dto.converterDTO;

import by.vironit.training.danil.eshop.model.Product;
import by.vironit.training.danil.eshop.service.dto.ProductDTO;

public class ProductConverter {

    public static ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        return productDTO;
    }


    public static Product fromDTO(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        return product;
    }
}
