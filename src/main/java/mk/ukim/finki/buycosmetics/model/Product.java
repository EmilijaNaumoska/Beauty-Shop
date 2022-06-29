package mk.ukim.finki.buycosmetics.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer price;
    private String type;
    private String description;
    private String image;
    private String rating;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<BeautyShop> beautyShops;

    public Product() {

    }

    public Product(String name, Integer price, String type, String description, String image, String rating, long id) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.description = description;
        this.image = image;
        this.rating = rating;
        this.id=id;
        this.beautyShops=new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public List<BeautyShop> getBeautyShops() {
        return beautyShops;
    }

    public void setBeautyShops(List<BeautyShop> beautyShops) {
        this.beautyShops = beautyShops;
    }


}


