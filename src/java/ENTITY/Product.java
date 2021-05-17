/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTITY;

/**
 *
 * @author Hoàng Thắng <hoangthangrm>
 */
public class Product {
    protected int id;
    protected int idUser;
    protected String name;
    protected String image;
    protected Double price;

    public Product(int id, int idUser, String name, String image, Double price) {
        this.id = id;
        this.idUser = idUser;
        this.name = name;
        this.image = image;
        this.price = price;
    }
    
    public int getId() {
        return id;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public Double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(Double price) {
        this.price = price;
    }   
}
