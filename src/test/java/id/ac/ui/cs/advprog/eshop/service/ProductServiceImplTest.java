package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {


    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(2);
        product.setProductId("696969");

        List<Product> productList = Arrays.asList(product);
        when(productRepository.findAll()).thenReturn(productList.iterator());

        List<Product> productListService = productService.findAll();

        assertFalse(productListService.isEmpty());
        verify(productRepository, times(1)).findAll();
    }
    @Test
    void testFindAllIfEmpty() {
        when(productRepository.findAll()).thenReturn(Collections.emptyIterator());
        List<Product> productList = productService.findAll();

        // Assert that the returned list is empty
        assertTrue(productList.isEmpty());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productService.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productService.create(product2);

        List<Product> productList = Arrays.asList(product1, product2);

        when(productRepository.findAll()).thenReturn(productList.iterator());
        List <Product> productListService = productService.findAll();
        assertFalse(productList.isEmpty());
        assertEquals(productListService.get(0).getProductId(),product1.getProductId());
        assertEquals(productListService.get(1).getProductId(),product2.getProductId());
    }

    @Test
    void testEdit() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productService.create(product);
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");

        Product editedProduct = new Product();
        editedProduct.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        editedProduct.setProductName("Sampo Cap Rafli");
        editedProduct.setProductQuantity(69);

        when(productRepository.edit(editedProduct)).thenReturn(editedProduct);
        Product updatedProduct = productService.edit(editedProduct);

        assertEquals(editedProduct.getProductName(), updatedProduct.getProductName());
        assertEquals(editedProduct.getProductQuantity(), updatedProduct.getProductQuantity());
        assertEquals(editedProduct.getProductId(), updatedProduct.getProductId());
        verify(productRepository, times(1)).edit(editedProduct);
    }
    @Test
    void testDeleteProduct() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productService.create(product);

        when(productRepository.delete(product)).thenReturn(product);

        Product deletedProduct = productService.delete(product);

        assertEquals(product, deletedProduct);
        verify(productRepository, times(1)).delete(product);
    }
    @Test
    void testFindById() {
        Product product1 = new Product();
        product1.setProductName("Sampo Cap Budi");
        product1.setProductQuantity(6);
        product1.setProductId("konz");

        Product product2 = new Product();
        product2.setProductName("Sampo Cap Badak");
        product2.setProductQuantity(9);
        product2.setProductId("znok");

        List<Product> productList = Arrays.asList(product1, product2);
        when(productRepository.findAll()).thenReturn(productList.iterator());

        Product searchedProduct = productService.findById("konz");
        assertEquals(searchedProduct, product1);

        assertThrows(
                NoSuchElementException.class,
                () -> productService.findById("aku wibu")
        );

    }
}