package by.vironit.training.danil.eshop.web.controller;

import by.vironit.training.danil.eshop.model.User;
import by.vironit.training.danil.eshop.service.BucketService;
import by.vironit.training.danil.eshop.service.OrderService;
import by.vironit.training.danil.eshop.service.UserService;
import by.vironit.training.danil.eshop.service.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.security.Principal;

@Controller
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private BucketService bucketService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String ordersPage(ModelMap model) throws IOException {
        model.addAttribute("orders", orderService.getCurrentUserOrders());
        return "orders";
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
    public String confirmOrder(ModelMap model,Principal principal) throws IOException {

        if(bucketService.getTotalCount()<1) {
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        model.addAttribute("user", userService.getByEmail(principal.getName()));
        model.addAttribute("bucket", bucketService.getAll());
        model.addAttribute("totalPrice", bucketService.getTotalPrice());
        model.addAttribute("orderItemList", bucketService.getAll());
        return "confirmOrder";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addOrder(ModelMap model, Principal principal) throws IOException {
//        if(bucketService.getTotalCount()<1) {
//            SecurityContextHolder.getContext().setAuthentication(null);
//        }

        OrderDTO order = orderService.generateOrder(userService.getByEmail(principal.getName()));
        Long newId = orderService.addNewOrder(order);
        bucketService.cleanBucket();
        return "redirect:/orders/"+newId;
    }

    @GetMapping(value = "/{orderId}")
    public String orderPage(@PathVariable Long orderId, ModelMap model) throws IOException {
        OrderDTO order = orderService.getById(orderId);
        model.addAttribute("order", order);
        model.addAttribute("totalPrice", orderService.getTotalPrice(order));
        return "singleOrder";
    }

    @GetMapping(value = "/{orderId}/return")
    public String returnOrder(@PathVariable Long orderId, ModelMap model) throws IOException {
        if(orderService.isCurrentUserOrderOwner(orderId)) {
            bucketService.loadOrderToBucket(orderId);
            orderService.deleteOrder(orderId);
        }
        return "redirect:/bucket";
    }

}
