package by.vironit.training.danil.eshop.repository;

import by.vironit.training.danil.eshop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRpository extends JpaRepository<Order, Long> {
}
