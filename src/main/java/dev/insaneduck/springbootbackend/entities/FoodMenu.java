package dev.insaneduck.springbootbackend.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "food_menu", schema = "data", catalog = "")
public class FoodMenu {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "image")
    private String image;
    @Basic
    @Column(name = "price")
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodMenu foodMenu = (FoodMenu) o;
        return id == foodMenu.id && Double.compare(foodMenu.price, price) == 0 && Objects.equals(name, foodMenu.name) && Objects.equals(image, foodMenu.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, image, price);
    }
}
