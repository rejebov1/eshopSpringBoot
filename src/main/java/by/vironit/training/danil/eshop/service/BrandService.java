package by.vironit.training.danil.eshop.service;

import by.vironit.training.danil.eshop.model.Brand;

import java.util.List;
import java.util.Optional;


public interface BrandService {

    void add(Brand brand);

    List<Brand> getByName(String name);

    Optional<Brand> findById(Long id);

    List<Brand> getAll();

    Brand update(Brand brand);

//    boolean delete(Long id);

    void delete(Brand brand);
}

