package ru.petshop.kitty.entities;

public class SimplePet {
    private int id;
    private String name;
    private String price;
    private String description;
    private int petType;
    private String image;
    public SimplePet(int id,String name,String price,String description,int petType,String image){
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.petType = petType;
        this.image = image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPetType(int petType) {
        this.petType = petType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public int getPetType() {
        return petType;
    }

    public String getPrice() {
        return price;
    }
}
