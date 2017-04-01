package com.example.sandeep.myapplication.Models;

/**
 * Created by sandeep on 07-02-2017.
 */

public class MyModel
{
    String name;
    String id;
    String image;
    String description;
    String price;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public MyModel(String id,String name, String image, String description, String price) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.price = price;
    }




    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
