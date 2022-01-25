package com.NoCruelty.NoCruelty.controllers;

import com.NoCruelty.NoCruelty.models.Product;
import com.NoCruelty.NoCruelty.models.ShoppingCart;
import com.NoCruelty.NoCruelty.service.Interfaces.IProductService;
import com.NoCruelty.NoCruelty.repositories.ShoppingCartRepository;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ShoppingCartController {

    @Autowired
    IProductService iProductService;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @PostMapping(value = "/Delete/{indice}")
    public String DeleteCart(@PathVariable int indice, HttpServletRequest request) {
        ArrayList<Product> cart = (ArrayList<Product>) this.getCart(request);
        if (cart != null && cart.size() > 0 && cart.get(indice) != null) {
            cart.remove(indice);
            this.SaveCart(cart, request);
        }
        return "redirect:/shoppingCart/";
    }

    private void cleanCart(HttpServletRequest request) {
        this.SaveCart(new ArrayList<>(), request);
    }

    @GetMapping(value = "/limpiar")
    public String cancelCart(HttpServletRequest request, RedirectAttributes redirectAttrs) {
        this.cleanCart(request);
        redirectAttrs
                .addFlashAttribute("mensaje", "Venta cancelada")
                .addFlashAttribute("clase", "info");
        return "redirect:/vender/";
    }

    @PostMapping(value = "/terminar")
    public String ckeckOutCart(HttpServletRequest request, RedirectAttributes redirectAttrs) {
        ArrayList<Product> cart = this.getCart(request);
        // Si no hay carrito o está vacío, regresamos inmediatamente
        if (cart == null || cart.size() <= 0) {
            return "redirect:/ShoppingCart/";
        }
        ShoppingCart shopping = shoppingCartRepository.save(new ShoppingCart());
        // Recorrer el carrito
        for (Product product : cart) {
            // Obtener el producto fresco desde la base de datos
            Product p = iProductService.findProductId(product.getId()).orElse(null);
            if (p == null) {
                continue; // Si es nulo o no existe, ignoramos el siguiente código con continue
            }//             Le restamos existencia
           iProductService.deleteProduct(product.getId());
            // Lo guardamos con la existencia ya restada
            iProductService.saveProduct(product);

        }

        // Al final limpiamos el carrito
        this.cleanCart(request);
        // e indicamos una venta exitosa
        redirectAttrs
                .addFlashAttribute("mensaje", "Venta realizada correctamente")
                .addFlashAttribute("clase", "success");
        return "redirect:/vender/";
    }

    private ArrayList<Product> getCart(HttpServletRequest request) {
        ArrayList<Product> cart = (ArrayList<Product>) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        return cart;
    }

    @PostMapping(value = "/agregar")
    public String AddToCart(@ModelAttribute Product product, HttpServletRequest request, RedirectAttributes redirectAttrs) {
        ArrayList<Product> cart = this.getCart(request);
        Product findProductId = iProductService.findProductId("id-product");
        if (findProductId == null) {
            redirectAttrs
                    .addFlashAttribute("mensaje", "El producto con el código " + product.getName() + " no existe")
                    .addFlashAttribute("clase", "warning");
            return "redirect:/vender/";
        }
        if (findProductId.sinStock()) {
            redirectAttrs
                    .addFlashAttribute("mensaje", "El producto está agotado")
                    .addFlashAttribute("clase", "warning");
            return "redirect:/vender/";
        }
        boolean encontrado = false;
        for (Product products : cart) {
            if (products.getName().equals(findProductId.getId())) {
                products.plusStock(0);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            cart.add(product);
        }
        this.SaveCart(cart, request);
        return "redirect:/vender/";
    }

    private void SaveCart(ArrayList<Product> cart, HttpServletRequest request) {
        ShoppingCart shoppingCart = null;
        ShoppingCart save = shoppingCartRepository.save(shoppingCart);
    }
  
}
