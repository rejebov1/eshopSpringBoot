package by.vironit.training.danil.eshop.service;

import by.vironit.training.danil.eshop.model.Order;
import by.vironit.training.danil.eshop.model.User;
import by.vironit.training.danil.eshop.service.dto.OrderDTO;
import by.vironit.training.danil.eshop.service.dto.UserDTO;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {

    OrderDTO generateOrder(User user);

    @Transactional
    Long addNewOrder(OrderDTO orderDTO);

    @Transactional
    OrderDTO getById(Long id);

    BigDecimal getTotalPrice(OrderDTO order);

    @Transactional
    void updateOrderStatus(Long id, Order.OrderStatus status);

    @Transactional(readOnly = true)
    List<OrderDTO> getCurrentUserOrders();

    @Transactional(readOnly = true)
    List<OrderDTO> getAll();


    @Transactional(readOnly = true)
    boolean isCurrentUserOrderOwner(Long orderId);

    @Transactional
    void deleteOrder(Long orderId);
}
