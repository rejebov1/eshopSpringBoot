package by.vironit.training.danil.eshop.repository;

import by.vironit.training.danil.eshop.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
