package ru.petshop.kitty.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.petshop.kitty.entities.CartItem;
import ru.petshop.kitty.entities.Order;
import ru.petshop.kitty.services.CartService;
import ru.petshop.kitty.services.OrderService;


@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderService orderService;


    @GetMapping(path="")
    public String cart(@ModelAttribute(value = "order") Order order, Model model){
        boolean emptyCart = false;
        if(cartService.getCartItems().spliterator().getExactSizeIfKnown() == 0)
            emptyCart = true;
        model.addAttribute("cartItems", cartService.getCartItems());
        model.addAttribute("summ", cartService.getSumm());
        model.addAttribute("emptyCart", emptyCart);
        return "cart";
    }
    @PostMapping("/checkout")
    public String checkout(@ModelAttribute("order") Order order, Model model){
        order.setOrderDescription(cartService.toString());
        orderService.addOrder(order);
        Iterable<CartItem> cartItems = cartService.getCartItems();
        String orderDescription = "";
        cartItems.forEach((item) -> {
            item.setOrder(order);
            cartService.updateProduct(item);
        });
        model.addAttribute("order", order);
        System.out.println(cartService.getByOrder(order));
        model.addAttribute("cartItems", cartService.getByOrder(order));
        return "order";
    }
    @RequestMapping("/delete")
    public String deletePetToCart(@RequestParam(name="id", required=true)  Integer cartItemId){
        cartService.deleteProduct(cartItemId);
        return "redirect:/cart";
    }
}
