package mk.ukim.finki.buycosmetics.web;

import mk.ukim.finki.buycosmetics.model.BeautyShop;
import mk.ukim.finki.buycosmetics.model.Product;
import mk.ukim.finki.buycosmetics.service.BeautyShopService;
import mk.ukim.finki.buycosmetics.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final BeautyShopService beautyShopService;

    public ProductController(ProductService productService, BeautyShopService beautyShopService) {
        this.productService = productService;
        this.beautyShopService = beautyShopService;
    }


    @GetMapping("/list")
    public String getProductsPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        List<Product> productList = this.productService.listAll();
        model.addAttribute("productsList", productList);
        return "productsPage";
    }

    @GetMapping("/list/{id}")
    public String getProductsFromShops(@RequestParam(required = false) String error, @PathVariable Long id, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        List<Product> productList = this.productService.listFromShop(id);
        model.addAttribute("productsList", productList);
        return "productsPage";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        this.productService.deleteById(id);
        return "redirect:/products/list";
    }

    @GetMapping("/addProduct")
    public String showFormForAddProduct(Model theModel) {

        // create model attribute to bind form data
        Product product = new Product();

        theModel.addAttribute("product", product);
        List<BeautyShop> beautyShops=this.beautyShopService.listAll();
        theModel.addAttribute("shops",beautyShops);

        return "add-product";
    }

    @GetMapping("/edit-form/{id}")
    public String editProductPage(@PathVariable Long id, Model model) {

        Product product = this.productService.findById(id).get();
        model.addAttribute("product", product);
        List<BeautyShop> beautyShops=this.beautyShopService.listAll();
        model.addAttribute("beautyShops",beautyShops);
        return "add-product";


}

    @PostMapping("/add/{id}")
    public String update(@PathVariable Long id,
                         @RequestParam Long beautyShop,
                         @RequestParam String name,
                         @RequestParam Integer price,
                         @RequestParam String type,
                         @RequestParam String description,
                         @RequestParam String image,
                         @RequestParam String rating,

                         Model model
    ) {
        this.productService.update(id,beautyShop, name,price,type,description,rating,image);
        return "redirect:/products/list";
    }

    @PostMapping("/add")
    public String saveUser(
            @RequestParam String name,
            @RequestParam Integer price,
            @RequestParam String type,
            @RequestParam String description,
            @RequestParam Long beautyShop,
            @RequestParam String image, Model model
    ) {
        Product product=this.productService.save(name, price, type, description, beautyShop, image);
        return "redirect:/cars/list";
    }
}
