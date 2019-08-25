package by.vironit.training.danil.eshop.service.details;

import by.vironit.training.danil.eshop.model.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component("bucket")
@Scope(value="session", proxyMode= ScopedProxyMode.TARGET_CLASS)
public class Bucket {

    private Map<Product, Integer> products = new HashMap<>();

    public void addProduct(Product product, Integer count){
        products.put(product, count);
    }

    public void removeProduct(Product product){
        products.remove(product);
    }

    public void changeCount(Product product, Integer newCount){
        if(newCount == 0){
            removeProduct(product);
        } else {
            addProduct(product, newCount);
        }
    }

    public int getCount(Product product){
        return products.get(product);
    }

    public Map<Product, Integer> getAll(){
        return products;
    }

    public void clean(){
        products = new HashMap<>();
    }

}
