package by.vironit.training.danil.eshop.service.serviceImpl;

import by.vironit.training.danil.eshop.model.Order;
import by.vironit.training.danil.eshop.model.Product;
import by.vironit.training.danil.eshop.service.BucketService;
import by.vironit.training.danil.eshop.service.details.Bucket;
import by.vironit.training.danil.eshop.service.details.DaoList;
import by.vironit.training.danil.eshop.service.dto.OrderDTO;
import by.vironit.training.danil.eshop.service.dto.ProductDTO;
import by.vironit.training.danil.eshop.service.dto.converterDTO.OrderConverter;
import by.vironit.training.danil.eshop.service.dto.converterDTO.ProductConverter;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;


@Service("bucketService")
public class BucketServiceImpl implements BucketService {

    @Autowired
    private Bucket bucket;

    @Autowired
    private DaoList daoList;

    @Override
    @Transactional
    public void addToBucket(Long productId, Integer count){
        Product product =
                daoList
                        .getProductRepository()
                        .findById(productId)
                        .orElseThrow(()-> new EntityNotFoundException("no product retrieved"));
        bucket.addProduct(product, count);
    }

    @Override
    @Transactional(readOnly = true)
    public void removeFromBucket(Long productId){
        Product product =
                daoList
                        .getProductRepository()
                        .findById(productId)
                        .orElseThrow(()-> new EntityNotFoundException("no product retrieved"));
        bucket.removeProduct(product);
    }

    @Override
    @Transactional(readOnly = true)
    public void changeProductCount(Long productId, Integer newCount){
        Product product =
                daoList
                        .getProductRepository()
                        .findById(productId)
                        .orElseThrow(()-> new EntityNotFoundException("no product retrieved"));;
        bucket.changeCount(product, newCount);
    }

    @Override
    @Transactional(readOnly = true)
    public int getProductCount(Long productId){
        Product product =
                daoList
                        .getProductRepository()
                        .findById(productId)
                        .orElseThrow(()-> new EntityNotFoundException("no product retrieved"));
        return bucket.getCount(product);
    }

    @Override
    public Map<Product, Integer> getAll(){
        return bucket.getAll();
    }

    @Override
    public Integer getTotalCount(){
        return bucket.getAll().size();
    }

    @Override
    public BigDecimal getTotalPrice(){
        BigDecimal totalPrice = new BigDecimal(0);
        for(Map.Entry<Product, Integer> product: bucket.getAll().entrySet() ){
            totalPrice = totalPrice.add(product.getKey().getPrice().multiply(new BigDecimal(product.getValue())));
        }
        return totalPrice;
    }

    @Override
    public void cleanBucket(){
        bucket.clean();
    }

    @Override
    @Transactional(readOnly = true)
    public void loadOrderToBucket(Long orderId){

        Order retrievedOrder = daoList
                .getOrderRpository()
                .findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("no product found"));

        OrderDTO order = OrderConverter.toDTO(retrievedOrder,null);
        order.getProducts().forEach(
                (prod, quantity) -> bucket.addProduct(ProductConverter.fromDTO(prod), quantity)
        );
    }
}
