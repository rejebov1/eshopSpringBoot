package by.vironit.training.danil.eshop.service.serviceImpl;

import by.vironit.training.danil.eshop.model.Brand;
import by.vironit.training.danil.eshop.repository.BrandRepository;
import by.vironit.training.danil.eshop.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public void add(Brand brand) {
        brandRepository.save(brand);

    }
    @Override
    public List<Brand> getByName(String name) {
        return brandRepository.findBrandByName(name);
    }

    @Override
    public Optional<Brand> findById(Long id) {
        return brandRepository.findById(id);
    }

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand update(Brand brand) {
        return brandRepository.save(brand);
    }

//    @Override
//    public boolean delete(Long id) {
//        return brandRepository.delete(id);
//    }

    @Override
    public void delete(Brand brand) {
        brandRepository.delete(brand);
    }

}
