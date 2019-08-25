package by.vironit.training.danil.eshop.web.controller.admin;

import by.vironit.training.danil.eshop.model.Order;
import by.vironit.training.danil.eshop.service.OrderService;
import by.vironit.training.danil.eshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/admin/orders")
public class AdminOrdersController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String ordersPage(ModelMap model) throws IOException {
        model.addAttribute("orders", orderService.getAll());
        return "admin/editOrders";
    }

    @RequestMapping(value = "/{orderId}/edit", method = RequestMethod.POST)
    public String updateDoc(@PathVariable Long orderId, @RequestParam(value="status") String status){
        orderService.updateOrderStatus(orderId, Order.OrderStatus.valueOf(status));
        return "redirect:/admin/orders";
    }

}
