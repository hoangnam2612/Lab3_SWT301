/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package product_management;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class ProductBO {

    private List<Product> listProduct;

    public ProductBO() {
        this.listProduct = new ArrayList<>();
    }

    public ProductBO(List<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public List<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public boolean add(String id, String name, String title, String price, String stock, String quantity) throws Exception {
        int parsedID = 0;
        try {
            parsedID = Integer.parseInt(String.valueOf(id));
            if (parsedID <= 0 || parsedID >= 1000) {
                throw new Exception("id must be > 0 and < 1000");
            }

            for (Product product : listProduct) {
                if (product.getId() == parsedID) {
                    throw new Exception("Code is exist");
                }
            }
        } catch (NumberFormatException e) {
            throw new Exception("id must be a valid integer");
        }

        if (name == null || name.length() >= 10 || name.length() <= 0) {
            throw new Exception("name length must be < 10 and > 0");
        }
        if (title == null || title.length() >= 20 || title.length() <= 0) {
            throw new Exception("title length must be < 10 and > 0");
        }

        // Check if quantity is a valid integer
        try {
            int parsedQuantity = Integer.parseInt(String.valueOf(quantity));
            int parsedPrice = Integer.parseInt(String.valueOf(price));
            int parsedStock = Integer.parseInt(String.valueOf(stock));

            if (parsedPrice <= 0 || parsedPrice >= 50) {
                throw new Exception("price must be > 0");
            }
            if (parsedStock <= 0 || parsedStock >= 50) {
                throw new Exception("stock must be > 0 and < 50");
            }
            if (parsedQuantity <= 0 || parsedQuantity >= 20) {
                throw new Exception("quantity must be > 0 and < 20");
            }
        } catch (NumberFormatException e) {
            throw new Exception("input must be a valid integer");
        }
        listProduct.add(new Product(parsedID, name, price, price, stock, quantity));
        return true;
    }

    public boolean delete(String id) throws Exception {
        try {
            int parsedID = Integer.parseInt(String.valueOf(id));
            if (parsedID <= 0 || parsedID >= 1000) {
                throw new Exception("id must be > 0 and < 1000");
            }
        } catch (NumberFormatException e) {
            throw new Exception("id must be a valid integer");
        }
        Product p = get(id);
        return listProduct.remove(p);
    }

    public Product get(String id) throws Exception {
        if (id == null) {
            throw new Exception("id cannot be null");
        }

        try {
            int parsedID = Integer.parseInt(id);
            if (parsedID <= 0 || parsedID >= 1000) {
                throw new Exception("id must be > 0 and < 1000");
            }

            for (Product product : listProduct) {
                if (product.getId() == parsedID) {
                    return product;
                }
            }
        } catch (NumberFormatException e) {
            throw new Exception("id must be a valid integer");
        }

        return null;
    }

    public boolean update(String id, String name, String title, String price, String stock, String quantity) throws Exception {
        try {
            int parsedID = Integer.parseInt(String.valueOf(id));
            if (parsedID <= 0 || parsedID >= 1000) {
                throw new Exception("id must be > 0 and < 1000");
            }

            Product existingProduct = get(id);
            if (existingProduct == null) {
                throw new Exception("Product not found");
            }

            // Validate and update the product information
            if (name != null && name.length() < 10 && name.length() > 0) {
                existingProduct.setName(name);
            } else {
                throw new Exception("Invalid name");
            }

            if (title != null && title.length() < 20 && title.length() > 0) {
                existingProduct.setTitle(title);
            } else {
                throw new Exception("Invalid title");
            }

            int parsedPrice = Integer.parseInt(String.valueOf(price));
            int parsedStock = Integer.parseInt(String.valueOf(stock));
            int parsedQuantity = Integer.parseInt(String.valueOf(quantity));

            if (parsedPrice > 0 && parsedPrice < 50
                    && parsedStock > 0 && parsedStock < 50
                    && parsedQuantity > 0 && parsedQuantity < 20) {
                existingProduct.setPrice(price);
                existingProduct.setStock(stock);
                existingProduct.setQuantity(quantity);
            } else {
                throw new Exception("Invalid price, stock, or quantity");
            }

            return true;
        } catch (NumberFormatException e) {
            throw new Exception("Input must be a valid integer");
        }
    }
}
