/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package product_management;


/**
 *
 * @author admin
 */
public class Product {
    private int id;
    private String name;
    private String title;
    private String price;
    private String stock;
    private String quantity;

    public Product() {
    }

    public Product(int id, String name, String title, String price, String stock, String quantity) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.price = price;
        this.stock = stock;
        this.quantity = quantity;
    }

  

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", describe=" + title + ", price=" + price + ", stock=" + stock + ", quantity=" + quantity +'}';
    }
    
}
