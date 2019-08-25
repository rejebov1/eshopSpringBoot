package by.vironit.training.danil.eshop.repository;

import by.vironit.training.danil.eshop.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Long> {

   List<Brand> findBrandByName(String name);
}
