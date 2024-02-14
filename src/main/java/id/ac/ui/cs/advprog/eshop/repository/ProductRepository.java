package id.ac.ui.cs.advprog.eshop.repository;

import  id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();
    private int productCount = 0;

    public Product create(Product product) {
        product.setProductId(Integer.toString(productCount));
        productCount++;
        productData.add(product);
        return product;
    }
    public Product findById(String productId) {
        for (Product currentProduct : productData) {
            if (productId.equals(currentProduct.getProductId())) {
                return currentProduct;
            }
        }
        throw new NoSuchElementException("Product not found with ID: " + productId);
    }
    public Product edit(Product editedProduct) {
        String productId = editedProduct.getProductId();
        Product product = findById(productId);
        product.setProductName(editedProduct.getProductName());
        product.setProductQuantity(editedProduct.getProductQuantity());
        return  product;
    }

    public  Iterator<Product> findAll() {
        return  productData.iterator();
    }

    public Product delete(Product product) {
        String productId = product.getProductId();
        Product productToDelete = findById(productId);
        productData.remove(productToDelete);
        return productToDelete;
    }
}
