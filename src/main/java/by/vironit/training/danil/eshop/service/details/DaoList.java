package by.vironit.training.danil.eshop.service.details;

import by.vironit.training.danil.eshop.repository.*;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public class DaoList {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRpository orderRpository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private SellerRepository sellerRepository;
}
