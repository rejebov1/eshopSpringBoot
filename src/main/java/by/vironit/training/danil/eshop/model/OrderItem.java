package by.vironit.training.danil.eshop.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "order_items", schema = "eshop_project_schema")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "order_item_identity_generator")
    @SequenceGenerator(name = "order_item_identity_generator",
            sequenceName = "order_item_id_seq",
            schema = "eshop_project_schema",
            allocationSize = 1)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "id_order",insertable = false,updatable = false)
    private Order order;

    @Column(name = "quantity")
    private Integer quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;

        if (product != null ? !product.equals(orderItem.product) : orderItem.product != null) return false;
        if (order != null ? !order.equals(orderItem.order) : orderItem.order != null) return false;
        return quantity != null ? quantity.equals(orderItem.quantity) : orderItem.quantity == null;
    }

    @Override
    public int hashCode() {
        int result = product != null ? product.hashCode() : 0;
        result = 31 * result + (order != null ? order.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }
}
