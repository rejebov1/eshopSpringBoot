package by.vironit.training.danil.eshop.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders", schema = "eshop_project_schema")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "order_identity_generator")
    @SequenceGenerator(name = "order_identity_generator",
            sequenceName = "order_id_seq",
            schema = "eshop_project_schema",
            allocationSize = 1)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column
    private String deliveryAddress;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;


    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_order",
            nullable = false)
    private List<OrderItem> orderItems = new ArrayList<>();

    public enum OrderStatus{
        NEW, DELIVERY_IN_PROCESS,DELIVERED
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (name != null ? !name.equals(order.name) : order.name != null) return false;
        return status == order.status;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
