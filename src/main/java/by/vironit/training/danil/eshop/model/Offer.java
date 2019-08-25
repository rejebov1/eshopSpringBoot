package by.vironit.training.danil.eshop.model;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "offers", schema = "eshop_project_schema")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "offer_identity_generator")
    @SequenceGenerator(name = "offer_identity_generator",
            sequenceName = "offer_id_seq",
            schema = "eshop_project_schema",
            allocationSize = 1)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToMany
    @JoinTable(name = "product_has_offer", schema = "eshop_project_schema",
            inverseJoinColumns= {@JoinColumn(name = "id_product", referencedColumnName = "id")},
            joinColumns = {@JoinColumn(name = "id_offer", referencedColumnName = "id")})
    private List<Product> products;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "seller_has_offer", schema = "eshop_project_schema",
            joinColumns = {@JoinColumn(name = "id_offer", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "id_seller", referencedColumnName = "id")})
    private Set<Seller> sellers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Offer offer = (Offer) o;

        if (price != null ? !price.equals(offer.price) : offer.price != null) return false;
        if (products != null ? !products.equals(offer.products) : offer.products != null) return false;
        return sellers != null ? sellers.equals(offer.sellers) : offer.sellers == null;
    }

    @Override
    public int hashCode() {
        int result = price != null ? price.hashCode() : 0;
        result = 31 * result + (products != null ? products.hashCode() : 0);
        result = 31 * result + (sellers != null ? sellers.hashCode() : 0);
        return result;
    }
}
