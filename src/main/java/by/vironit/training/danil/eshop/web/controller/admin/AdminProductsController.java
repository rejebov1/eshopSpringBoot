package by.vironit.training.danil.eshop.web.controller.admin;

import by.vironit.training.danil.eshop.model.Product;
import by.vironit.training.danil.eshop.service.ProductService;
import by.vironit.training.danil.eshop.service.dto.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/products")
public class AdminProductsController {

    private static final Logger logger = LoggerFactory.getLogger(AdminProductsController.class);

    @Autowired
    private ProductService productService;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String editProduct(@PathVariable Long id, ModelMap model) {
        model.addAttribute("product", productService.getById(id));
        model.addAttribute("action", "Изменить");
        return "addOrEditProduct";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String updateProduct(@PathVariable Long id, @Valid @ModelAttribute("product") ProductDTO product, BindingResult result) {
        if (result.hasErrors()) {
            return "addOrEditProduct";
        }
        product.setId(id);
        productService.updateProduct(product);
        return "redirect:/admin/products";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addProduct(ModelMap model) {
        model.addAttribute("product", new ProductDTO());
        model.addAttribute("action", "Добавить");
        return "admin/addOrEditProduct";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveProduct(@Valid @ModelAttribute("product") ProductDTO product, BindingResult result) {
        if (result.hasErrors()) {
            return "addOrEditProduct";
        }
        productService.addNew(product);
        return "redirect:/admin/products";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public String deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return "redirect:/admin/products";
    }


}
