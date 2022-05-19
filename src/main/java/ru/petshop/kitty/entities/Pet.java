package ru.petshop.kitty.entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity(name="pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String age;
    private Double price;

    @Column(length=65535)
    @Type(type="text")
    private String description;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="product_type_id")
    private PetType petType;

    private String image;
    private String gender;

    public Pet(){

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setPrice(Double price) { this.price = price;}

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setGender(String gender) { this.gender = gender;}

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getAge() {
        return age;
    }

    public PetType getPetType() {
        return petType;
    }

    public String getDescription() {
        return description;
    }

    public String getGender() {return gender;}
}
