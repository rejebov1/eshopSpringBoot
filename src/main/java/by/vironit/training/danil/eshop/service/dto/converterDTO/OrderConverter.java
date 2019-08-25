package by.vironit.training.danil.eshop.service.dto.converterDTO;

import by.vironit.training.danil.eshop.model.Order;
import by.vironit.training.danil.eshop.model.OrderItem;
import by.vironit.training.danil.eshop.model.User;
import by.vironit.training.danil.eshop.service.dto.OrderDTO;
import by.vironit.training.danil.eshop.service.dto.ProductDTO;
import by.vironit.training.danil.eshop.service.dto.UserDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderConverter {

    public static OrderDTO toDTO(Order order, User user) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setAddress(order.getDeliveryAddress());
        orderDTO.setStatus(order.getStatus());
        if (user == null) {
            orderDTO.setUser(order.getUser());
        } else {
            orderDTO.setUser(user);
        }

        if(order.getStatus().equals(Order.OrderStatus.NEW)){
            orderDTO.setPossibleToEdit(true);
        }else{
            orderDTO.setPossibleToEdit(false);
        }

        BigDecimal totalPrice = new BigDecimal(0);
        for (OrderItem orderItem : order.getOrderItems()) {
            orderDTO.getProducts().put(ProductConverter.toDTO(orderItem.getProduct()), orderItem.getQuantity());
            totalPrice = totalPrice.add(orderItem.getProduct().getPrice().multiply(new BigDecimal(orderItem.getQuantity())));
        }
        orderDTO.setTotalPrice(totalPrice);

        return orderDTO;
    }

    public static Order fromDTO(OrderDTO orderDTO) {
        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setDeliveryAddress(orderDTO.getAddress());
        order.setStatus(orderDTO.getStatus());
        order.setUser(orderDTO.getUser());

        for(Map.Entry<ProductDTO, Integer> product: orderDTO.getProducts().entrySet()){
            OrderItem orderPosition = new OrderItem();
            orderPosition.setProduct(ProductConverter.fromDTO(product.getKey()));
            orderPosition.setQuantity(product.getValue());
            order.getOrderItems().add(orderPosition);
        }
        return order;
    }

    public static List<OrderDTO> toDTO(List<Order> orders){
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for(Order order: orders){
            orderDTOS.add(toDTO(order, null));
        }
        return orderDTOS;
    }
}
