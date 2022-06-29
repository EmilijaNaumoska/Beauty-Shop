package mk.ukim.finki.buycosmetics.web;

import mk.ukim.finki.buycosmetics.model.BeautyShop;
import mk.ukim.finki.buycosmetics.service.BeautyShopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/beautyShop")
public class BeautyShopController {
    private final BeautyShopService beautyShopService;

    public BeautyShopController(BeautyShopService beautyShopService) {
        this.beautyShopService = beautyShopService;
    }

    @GetMapping("/list")
    public String getShopPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        List<BeautyShop> beautyShopList = this.beautyShopService.listAll();
        model.addAttribute("beautyShopList", beautyShopList);
        return "shopPage";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBeautyShop(@PathVariable Long id) {
        this.beautyShopService.deleteById(id);
        return "redirect:/shop/list";
    }

    @GetMapping("/addsalon")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        BeautyShop beautyShop = new BeautyShop();

        theModel.addAttribute("beautyShop", beautyShop);

        return "add-shop";
    }

    @GetMapping("/edit-form/{id}")
    public String editProductPage(@PathVariable Long id, Model model) {

        BeautyShop beautyShop = this.beautyShopService.findById(id).get();
        this.beautyShopService.deleteById(id);
        model.addAttribute("beautyShop", beautyShop);
        return "add-shop";


    }


    @PostMapping("/add")
    public String saveBeautyShop(

            @RequestParam String name,
            @RequestParam String city,
            @RequestParam String location


    ) {
        this.beautyShopService.save(name, city, location);
        return "redirect:/salon/list";
    }
}
