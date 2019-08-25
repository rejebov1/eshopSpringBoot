package by.vironit.training.danil.eshop.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sellers", schema = "eshop_project_schema")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "seller_identity_generator")
    @SequenceGenerator(name = "seller_identity_generator",
            sequenceName = "seller_id_seq",
            schema = "eshop_project_schema",
            allocationSize = 1)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    /*@ManyToMany
    @JoinTable(name = "seller_has_address", schema = "eshop_project_schema",
            joinColumns = {@JoinColumn(name = "id_address", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "id_seller", referencedColumnName = "id")})
    private Set<Address> addresses;*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seller seller = (Seller) o;

        return name != null ? name.equals(seller.name) : seller.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
