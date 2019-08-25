package by.vironit.training.danil.eshop.web.controller;

import by.vironit.training.danil.eshop.model.Product;
import by.vironit.training.danil.eshop.service.ProductService;
import by.vironit.training.danil.eshop.service.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;


@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/productList")
    public String getProducts(Model model) {
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);
        return "product";
    }

    /*@RequestMapping("/viewProduct/{productId}")
    public String viewProduct(@PathVariable Long productId, Model model) throws IOException {
        Product product = productService.getById(productId);
        model.addAttribute("product", product);
        return "viewProduct";
    }*/
}