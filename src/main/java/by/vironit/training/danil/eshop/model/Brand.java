package by.vironit.training.danil.eshop.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "brands", schema = "eshop_project_schema")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "brand_identity_generator")
    @SequenceGenerator(name = "brand_identity_generator",
            sequenceName = "brands_id_seq",
            schema = "eshop_project_schema",
            allocationSize = 1)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "produce_country")
    private String produceCountry;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Brand brand = (Brand) o;

        return name != null ? name.equals(brand.name) : brand.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
