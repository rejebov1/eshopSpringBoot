package by.vironit.training.danil.eshop.web.controller;


import by.vironit.training.danil.eshop.service.BucketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequestMapping(value="/bucket")
public class BucketController {

    @Autowired
    BucketService bucketService;

    @RequestMapping(method = RequestMethod.GET)
    public String bucketPage(ModelMap model) throws IOException {
        model.addAttribute("totalOrderItemCount", bucketService.getTotalCount());
        return "bucket";
    }

    @RequestMapping(value="/ajax/add/{productId}")
    public String addToBucket(@PathVariable Long productId, @RequestParam(value="productCount", required=false) Integer count, ModelMap model) throws IOException {
        if (count == null){
            count = 1;
        }
        model.addAttribute("totalOrderItemCount", bucketService.getTotalCount());
        bucketService.addToBucket(productId, count);
        return "ajax_bucketCounter";
    }

    @RequestMapping(value="/ajax/list")
    public String bucketList(ModelMap model) throws IOException {
        model.addAttribute("orderItemList", bucketService.getAll());
        return "ajax_bucketList";
    }

    @RequestMapping(value="/ajax/increase-product-count/{productId}")
    public String bucketListIncrease(@PathVariable Long productId, ModelMap model) throws IOException {
        bucketService.changeProductCount(productId,bucketService.getProductCount(productId)+1);
        return "ajax_bucketList";
    }

    @RequestMapping(value="/ajax/decrease-product-count/{productId}")
    public String bucketListDecrease(@PathVariable Long productId, ModelMap model) throws IOException {
        bucketService.changeProductCount(productId,bucketService.getProductCount(productId)-1);
        return "ajax_bucketList";
    }

}
