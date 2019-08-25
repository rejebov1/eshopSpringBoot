package by.vironit.training.danil.eshop.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "merch_models", schema = "eshop_project_schema")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class MerchModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "merch_model_identity_generator")
    @SequenceGenerator(name = "merch_model_identity_generator",
            sequenceName = "merch_models_id_seq",
            schema = "eshop_project_schema",
            allocationSize = 1)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_brand")
    private Brand brand;

    @Column(name = "date_of_issue")
    private LocalDate dateOfIssue;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MerchModel that = (MerchModel) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
