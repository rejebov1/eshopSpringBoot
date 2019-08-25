package by.vironit.training.danil.eshop.service.dto;

import by.vironit.training.danil.eshop.model.Order;
import by.vironit.training.danil.eshop.model.User;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class OrderDTO {

    private Long id;
    private Order.OrderStatus status;
    private User user;
    private BigDecimal totalPrice;
    private String address;
    private boolean possibleToEdit;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private Map<ProductDTO, Integer> products = new HashMap<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order.OrderStatus getStatus() {
        return status;
    }

    public void setStatus(Order.OrderStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<ProductDTO, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<ProductDTO, Integer> products) {
        this.products = products;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isPossibleToEdit() {
        return possibleToEdit;
    }

    public void setPossibleToEdit(boolean possibleToEdit) {
        this.possibleToEdit = possibleToEdit;
    }
}
