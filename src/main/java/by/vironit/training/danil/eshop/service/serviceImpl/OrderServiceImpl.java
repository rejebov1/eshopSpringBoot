package by.vironit.training.danil.eshop.service.serviceImpl;

import by.vironit.training.danil.eshop.model.Order;
import by.vironit.training.danil.eshop.model.Product;
import by.vironit.training.danil.eshop.model.User;
import by.vironit.training.danil.eshop.service.BucketService;
import by.vironit.training.danil.eshop.service.OrderService;
import by.vironit.training.danil.eshop.service.UserService;
import by.vironit.training.danil.eshop.service.details.DaoList;
import by.vironit.training.danil.eshop.service.dto.OrderDTO;
import by.vironit.training.danil.eshop.service.dto.ProductDTO;
import by.vironit.training.danil.eshop.service.dto.UserDTO;
import by.vironit.training.danil.eshop.service.dto.converterDTO.OrderConverter;
import by.vironit.training.danil.eshop.service.dto.converterDTO.ProductConverter;
import by.vironit.training.danil.eshop.service.dto.converterDTO.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private BucketService bucketService;

    @Autowired
    private DaoList daoList;

    @Autowired
    private UserService userService;

    @Override
    public OrderDTO generateOrder(User user) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setStatus(Order.OrderStatus.NEW);
        orderDTO.setUser(user);
        bucketService.getAll().forEach(
                (product, quantity) ->
                    orderDTO.getProducts().put(ProductConverter.toDTO(product), quantity)
        );
        return orderDTO;
    }

    @Override
    @Transactional
    public Long addNewOrder(OrderDTO orderDTO) {
        Order save = daoList.getOrderRpository().save(OrderConverter.fromDTO(orderDTO));
        return save.getId();
    }

    @Override
    @Transactional
    public OrderDTO getById(Long id) {
        OrderDTO order = null;
        if (id != null) {
            order = OrderConverter.toDTO(daoList.getOrderRpository().getOne(id), null);
        }
        return order;
    }

    @Override
    public BigDecimal getTotalPrice(OrderDTO order) {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<ProductDTO, Integer> product : order.getProducts().entrySet()) {
            totalPrice = totalPrice.add(product.getKey().getPrice().multiply(new BigDecimal(product.getValue())));
        }
        return totalPrice;
    }

    @Override
    @Transactional
    public void updateOrderStatus(Long id, Order.OrderStatus status) {
        daoList.getOrderRpository().getOne(id).setStatus(status);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderDTO> getCurrentUserOrders() {
        Long id = userService.getCurrentUser().getId();
        UserDTO user = UserConverter.toDTO(daoList.getUserRepository().getOne(id), true);
        return user.getOrders();
    }

    @Override
    @Transactional
    public List<OrderDTO> getAll() {
        return OrderConverter.toDTO(daoList.getOrderRpository().findAll());
    }


    @Override
    @Transactional(readOnly = true)
    public boolean isCurrentUserOrderOwner(Long orderId) {
        for (OrderDTO order : getCurrentUserOrders()) {
            if (Objects.equals(order.getId(), orderId)) return true;
        }
        return false;
    }

    @Override
    @Transactional
    public void deleteOrder(Long orderId) {
        Order order = daoList.getOrderRpository().getOne(orderId);
        if (order.getStatus() == Order.OrderStatus.NEW) {
            daoList.getOrderRpository().deleteById(orderId);
        }
    }


}
