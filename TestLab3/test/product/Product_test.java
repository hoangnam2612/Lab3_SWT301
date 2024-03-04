/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package product;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import product_management.Product;
import product_management.ProductBO;

/**
 *
 * @author admin
 */
public class Product_test {

    public Product_test() {
    }

    @Test
    public void testAddValidProduct() {
        ProductBO productBO = new ProductBO();
        try {
            assertTrue(productBO.add("1", "Product1", "Title1", "10", "5", "15"));
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
        // Additional assertions if needed
    }

    // id
    @Test
    public void testAddDuplicateCode() {
        List<Product> productList = new ArrayList<>();
        ProductBO productBO = new ProductBO(productList);
        Product p = new Product(1, "Product2", "Title2", "10", "5", "15");
        productList.add(p);
        try {
            assertFalse(productBO.add("1", "Product2", "Title2", "10", "5", "15"));
        } catch (Exception e) {
            assertEquals("Code is exist", e.getMessage());
        }
    }

    @Test
    public void testAddInvalidCode1() {
        List<Product> productList = new ArrayList<>();
        ProductBO productBO = new ProductBO(productList);

        try {
            assertFalse(productBO.add("1001", "Product2", "Title2", "10", "5", "15"));
        } catch (Exception e) {
            assertEquals("id must be > 0 and < 1000", e.getMessage());
        }
    }

    @Test
    public void testAddInvalidCode2() {
        List<Product> productList = new ArrayList<>();

        ProductBO productBO = new ProductBO(productList);
        try {
            assertFalse(productBO.add("", "Product2", "Title2", "10", "5", "15"));
        } catch (Exception e) {
            assertEquals("id must be a valid integer", e.getMessage());
        }
    }

    @Test
    public void testAddInvalidCode3() {
        List<Product> productList = new ArrayList<>();

        ProductBO productBO = new ProductBO(productList);
        try {
            assertFalse(productBO.add("abc", "Product2", "Title2", "10", "5", "15"));
        } catch (Exception e) {
            assertEquals("id must be a valid integer", e.getMessage());
        }
    }

    @Test
    public void testAddInvalidCode4() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "Product1", "Title1", "10", "5", "15"));

        ProductBO productBO = new ProductBO(productList);
        try {
            assertFalse(productBO.add(null, "Product2", "Titlnulle2", "10", "5", "15"));
        } catch (Exception e) {
            assertEquals("id must be a valid integer", e.getMessage());
        }
    }

    //name
    @Test
    public void testAddInvalidNameLength1() {
        ProductBO productBO = new ProductBO();
        try {
            assertFalse(productBO.add("1", "VeryLongProductName3333", "Title2", "10", "5", "15"));
        } catch (Exception e) {
            assertEquals("name length must be < 10 and > 0", e.getMessage());
        }
    }

    @Test
    public void testAddInvalidNameLength2() {
        ProductBO productBO = new ProductBO();
        try {
            assertFalse(productBO.add("1", "", "Title2", "10", "5", "15"));
        } catch (Exception e) {
            assertEquals("name length must be < 10 and > 0", e.getMessage());
        }
    }

    @Test
    public void testAddInvalidNameLength3() {
        ProductBO productBO = new ProductBO();
        try {
            assertFalse(productBO.add("1", null, "Title2", "10", "5", "15"));
        } catch (Exception e) {
            assertEquals("name length must be < 10 and > 0", e.getMessage());
        }
    }

    //title
    @Test
    public void testAddInvalidTitleLength1() {
        ProductBO productBO = new ProductBO();
        try {
            assertFalse(productBO.add("1", "Product3", "", "10", "5", "15"));
        } catch (Exception e) {
            assertEquals("title length must be < 10 and > 0", e.getMessage());
        }
    }

    @Test
    public void testAddInvalidTitleLength2() {
        ProductBO productBO = new ProductBO();
        try {
            assertFalse(productBO.add("1", "Product3", "VeryLongProductTitle11111", "10", "5", "15"));
        } catch (Exception e) {
            assertEquals("title length must be < 10 and > 0", e.getMessage());
        }
    }

    @Test
    public void testAddInvalidTitleLength3() {
        ProductBO productBO = new ProductBO();
        try {
            assertFalse(productBO.add("1", "Product3", null, "10", "5", "15"));
        } catch (Exception e) {
            assertEquals("title length must be < 10 and > 0", e.getMessage());
        }
    }

    // price
    @Test
    public void testAddInvalidPrice1() {
        ProductBO productBO = new ProductBO();
        try {
            assertFalse(productBO.add("1", "Product4", "Title4", "-1", "5", "15"));
        } catch (Exception e) {
            assertEquals("price must be > 0", e.getMessage());
        }
    }

    @Test
    public void testAddInvalidPrice2() {
        ProductBO productBO = new ProductBO();
        try {
            assertFalse(productBO.add("1", "Product4", "Title4", "0", "5", "15"));
        } catch (Exception e) {
            assertEquals("price must be > 0", e.getMessage());
        }
    }

    @Test
    public void testAddInvalidPrice3() {
        ProductBO productBO = new ProductBO();
        try {
            assertTrue(productBO.add("1", "Product4", "Title4", "1", "5", "15"));
        } catch (Exception e) {
            assertEquals("price must be > 0", e.getMessage());
        }
    }

    @Test
    public void testAddInvalidPrice4() {
        ProductBO productBO = new ProductBO();
        try {
            assertFalse(productBO.add("1", "Product4", "Title4", "60", "5", "15"));
        } catch (Exception e) {
            assertEquals("price must be > 0", e.getMessage());
        }
    }

    @Test
    public void testAddInvalidPrice5() {
        ProductBO productBO = new ProductBO();
        try {
            assertFalse(productBO.add("1", "Product4", "Title4", null, "5", "15"));
        } catch (Exception e) {
            assertEquals("input must be a valid integer", e.getMessage());
        }
    }

    @Test
    public void testAddInvalidPrice6() {
        ProductBO productBO = new ProductBO();
        try {
            assertFalse(productBO.add("1", "Product4", "Title4", "", "5", "15"));
        } catch (Exception e) {
            assertEquals("input must be a valid integer", e.getMessage());
        }
    }

    @Test
    public void testAddInvalidPrice7() {
        ProductBO productBO = new ProductBO();
        try {
            assertFalse(productBO.add("1", "Product4", "Title4", "", "abc5", "15"));
        } catch (Exception e) {
            assertEquals("input must be a valid integer", e.getMessage());
        }
    }

    // stock
    @Test
    public void testAddInvalidStock1() {
        ProductBO productBO = new ProductBO();
        try {
            assertFalse(productBO.add("1", "Product5", "Title5", "10", "-1", "15"));
        } catch (Exception e) {
            assertEquals("stock must be > 0 and < 50", e.getMessage());
        }
    }

    @Test
    public void testAddInvalidStock2() {
        ProductBO productBO = new ProductBO();
        try {
            assertFalse(productBO.add("1", "Product5", "Title5", "10", "0", "15"));
        } catch (Exception e) {
            assertEquals("stock must be > 0 and < 50", e.getMessage());
        }
    }

    @Test
    public void testAddInvalidStock3() {
        ProductBO productBO = new ProductBO();
        try {
            assertTrue(productBO.add("1", "Product5", "Title5", "10", "5", "15"));
        } catch (Exception e) {
            assertEquals("stock must be > 0 and < 50", e.getMessage());
        }
    }

    @Test
    public void testAddInvalidStock4() {
        ProductBO productBO = new ProductBO();
        try {
            assertFalse(productBO.add("1", "Product5", "Title5", "10", "50", "15"));
        } catch (Exception e) {
            assertEquals("stock must be > 0 and < 50", e.getMessage());
        }
    }

    @Test
    public void testAddInvalidStock5() {
        ProductBO productBO = new ProductBO();
        try {
            assertFalse(productBO.add("1", "Product5", "Title5", "10", "60", "15"));
        } catch (Exception e) {
            assertEquals("stock must be > 0 and < 50", e.getMessage());
        }
    }

    @Test
    public void testAddInvalidStock6() {
        ProductBO productBO = new ProductBO();
        try {
            assertFalse(productBO.add("1", "Product5", "Title5", "10", "", "15"));
        } catch (Exception e) {
            assertEquals("input must be a valid integer", e.getMessage());
        }
    }

    @Test
    public void testAddInvalidStock7() {
        ProductBO productBO = new ProductBO();
        try {
            assertFalse(productBO.add("1", "Product5", "Title5", "10", null, "15"));
        } catch (Exception e) {
            assertEquals("input must be a valid integer", e.getMessage());
        }
    }

    @Test
    public void testAddInvalidStock8() {
        ProductBO productBO = new ProductBO();
        try {
            assertFalse(productBO.add("1", "Product5", "Title5", "10", "abc", "15"));
        } catch (Exception e) {
            assertEquals("input must be a valid integer", e.getMessage());
        }
    }

    // quantity
    @Test
    public void testAddInvalidQuantity1() {
        ProductBO productBO = new ProductBO();
        try {
            assertFalse(productBO.add("1", "Product6", "Title6", "10", "5", "-1"));
        } catch (Exception e) {
            assertEquals("quantity must be > 0 and < 20", e.getMessage());
        }
    }

    @Test
    public void testAddInvalidQuantity2() {
        ProductBO productBO = new ProductBO();
        try {
            assertFalse(productBO.add("1", "Product6", "Title6", "10", "5", "0"));
        } catch (Exception e) {
            assertEquals("quantity must be > 0 and < 20", e.getMessage());
        }
    }

    @Test
    public void testAddInvalidQuantity3() {
        ProductBO productBO = new ProductBO();
        try {
            assertTrue(productBO.add("1", "Product6", "Title6", "10", "5", "15"));
        } catch (Exception e) {
            assertEquals("quantity must be > 0 and < 20", e.getMessage());
        }
    }

    @Test
    public void testAddInvalidQuantity4() {
        ProductBO productBO = new ProductBO();
        try {
            assertFalse(productBO.add("1", "Product6", "Title6", "20", "10", "20"));
        } catch (Exception e) {
            assertEquals("quantity must be > 0 and < 20", e.getMessage());
        }
    }

    @Test
    public void testAddInvalidQuantity5() {
        ProductBO productBO = new ProductBO();
        try {
            assertFalse(productBO.add("1", "Product6", "Title6", "20", "10", "60"));
        } catch (Exception e) {
            assertEquals("quantity must be > 0 and < 20", e.getMessage());
        }
    }

    @Test
    public void testAddInvalidQuantity6() {
        ProductBO productBO = new ProductBO();
        try {
            assertFalse(productBO.add("1", "Product6", "Title6", "20", "10", null));
        } catch (Exception e) {
            assertEquals("input must be a valid integer", e.getMessage());
        }
    }

    @Test
    public void testAddInvalidQuantity7() {
        ProductBO productBO = new ProductBO();
        try {
            assertFalse(productBO.add("1", "Product6", "Title6", "20", "10", ""));
        } catch (Exception e) {
            assertEquals("input must be a valid integer", e.getMessage());
        }
    }

    @Test
    public void testAddInvalidQuantity8() {
        ProductBO productBO = new ProductBO();
        try {
            assertFalse(productBO.add("1", "Product6", "Title6", "20", "10", "abc"));
        } catch (Exception e) {
            assertEquals("input must be a valid integer", e.getMessage());
        }
    }

    //delete
    @Test
    public void testDeleteValidID() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(2, "Product2", "Title2", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertTrue(productBO.delete("2"));
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testDeleteInvalidID1() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(2, "Product2", "Title2", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertFalse(productBO.delete("-1"));
        } catch (Exception e) {
            assertEquals("id must be > 0 and < 1000", e.getMessage());
        }
    }

    @Test
    public void testDeleteOutOfRangeID2() {
        ProductBO productBO = new ProductBO();

        try {
            assertFalse(productBO.delete("1000"));
        } catch (Exception e) {
            assertEquals("id must be > 0 and < 1000", e.getMessage());
        }
    }

    @Test
    public void testDeleteOutOfRangeID3() {
        ProductBO productBO = new ProductBO();

        try {
            assertFalse(productBO.delete(""));
        } catch (Exception e) {
            assertEquals("id must be a valid integer", e.getMessage());
        }
    }

    @Test
    public void testDeleteOutOfRangeID4() {
        ProductBO productBO = new ProductBO();

        try {
            assertFalse(productBO.delete(null));
        } catch (Exception e) {
            assertEquals("id must be a valid integer", e.getMessage());
        }
    }

    @Test
    public void testDeleteOutOfRangeID5() {
        ProductBO productBO = new ProductBO();

        try {
            assertFalse(productBO.delete("abc"));
        } catch (Exception e) {
            assertEquals("id must be a valid integer", e.getMessage());
        }
    }

    //get 
    @Test
    public void testGetExistingProduct1() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(2, "Product2", "Title2", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertNotNull(productBO.get("2"));
        } catch (Exception e) {
            assertEquals("id must be > 0 and < 1000", e.getMessage());
        }
    }

    @Test
    public void testGetNonExistingProduct2() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(2, "Product2", "Title2", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertNull(productBO.get("-1"));
        } catch (Exception ex) {
            assertEquals("id must be > 0 and < 1000", ex.getMessage());
        }
    }

    @Test
    public void testGetNonExistingProduct3() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(2, "Product2", "Title2", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertNull(productBO.get("abc"));
        } catch (Exception ex) {
            assertEquals("id must be a valid integer", ex.getMessage());
        }
    }

    @Test
    public void testGetNonExistingProduct4() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(2, "Product2", "Title2", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertNull(productBO.get(null));
        } catch (Exception ex) {
            assertEquals("id cannot be null", ex.getMessage());
        }
    }

    @Test
    public void testGetNonExistingProduct5() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(2, "Product2", "Title2", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertNull(productBO.get(""));
        } catch (Exception ex) {
            assertEquals("id must be a valid integer", ex.getMessage());
        }
    }

    @Test
    public void testGetNonExistingProduct6() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(2, "Product2", "Title2", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertNull(productBO.get("3"));
        } catch (Exception ex) {
            assertEquals("id must be > 0 and < 1000", ex.getMessage());
        }
    }

    @Test
    public void testGetNonExistingProduct7() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(2, "Product2", "Title2", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertNull(productBO.get("1001"));
        } catch (Exception ex) {
            assertEquals("id must be > 0 and < 1000", ex.getMessage());
        }
    }

    // get all product
    @Test
    public void testGetAllProducts() {
        ProductBO productBO = new ProductBO();
        Product product1 = new Product(1, "Product1", "Title1", "20", "10", "60");
        Product product2 = new Product(2, "Product2", "Title2", "20", "10", "60");
        productBO.getListProduct().add(product1);
        productBO.getListProduct().add(product2);

        List<Product> allProducts = productBO.getListProduct();

        assertEquals(2, allProducts.size());
        assertTrue(allProducts.contains(product1));
        assertTrue(allProducts.contains(product2));
    }

    @Test
    public void testGetInvalidProducts1() {
        ProductBO productBO = new ProductBO();
        Product product1 = new Product(1, "Product1", "Title1", "20", "10", "60");
        Product product2 = new Product(2, "Product2", "Title2", "20", "10", "60");
        productBO.getListProduct().add(product1);
//        productBO.getListProduct().add(product2);

        List<Product> allProducts = productBO.getListProduct();

        assertEquals(1, allProducts.size());
        assertTrue(allProducts.contains(product1));
        assertFalse(allProducts.contains(product2));
    }

    //update
    @Test
    public void testUpdateValidProduct() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(1, "Product1", "Title1", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertTrue(productBO.update("1", "UpdatedName", "UpdatedTitle", "30", "15", "8"));
            Product updatedProduct = productBO.get("1");
            assertEquals("UpdatedName", updatedProduct.getName());
            assertEquals("UpdatedTitle", updatedProduct.getTitle());
            assertEquals(30, updatedProduct.getPrice());
            assertEquals(15, updatedProduct.getStock());
            assertEquals(8, updatedProduct.getQuantity());
        } catch (Exception e) {
            assertEquals("Invalid name", e.getMessage());
        }
    }

    @Test
    public void testUpdateNonExistingProduct() {
        ProductBO productBO = new ProductBO();

        try {
            assertFalse(productBO.update("1", "UpdatedName", "UpdatedTitle", "30", "15", "8"));
        } catch (Exception e) {
            assertEquals("Product not found", e.getMessage());
        }
    }

    // update id
    @Test
    public void testUpdateInvalidID1() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(1, "Product1", "Title1", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertFalse(productBO.update("-1", "", "UpdatedTitle", "30", "15", "8"));
        } catch (Exception e) {
            assertEquals("id must be > 0 and < 1000", e.getMessage());
        }
    }

    @Test
    public void testUpdateInvalidID2() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(1, "Product1", "Title1", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertFalse(productBO.update("1001", "", "UpdatedTitle", "30", "15", "8"));
        } catch (Exception e) {
            assertEquals("id must be > 0 and < 1000", e.getMessage());
        }
    }

    @Test
    public void testUpdateInvalidID3() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(1, "Product1", "Title1", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertFalse(productBO.update("100", "", "UpdatedTitle", "30", "15", "8"));
        } catch (Exception e) {
            assertEquals("Product not found", e.getMessage());
        }
    }

    @Test
    public void testUpdateInvalidID4() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(1, "Product1", "Title1", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertFalse(productBO.update("", "", "UpdatedTitle", "30", "15", "8"));
        } catch (Exception e) {
            assertEquals("Input must be a valid integer", e.getMessage());
        }
    }

    @Test
    public void testUpdateInvalidID5() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(1, "Product1", "Title1", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertFalse(productBO.update("abcc", "", "UpdatedTitle", "30", "15", "8"));
        } catch (Exception e) {
            assertEquals("Input must be a valid integer", e.getMessage());
        }
    }

    @Test
    public void testUpdateInvalidID6() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(1, "Product1", "Title1", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertFalse(productBO.update(null, "", "UpdatedTitle", "30", "15", "8"));
        } catch (Exception e) {
            assertEquals("Input must be a valid integer", e.getMessage());
        }
    }

    // update name
    @Test
    public void testUpdateInvalidName1() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(1, "Product1", "Title1", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertFalse(productBO.update("1", "", "UpdatedTitle", "30", "15", "8"));
        } catch (Exception e) {
            assertEquals("Invalid name", e.getMessage());
        }
    }

    @Test
    public void testUpdateInvalidName2() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(1, "Product1", "Title1", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertFalse(productBO.update("1", null, "UpdatedTitle", "30", "15", "8"));
        } catch (Exception e) {
            assertEquals("Invalid name", e.getMessage());
        }
    }

    @Test
    public void testUpdateInvalidName3() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(1, "Product1", "Title1", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertFalse(productBO.update("1", "largeTilteInvalidLength1111", "UpdatedTitle", "30", "15", "8"));
        } catch (Exception e) {
            assertEquals("Invalid name", e.getMessage());
        }
    }

    // update title
    @Test
    public void testUpdateInvalidTitle1() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(1, "Product1", "Title1", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertFalse(productBO.update("1", "UpdaedName", null, "30", "15", "8"));
        } catch (Exception e) {
            assertEquals("Invalid name", e.getMessage());
        }
    }

    @Test
    public void testUpdateInvalidTitle2() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(1, "Produc1", "Title1", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertFalse(productBO.update("1", "UpdatedName", "", "30", "15", "8"));
        } catch (Exception e) {
            assertEquals("Invalid name", e.getMessage());
        }
    }

    @Test
    public void testUpdateInvalidTitle3() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(1, "Product1", "Title1", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertFalse(productBO.update("1", "UpdatedName", "InvalidTitleLength121sabkajsbkas", "30", "15", "8"));
        } catch (Exception e) {
            assertEquals("Invalid name", e.getMessage());
        }
    }

    //update price
    @Test
    public void testUpdateInvalidPrice() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(1, "Product1", "Title1", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertFalse(productBO.update("1", "UpName", "UpdatedTitle", "-5", "15", "8"));
        } catch (Exception e) {
            assertEquals("Invalid price, stock, or quantity", e.getMessage());
        }
    }

    @Test
    public void testUpdateInvalidPrice2() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(1, "Product1", "Title1", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertTrue(productBO.update("1", "Name", "UpdatedTitle", "12", "15", "8"));
        } catch (Exception e) {
            assertEquals("Invalid price, stock, or quantity", e.getMessage());
        }
    }

    @Test
    public void testUpdateInvalidPrice3() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(1, "Product1", "Title1", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertFalse(productBO.update("1", "Name", "UpdatedTitle", "50", "15", "8"));
        } catch (Exception e) {
            assertEquals("Invalid price, stock, or quantity", e.getMessage());
        }
    }

    @Test
    public void testUpdateInvalidPrice4() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(1, "Product1", "Title1", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertFalse(productBO.update("1", "Name", "UpdatedTitle", "", "15", "8"));
        } catch (Exception e) {
            assertEquals("Input must be a valid integer", e.getMessage());
        }
    }

    @Test
    public void testUpdateInvalidPrice5() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(1, "Product1", "Title1", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertFalse(productBO.update("1", "Name", "UpdatedTitle", null, "15", "8"));
        } catch (Exception e) {
            assertEquals("Input must be a valid integer", e.getMessage());
        }
    }

    @Test
    public void testUpdateInvalidPrice6() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(1, "Product1", "Title1", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertFalse(productBO.update("1", "Name", "UpdatedTitle", "abc", "15", "8"));
        } catch (Exception e) {
            assertEquals("Input must be a valid integer", e.getMessage());
        }
        
    }

    //update stock
    @Test
    public void testUpdateInvalidStock1() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(1, "Product1", "Title1", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertFalse(productBO.update("1", "UpName", "UpdatedTitle", "5", "-5", "8"));
        } catch (Exception e) {
            assertEquals("Invalid price, stock, or quantity", e.getMessage());
        }
    }

    @Test
    public void testUpdateInvalidStock2() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(1, "Product1", "Title1", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertTrue(productBO.update("1", "UpName", "UpdatedTitle", "5", "15", "8"));
        } catch (Exception e) {
            assertEquals("Invalid price, stock, or quantity", e.getMessage());
        }
    }

    @Test
    public void testUpdateInvalidStock3() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(1, "Product1", "Title1", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertFalse(productBO.update("1", "UpName", "UpdatedTitle", "5", "59", "8"));
        } catch (Exception e) {
            assertEquals("Invalid price, stock, or quantity", e.getMessage());
        }
    }

    @Test
    public void testUpdateInvalidStock4() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(1, "Product1", "Title1", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertFalse(productBO.update("1", "UpName", "UpdatedTitle", "5", "", "8"));
        } catch (Exception e) {
            assertEquals("Input must be a valid integer", e.getMessage());
        }
    }

    @Test
    public void testUpdateInvalidStock5() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(1, "Product1", "Title1", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertFalse(productBO.update("1", "UpName", "UpdatedTitle", "5", "avca", "8"));
        } catch (Exception e) {
            assertEquals("Input must be a valid integer", e.getMessage());
        }
    }

    @Test
    public void testUpdateInvalidStock6() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(1, "Product1", "Title1", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertFalse(productBO.update("1", "UpName", "UpdatedTitle", "5", null, "8"));
        } catch (Exception e) {
            assertEquals("Input must be a valid integer", e.getMessage());
        }
    }

    //update quantity
    @Test
    public void testUpdateInvalidQuantity1() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(1, "Product1", "Title1", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertFalse(productBO.update("1", "UpName", "UpdatedTitle", "5", "15", "-1"));
        } catch (Exception e) {
            assertEquals("Invalid price, stock, or quantity", e.getMessage());
        }
    }

    @Test
    public void testUpdateInvalidQuantity2() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(1, "Product1", "Title1", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertFalse(productBO.update("1", "UpName", "UpdatedTitle", "5", "15", "100"));
        } catch (Exception e) {
            assertEquals("Invalid price, stock, or quantity", e.getMessage());
        }
    }

    @Test
    public void testUpdateInvalidQuantity3() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(1, "Product1", "Title1", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertFalse(productBO.update("1", "UpName", "UpdatedTitle", "5", "15", ""));
        } catch (Exception e) {
            assertEquals("Input must be a valid integer", e.getMessage());
        }
    }

    @Test
    public void testUpdateInvalidQuantity4() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(1, "Product1", "Title1", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertFalse(productBO.update("1", "UpName", "UpdatedTitle", "5", "15", "abcc"));
        } catch (Exception e) {
            assertEquals("Input must be a valid integer", e.getMessage());
        }
    }

    @Test
    public void testUpdateInvalidQuantity5() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(1, "Product1", "Title1", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertFalse(productBO.update("1", "UpName", "UpdatedTitle", "5", "15", null));
        } catch (Exception e) {
            assertEquals("Input must be a valid integer", e.getMessage());
        }
    }

    @Test
    public void testUpdateInvalidQuantity6() {
        ProductBO productBO = new ProductBO();
        Product product = new Product(1, "Product1", "Title1", "20", "10", "60");
        productBO.getListProduct().add(product);

        try {
            assertTrue(productBO.update("1", "UpName", "UpdatedTitle", "5", "15", "12"));
        } catch (Exception e) {
            assertEquals("Input must be a valid integer", e.getMessage());
        }
    }
}
