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
    private static int productCount = 0;

    public Product create(Product product) {
        product.setProductId(Integer.toString(productCount));
        productCount++;
        productData.add(product);
        return product;
    }
    public Product edit(Product editedProduct) {
        String productId = editedProduct.getProductId();
        for (Product currentProduct : productData) {
            if (productId.equals(currentProduct.getProductId())) {
                currentProduct.setProductName(editedProduct.getProductName());
                currentProduct.setProductQuantity(editedProduct.getProductQuantity());
                return currentProduct;
            }
        }
        throw new NoSuchElementException("Product not found with ID: " + productId);
    }

    public  Iterator<Product> findAll() {
        return  productData.iterator();
    }
}
