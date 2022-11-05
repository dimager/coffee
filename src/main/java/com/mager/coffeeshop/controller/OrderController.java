package com.mager.coffeeshop.controller;

import com.mager.coffeeshop.dto.CustomerOrderInfo;
import com.mager.coffeeshop.entity.Order;
import com.mager.coffeeshop.entity.OrderStatus;
import com.mager.coffeeshop.service.OrderService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/order-details/{id}")
    private String getOrderDetails(@PathVariable("id") Long orderId,
                                   Model model) {
        if (orderService.isOrderExist(orderId)) {
            Order order = orderService.getOrderById(orderId);
            model.addAttribute("orderIsAbsent", false);
            model.addAttribute("order", order);
            model.addAttribute("orderDetails", orderService.getOrderDetails(order));
            return "orderdetails.html";
        } else {
            model.addAttribute("orderIsAbsent", true);
            return "redirect:/orders";
        }
    }

    @GetMapping("/orders")
    public String viewOrderPanel(Model model,
                                 @RequestParam(name = "locationId", defaultValue = "1") Optional<Long> locationId,
                                 @RequestParam(name = "order_status", defaultValue = "NEW") String orderStatus,
                                 @RequestParam(name = "page") Optional<Integer> page) {
        int currentPage = page.orElse(0);
        model.addAttribute("allOrderStatus", Arrays.stream(OrderStatus.values()).map(Enum::name).collect(Collectors.toList()));
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("orderStatus", orderStatus);
        model.addAttribute("locationId", locationId.get());
        model.addAttribute("orders", orderService.getOrders(locationId.get(), currentPage, orderStatus));
        return "orders.html";
    }


    @PostMapping("/cart")
    public RedirectView doOrder(@ModelAttribute("orderInfo") CustomerOrderInfo customerOrderInfo, Model model) {
        orderService.doOrder(customerOrderInfo);
        RedirectView redirectView = new RedirectView("/");
        redirectView.setExposeModelAttributes(false);
        return redirectView;
    }

    @PostMapping("/change-discount")
    public RedirectView changeDiscount(@ModelAttribute(name = "orderChangeDisc") Order updateOrder) {
        orderService.changeDiscount(updateOrder);
        RedirectView redirectView = new RedirectView("/order-details/" + updateOrder.getId());
        redirectView.setExposeModelAttributes(false);
        return redirectView;
    }

    @PostMapping("/change-status")
    public RedirectView changeOrderStatus(Order updateOrder) {
        orderService.changeStatus(updateOrder);
        RedirectView redirectView = new RedirectView();
        redirectView.setExposeModelAttributes(false);
        if (updateOrder.getOrderStatus().equals(OrderStatus.CONFIRMED)) {
            redirectView.setUrl("/order-details/" + updateOrder.getId());
        } else {
            redirectView.setUrl("/orders/" + updateOrder.getId());
        }
        return redirectView;
    }
}
